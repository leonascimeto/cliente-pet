package br.com.petz.clientepet.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class RestResponseEntityExceptionHandler {
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorApiResponse> handlerGenericException(ApiException ex){
		return ex.buildErrorResponseEntity();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorApiResponse> handlerGenericException(Exception ex){
		log.error("Exception: ", ex);
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ErrorApiResponse.builder()
						.descrition("INTERNAL SERVER ERROR")
						.message("PLEASE CONTACT SUPPORT!")
						.build());
	}
}