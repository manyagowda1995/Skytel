package com.SkytelTeleService.AssignementForSkytelTeleService.exception;

import com.SkytelTeleService.AssignementForSkytelTeleService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobleExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> HandleAllException(Exception exception){
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(),false);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
