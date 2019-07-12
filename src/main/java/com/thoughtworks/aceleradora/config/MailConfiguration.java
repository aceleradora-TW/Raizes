package com.thoughtworks.aceleradora.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Configuration
public class MailConfiguration {

    @Component
    public class MailConfig {

        @Value("${spring.mail.default-encoding}")
        private String defaultEncoding;

        @Value("${spring.mail.host}")
        private String host;

        @Value("${spring.mail.username}")
        private String username;

        @Value("${spring.mail.password}")
        private String password;

        @Value("${spring.mail.port}")
        private Integer port;

        @Value("${spring.mail.properties.mail.debug}")
        private Boolean debug;

        @Value("${spring.mail.properties.mail.smtp.auth}")
        private Boolean auth;

        @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
        private Boolean starttlsEnable;

        @Value("${spring.mail.properties.mail.transport.protocol}")
        private String transportProtocol;
    }

    @Bean
    public JavaMailSender mailSender(MailConfig mailConfig) {

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(mailConfig.host);
        sender.setPort(mailConfig.port);
        sender.setUsername(mailConfig.username);
        sender.setPassword(mailConfig.password);
        sender.setDefaultEncoding(mailConfig.defaultEncoding);

        Properties props = sender.getJavaMailProperties();

        props.put("mail.transport.protocol", mailConfig.transportProtocol);
        props.put("mail.smtp.auth", mailConfig.auth);
        props.put("mail.smtp.starttls.enable", mailConfig.starttlsEnable);
        props.put("mail.debug", mailConfig.debug);

        return sender;
    }
}
