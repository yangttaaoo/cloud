package com.cist.personalexamine.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.personalentry.model.IndividualInfo;

public interface PersonalExemineMapper {
	List<IndividualInfo> ExamineInfopageList(HashMap<String,Object> map); 
	String getTopice(int a);
	String getRegulations(int a);
	int examinepersonal(HashMap<String,Object> map);
	char getReport(int a);
}
