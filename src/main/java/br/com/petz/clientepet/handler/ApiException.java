package br.com.petz.clientepet.handler;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Getter
@Log4j2
public class ApiException extends RuntimeException {
	private ErrorApiResponse bodyException;
	private HttpStatusCode statusException;
	
	private ApiException(HttpStatus statusException, String message, Exception ex) {
		super(message, ex);
		this.statusException = statusException;
		this.bodyException = ErrorApiResponse.builder()
				.message(message)
				.descrition(getDescription(ex))
				.build();
	}
	
	public static ApiException build(HttpStatus statusException, String message) {
		return new ApiException(statusException, message, null);
	}
	
	public static ApiException build(HttpStatus statusException, String message, Exception ex) {
		log.error("Exception: ", ex);
		return new ApiException(statusException, message, ex);
	}

	private String getDescription(Exception ex) {
		return Optional.ofNullable(ex)
				.map(ApiException::getMessageCause).orElse(null);
	}
	
	private static String getMessageCause(Exception ex) {
		return ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage();
	}

	public ResponseEntity<ErrorApiResponse> buildErrorResponseEntity() {
		return ResponseEntity.status(statusException).body(bodyException);
	}
	
	private static final long serialVersionUID = 1L;
	
}
