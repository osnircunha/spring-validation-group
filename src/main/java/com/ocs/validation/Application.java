package com.ocs.validation;

import com.ocs.validation.model.PayloadMessage;
import com.ocs.validation.validate.filter.Create;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@Slf4j
@Validated
@RestController
@SpringBootApplication
@RequestMapping("/message")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostMapping
    @Validated(Create.class)
    public ResponseEntity<Void> save(@Valid @RequestBody PayloadMessage payloadMessage) {
        log.info(payloadMessage.toString());
        return ResponseEntity.status(CREATED).build();
    }


    @PutMapping
    public ResponseEntity<PayloadMessage> update(@Valid @RequestBody PayloadMessage payloadMessage) {
        log.info(payloadMessage.toString());
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
