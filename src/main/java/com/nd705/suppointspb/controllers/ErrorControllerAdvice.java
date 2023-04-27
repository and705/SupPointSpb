package com.nd705.suppointspb.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ErrorControllerAdvice {
    private org.springframework.http.HttpStatus HttpStatus;
    @ExceptionHandler(Exception.class)
    @ResponseStatus(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
    public String exeption(Exception exception, Model model){
        String errorMessage = (exception != null? exception.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }
}
