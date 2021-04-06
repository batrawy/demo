package com.example.orangetest.exception;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ResourceNotFoundExcepation.class})
    public ResponseEntity<Object> handleResourceNotFoundExcepation( ResourceNotFoundExcepation e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        // create payLoad

        ExcepationPayload payload =
                new ExcepationPayload(e.getMessage(), httpStatus);
        return new ResponseEntity<>(payload, httpStatus);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {InsufficientBalance.class})
    public ResponseEntity<Object> handleinsufficientBalance( InsufficientBalance e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;


        ExcepationPayload payload =
                new ExcepationPayload(e.getMessage(), httpStatus);
        return new ResponseEntity<>(payload, httpStatus);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity <Object> onConstraintValidationException(ConstraintViolationException constraintViolationException) {
        Map<String, String> response = new HashMap<>();
        for (ConstraintViolation violation : constraintViolationException.getConstraintViolations()) {
            response.put(((PathImpl) violation.getPropertyPath()).getLeafNode().getName(), violation.getMessage());
        }
        return new ResponseEntity <>(response, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity <Object> onConstraintValidationException(MethodArgumentNotValidException e) {
        Map <String, String> response = new HashMap <>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            response.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity <>(response, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MissingServletRequestParameterException.class)
    ResponseEntity <Object> onMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return new ResponseEntity <>( e.getParameterName(), HttpStatus.BAD_REQUEST);
    }


}
