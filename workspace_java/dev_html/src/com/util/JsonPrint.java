package com.util;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class JsonPrint {
	public String conbersion(List<Map<String,Object>> list) {
		String imsi = null;
		Gson g = new Gson();
		imsi = g.toJson(list);
		return imsi;
	}
	public String conbersion2(List<Object> list) {
		String imsi = null;
		Gson g = new Gson();
		imsi = g.toJson(list);
		return imsi;
	}
}
