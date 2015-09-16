package com.adskom.sdk;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Tracker {
	private String API_SERVER = "http://ava.adskom.com/events";
	private final String path = "b";
	private int account;
	private String eventName;
	private String siteType = "a";			

	public String submit() {				
		RequestHandler client = new RequestHandler();
		JSONObject data = new JSONObject();
		try {
			data.accumulate("account", account);
			data.accumulate("event_name", eventName);
			data.accumulate("site_type", siteType);
		} catch (JSONException e) {
			Log.e("ERROR", e.getMessage());
		}		
        			
		return client.postData(getUrl(), data);
	}

	private String getUrl() {
		return API_SERVER + "/" + path;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
		
}
