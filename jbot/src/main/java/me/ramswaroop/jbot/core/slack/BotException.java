package me.ramswaroop.jbot.core.slack;

import lombok.Data;

@Data
public class BotException extends Exception {

	private final ERRORS errors;

	public BotException(ERRORS errors) {
		super();
		this.errors = errors;
	}

	public enum ERRORS {
		NOT_OK, SERIALIZATION;
	}
}
