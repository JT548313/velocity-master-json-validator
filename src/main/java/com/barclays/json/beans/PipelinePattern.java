package com.barclays.json.beans;

import java.util.ArrayList;

public class PipelinePattern {

	Id id;
	Display display;
	ArrayList<StageModule> stageModules= new ArrayList<StageModule>();
	
	public Id getId() {
		return id;
	}
	public void setId(Id id) {
		this.id = id;
	}
	public Display getDisplay() {
		return display;
	}
	public void setDisplay(Display display) {
		this.display = display;
	}
	public ArrayList<StageModule> getStageModules() {
		return stageModules;
	}
	public void setStageModules(ArrayList<StageModule> stageModules) {
		this.stageModules = stageModules;
	} 
	
	
	
}
