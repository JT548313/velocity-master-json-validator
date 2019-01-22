package com.barclays.json.util;

import java.util.ArrayList;

import com.barclays.json.beans.PipelinePattern;

public class DateFormatValidations {
	// Mandatory Regex format : ISO8610
	// LifeTime. Mandatory
	// validFrom: Present/Past Date. Optional
	// ValidTo: Future Date. Optional
	
	public boolean validateDateFormat(ArrayList<PipelinePattern> patternList) {
	// Not required for Pattern JSON		
		return false;
		
	}
}
