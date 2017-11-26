package br.com.mars.robot.web.controller;

import br.com.mars.robot.web.entity.Robot;
import br.com.mars.robot.web.service.RobotService;
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
        Robot robot = robotService.handleCommands(commands);
        return new ResponseEntity<>(robot.getPosition(), HttpStatus.OK);
    }

}
