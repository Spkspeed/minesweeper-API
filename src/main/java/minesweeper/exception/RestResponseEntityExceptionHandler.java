package minesweeper.exception;

import minesweeper.service.MineGameGrid;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    Logger log = Logger.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String message = "Unknown exception error found";

        log.error("RuntimeException was executed", ex);
        log.error(ex.getMessage());

        return handleExceptionInternal(ex, message,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
    @ExceptionHandler(MinesweeperException.class)
    public ResponseEntity<String> handleMarketException(final MinesweeperException e) {
        return error(e, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<String> error(final Exception exception, final HttpStatus httpStatus) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(message, httpStatus);
    }
}