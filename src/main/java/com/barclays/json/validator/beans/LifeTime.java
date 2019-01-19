package com.barclays.json.validator.beans;

import java.util.Date;

public class LifeTime {
	
	Date validFrom;
	Date validTo;
	
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	
}
