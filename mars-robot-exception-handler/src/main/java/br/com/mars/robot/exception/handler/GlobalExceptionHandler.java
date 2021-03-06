package br.com.mars.robot.exception.handler;

import br.com.mars.robot.exception.ExceptionResponse;
import br.com.mars.robot.exception.InvalidPositionException;
import br.com.mars.robot.exception.RobotCommandInvalidException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private final Logger LOG = LogManager.getLogger(this.getClass());

    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({InvalidPositionException.class, RobotCommandInvalidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected void handleRobotException(RuntimeException ex) {
    }

    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleInternalException(RuntimeException ex) {
        LOG.error("500 Status Code", ex);
        return new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }
}
