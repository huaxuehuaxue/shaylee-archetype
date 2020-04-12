package com.shaylee.common.core.base.result;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用响应实体类
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-03-24
 */
@Deprecated
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = -8157613083634272196L;

	public R() {
		put("code", 0);
		put("msg", "success");
	}

	public static R error() {
		return error(500, "未知异常，请联系管理员");
	}

	public static R error(String msg) {
		return error(500, msg);
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R success(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R data(Object obj) {
		R r = new R();
		r.put("data", obj);
		return r;
	}

	public static R success(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}

	public static R success() {
		return new R();
	}

	@Override
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}