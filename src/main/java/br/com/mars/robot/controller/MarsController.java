package br.com.mars.robot.controller;

import br.com.mars.robot.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class MarsController {

    @Autowired
    private RobotService robotService;

    @PostMapping(value = "/{commands}", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity move(@PathVariable("commands") String commands) {
        robotService.handleCommand(commands);
        return new ResponseEntity<>(robotService.getPosition(), HttpStatus.OK);
    }

}
