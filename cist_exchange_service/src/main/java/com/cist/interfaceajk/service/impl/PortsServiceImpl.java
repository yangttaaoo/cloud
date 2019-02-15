package com.cist.interfaceajk.service.impl;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.interfaceajk.mapper.PortsMapper;
import com.cist.interfaceajk.model.SjgxInterfaces;
import com.cist.interfaceajk.model.Sjgxinterfaceconnect;
import com.cist.interfaceajk.service.PortsService;

@Service
public class PortsServiceImpl implements PortsService  {
	@Autowired
	private PortsMapper mapper;
	@Override
	public List<SjgxInterfaces> listSjgxInterface() {
		return mapper.listSjgxInterface();
	}
	@Override
	public List<SjgxInterfaces> sjgxInterfacecount() {
		return mapper.sjgxInterfacecount();
	}
	@Override
	public List<Sjgxinterfaceconnect> sjgxinterfaceconnect() {
		return mapper.sjgxinterfaceconnect();
	}
	@Override
	public Integer sjgxinterfacez() {
		return mapper.sjgxinterfacez();
	}
	@Override
	public Integer sjgxinterfacej() {
		return mapper.sjgxinterfacej();
	}
	@Override
	public Integer sjgxinterfacertb() {
		return mapper.sjgxinterfacertb();
	}
	@Override
	public List<SjgxInterfaces> listSjgxInterfaceweekday() {
		return mapper.listSjgxInterfaceweekday();
	}
	@Override
	public Integer sjgxinterfacezong() {
		return mapper.sjgxinterfacezong();
	}
	@Override
	public Integer monthly() {
		return mapper.monthly();
	}
	@Override
	public Integer monthlyshang() {
		return mapper.monthlyshang();
	}
	@Override
	public Integer monthlyshangyue() {
		return mapper.monthlyshangyue();
	}
	@Override
	public List<SjgxInterfaces> numberOfranking(HashMap<String,Object> map) {
		return mapper.numberOfranking(map);
	}
	@Override
	public List<SjgxInterfaces> numberOfrankingTop(HashMap<String, Object> map) {
		return mapper.numberOfrankingTop(map);
	}
	@Override
	public Integer kingTop(HashMap<String, Object> map) {
		return mapper.kingTop(map);
	}

}
