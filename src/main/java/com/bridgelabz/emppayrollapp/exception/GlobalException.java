package com.bridgelabz.emppayrollapp.exception;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.emppayrollapp.util.Response;

@ControllerAdvice
@RestController
public class GlobalException {
	
	@ExceptionHandler(EmployeeException.class)
	public final ResponseEntity<Response> empExceptionFunction (EmployeeException empException){
		
		Response status = new Response(empException.getStatusCode(), empException.getErrormsg());
		return new ResponseEntity<Response>(status, HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> methodArgumentNotValidMap(MethodArgumentNotValidException exception) {
		Map<String, String> errors = new HashMap<>();
		exception.getBindingResult()
				 .getFieldErrors()
				 .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		
		return errors;
	}
}