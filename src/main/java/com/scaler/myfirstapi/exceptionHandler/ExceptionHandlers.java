package com.scaler.myfirstapi.exceptionHandler;

import com.scaler.myfirstapi.Dto.ExceptionDto;
import com.scaler.myfirstapi.Dto.ProductNotFoundExceptionDto;
import com.scaler.myfirstapi.Expection.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("ArithmeticException");
        exceptionDto.setResolution("Something went wrong");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
       return responseEntity;
    }
    @ExceptionHandler(ProductNotFoundException.class)
public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException() {
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setMessage("Product with this id not found");
        return new ResponseEntity<>(productNotFoundExceptionDto, HttpStatus.NOT_FOUND);
    }
}
