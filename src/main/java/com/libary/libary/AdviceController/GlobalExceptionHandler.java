package com.libary.libary.AdviceController;
import com.libary.libary.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFound ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleUsereNotFoundException(UserNotFound ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BookIsNotAvailable.class)
    public ResponseEntity<String> handleBookNotAvailableException(BookIsNotAvailable ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BookIsAvailable.class)
    public ResponseEntity<?> handleBookAvailableException(BookIsAvailable ex)
    {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserExist.class)
    public ResponseEntity<?> handleUserExistException(UserExist ex)
    {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
    }
    @ExceptionHandler(InvalidMobileNumber.class)
    public ResponseEntity<String> handleInvalidMobileNumber(InvalidMobileNumber ex)
    {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}




