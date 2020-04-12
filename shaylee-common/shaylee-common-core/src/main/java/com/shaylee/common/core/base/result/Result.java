package com.shaylee.common.core.base.result;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 通用响应实体类
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-03-24
 */
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Result<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private int code;

	@Getter
	@Setter
	private String msg;

	@Getter
	@Setter
	private T data;

	public static <T> Result<T> success() {
		return restResult(null, 200, null);
	}

	public static <T> Result<T> success(T data) {
		return restResult(data, 200, null);
	}

	public static <T> Result<T> success(T data, String msg) {
		return restResult(data, 200, msg);
	}

	public static <T> Result<T> error() {
		return restResult(null, 500, "未知异常，请联系管理员");
	}

	public static <T> Result<T> error(String msg) {
		return restResult(null, 500, msg);
	}

	public static <T> Result<T> error(T data) {
		return restResult(data, 500, null);
	}

	public static <T> Result<T> error(T data, String msg) {
		return restResult(data, 500, msg);
	}

	private static <T> Result<T> restResult(T data, int code, String msg) {
		Result<T> apiResult = new Result<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setMsg(msg);
		return apiResult;
	}
}