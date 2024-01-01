package com.banquito.core.banking.seguridadcliente.controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MailController {

  private final JavaMailSender mail;

  public MailController(JavaMailSender mail) {
    this.mail = mail;
  }

  @PostMapping("enviarCorreo")
  public ResponseEntity<?> enviarcorreo(@RequestParam("destino") String destino,
      @RequestParam("codigo") String codigo,
      @RequestParam("nombre") String nombre) {

    MimeMessage mimeMessage = mail.createMimeMessage();

    try {
      MimeMessageHelper helper = new MimeMessageHelper(
          mimeMessage,
          MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
          StandardCharsets.UTF_8.name());
      helper.setTo(destino);
      helper.setFrom("eddyt1999@gmail.com");
      helper.setSubject("CODIGO VERIFICACION BANQUITO");

      String templatePath = "templates/mailTemplate.html";
      String htmlContent = readHtmlTemplate(templatePath);

      htmlContent = htmlContent.replace("{{codigo}}", codigo);
      htmlContent = htmlContent.replace("{{nombre}}", nombre);

      helper.setText(htmlContent, true);

      mail.send(mimeMessage);

      return new ResponseEntity<>(true, HttpStatus.OK);
    } catch (MessagingException | IOException e) {
      e.printStackTrace();
      return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  private String readHtmlTemplate(String templatePath) throws IOException {
    Resource resource = new ClassPathResource(templatePath);

    if (!resource.exists()) {
      throw new FileNotFoundException("El archivo HTML no existe: " + templatePath);
    }

    byte[] fileBytes = Files.readAllBytes(resource.getFile().toPath());
    return new String(fileBytes, StandardCharsets.UTF_8);
  }

}
