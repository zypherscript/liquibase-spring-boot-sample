package com.example.questionmarks.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = NoSuchElementException.class) //need to create custom exception later
  public ResponseEntity<Object> handleExamNotFoundException(NoSuchElementException ex) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message", "Exam not found");
    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }
}
