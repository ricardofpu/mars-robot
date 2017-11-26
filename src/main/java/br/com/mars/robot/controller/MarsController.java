package br.com.mars.robot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/rest/mars")
public class MarsController {

    @PostMapping(value = "/{command}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity move(@PathVariable("command") String command) {

        return new ResponseEntity(command, HttpStatus.OK);
    }
}
