package com.barclays.json.beans;

import java.util.ArrayList;

public class ValidatorRes {
	
	boolean status;
	ArrayList<Message> msg ;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public ArrayList<Message> getMsg() {
		return msg;
	}
	public void setMsg(ArrayList<Message> msg) {
		this.msg = msg;
	}
	
}
