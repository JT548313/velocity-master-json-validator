package com.barclays.json.validator.beans;

import java.util.ArrayList;

public class StageModule {

	String stage;
	ArrayList<Id> moduleIds = new ArrayList<Id>();
	
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public ArrayList<Id> getModuleIds() {
		return moduleIds;
	}
	public void setModuleIds(ArrayList<Id> moduleIds) {
		this.moduleIds = moduleIds;
	}
	
	
}
