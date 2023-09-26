package com.ddefilippi.hecho_en_peru_trabalho_3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(HighlightedEntityException.class)
        public ResponseEntity<String> handleHighlightedEntityException(HighlightedEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(TransientEntityException.class)
        public ResponseEntity<String> handleTransientEntityException(TransientEntityException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<String> handleEntityNotFoundedException(EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
}
