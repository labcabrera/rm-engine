package org.lab.rm.engine.model.common;

import java.util.ArrayList;
import java.util.List;

public class Message<I> {

	public static final String CODE_SUCCESS = "200";
	public static final String CODE_GENERIC_ERROR = "500";

	private String code;
	private String message;
	private List<String> info;
	private List<String> errors;
	private List<String> warnings;

	private I payload;

	public Message() {
		code = CODE_SUCCESS;
	}

	public Message(String code) {
		this.code = code;
	}

	public Message(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public Message(String code, String message, I payload) {
		this.code = code;
		this.message = message;
		this.payload = payload;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public I getPayload() {
		return payload;
	}

	public void setPayload(I payload) {
		this.payload = payload;
	}

	public boolean hasErrors() {
		return errors != null && !errors.isEmpty();
	}

	public Message<I> withCode(String code) {
		this.code = code;
		return this;
	}

	public Message<I> withMessage(String message) {
		this.message = message;
		return this;
	}

	public Message<I> withPayload(I payload) {
		this.payload = payload;
		return this;
	}

	public Message<I> addInfo(String value) {
		synchronized (this) {
			if (info == null) {
				info = new ArrayList<String>();
			}
		}
		info.add(value);
		return this;
	}

	public Message<I> addWarning(String value) {
		synchronized (this) {
			if (warnings == null) {
				warnings = new ArrayList<String>();
			}
		}
		warnings.add(value);
		return this;
	}

	public Message<I> addError(String value) {
		synchronized (this) {
			if (errors == null) {
				errors = new ArrayList<String>();
			}
		}
		errors.add(value);
		return this;
	}
}
