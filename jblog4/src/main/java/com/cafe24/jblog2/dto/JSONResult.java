package com.cafe24.jblog2.dto;

import com.cafe24.jblog2.dto.JSONResult;

public class JSONResult {
	private String result; // success, fail
	private String message; // if fail, setting
	private Object data; // if success , data

	public static JSONResult success(Object data) {
		return new JSONResult("success", null, data);
	};

	public static JSONResult fail(String message) {
		return new JSONResult("fail", message, null);
	};

	private JSONResult(String result, String message, Object data) {
		this.result = result;
		this.message = message;
		this.data = data;
	}

	public String getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

	@Override
	public String toString() {
		return "JSONResult [result=" + result + ", message=" + message + ", data=" + data + "]";
	}

}