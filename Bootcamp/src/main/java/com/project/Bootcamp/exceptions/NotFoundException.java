package com.project.Bootcamp.exceptions;

import com.project.Bootcamp.util.MessageUtil;

public class NotFoundException extends RuntimeException {
	
	public NotFoundException() {
		super(MessageUtil.NO_RECORDS_FOUND);
	}

}
