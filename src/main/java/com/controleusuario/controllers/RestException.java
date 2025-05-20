package com.controleusuario.controllers;

import com.controleusuario.exception.GlobalExceptionHandler;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestException extends GlobalExceptionHandler {

    @ExceptionHandler(GlobalExceptionHandler.class)
    public ProblemDetail handleGlobalExceptionHandler(GlobalExceptionHandler e){
        return e.toProblemDetail();
    }
}
