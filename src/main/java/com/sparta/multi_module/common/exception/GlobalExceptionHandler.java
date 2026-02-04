package com.sparta.multi_module.common.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<com.sparta.multi_module.common.response.ApiResponse<?>> handleBusinessException(BusinessException e) {
        return ResponseEntity
                .badRequest()
                .body(com.sparta.multi_module.common.response.ApiResponse.error(e.getErrorCode()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<com.sparta.multi_module.common.response.ApiResponse<?>> handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(com.sparta.multi_module.common.response.ApiResponse.error(ErrorCode.INTERNAL_SERVER_ERROR));
    }
}
