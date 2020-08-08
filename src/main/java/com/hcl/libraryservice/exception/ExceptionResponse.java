/**
 * 
 */
package com.hcl.libraryservice.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author gowtham.v
 *
 * 08-Aug-2020 11:48:50 am
 */
public class ExceptionResponse {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date timestamp;
	private String message;
	private String details;

	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
