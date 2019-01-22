package com.barclays.json.beans;

import java.util.ArrayList;

public class Module {
	Id id;
	Display display;
	Location location;
	String stage;
	LifeTime lifetime;
	ArrayList<Input> Inputs = new ArrayList<Input>();
	
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
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public LifeTime getLifetime() {
		return lifetime;
	}
	public void setLifetime(LifeTime lifetime) {
		this.lifetime = lifetime;
	}
	public ArrayList<Input> getInputs() {
		return Inputs;
	}
	public void setInputs(ArrayList<Input> inputs) {
		Inputs = inputs;
	}
	
}
