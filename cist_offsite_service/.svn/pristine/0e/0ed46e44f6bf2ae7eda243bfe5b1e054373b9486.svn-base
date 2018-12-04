package com.cist.policeofficer.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.picture.mapper.PictureMapper;
import com.cist.picture.model.C_plate_type;
import com.cist.picture.model.Depart_info;
import com.cist.picture.model.MenuDetails;
import com.cist.picture.model.Monitorpoint;
import com.cist.picture.model.Tbl_offe_cate;
import com.cist.picture.model.Tbl_offe_evdi;
import com.cist.picture.service.PictureService;
import com.cist.policeofficer.mapper.PoliceofficerMapper;
import com.cist.policeofficer.model.SysPoliceInfo;
import com.cist.policeofficer.service.PoliceofficerService;


@Service
public class PoliceofficerServiceImpl implements PoliceofficerService  {

	@Autowired
	private PoliceofficerMapper mapper;

	@Override
	public SysPoliceInfo policeLogin(HashMap<String, Object> map) {
		return mapper.policeLogin(map);
	}
	
}
