package com.controleusuario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UserDataAlreadyExistsException extends GlobalExceptionHandler{

    private final String detail;

    public UserDataAlreadyExistsException(String detail){
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {

        var problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle("Dado de usuário já se encontra em uso");
        problemDetail.setDetail(detail);

        return problemDetail;
    }
}
