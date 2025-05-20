package com.controleusuario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    public ProblemDetail toProblemDetail() {

        var problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setTitle("Internal server error");

        return problemDetail;
    }

    // Erros de validação de campos do DTO
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex) {
//        Map<String, Object> body = new HashMap<>();
//        Map<String, String> errors = new HashMap<>();
//
//        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
//            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
//        }
//
//        body.put("timestamp", LocalDateTime.now());
//        body.put("status", HttpStatus.BAD_REQUEST.value());
//        body.put("error", "Erro de validação");
//        body.put("message", "Dados inválidos");
//        body.put("errors", errors);
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
//    }
//
//    // Erros de entidade não encontrada
//    @ExceptionHandler(javax.persistence.EntityNotFoundException.class)
//    public ResponseEntity<Object> handleEntityNotFound(javax.persistence.EntityNotFoundException ex) {
//        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
//    }
//
//    // Argumentos inválidos, por exemplo: roleRepository.findById(null)
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<Object> handleIllegalArgument(IllegalArgumentException ex) {
//        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
//    }
//
//    // Erros genéricos
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleOtherExceptions(Exception ex) {
//        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno: " + ex.getMessage());
//    }
//
//    // Método auxiliar
//    private ResponseEntity<Object> buildResponse(HttpStatus status, String message) {
//        Map<String, Object> body = new HashMap<>();
//        body.put("timestamp", LocalDateTime.now());
//        body.put("status", status.value());
//        body.put("error", status.getReasonPhrase());
//        body.put("message", message);
//        return ResponseEntity.status(status).body(body);
//    }
//
}
