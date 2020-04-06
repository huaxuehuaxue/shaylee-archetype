package com.shaylee.common.core.base.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Title: 自定义异常
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-04-06
 */
@Getter
@Setter
public class BaseException extends RuntimeException {
	private static final long serialVersionUID = 7476351808093326476L;

	private int code;
	private String msg = "Sorry, problem occurs. Please contact our staff for help.";

	public BaseException(int code) {
		this.code = code;
	}

	public BaseException(int code, Throwable e) {
		super(e);
		this.code = code;
	}

	public BaseException(String msg) {
		super(msg);
		this.code = ErrorCode.INTERNAL_SERVER_ERROR;
		this.msg = msg;
	}

	public BaseException(String msg, Throwable e) {
		super(msg, e);
		this.code = ErrorCode.INTERNAL_SERVER_ERROR;
		this.msg = msg;
	}

}