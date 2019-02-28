package com.cist.devmanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import com.cist.devmanagement.mapper.DevManagementMapper;
import com.cist.devmanagement.service.DevManagementService;
import com.cist.frame.page.PageInfo;

@Service(value = "DevManagementService")
public class DevManagementServiceImpl implements DevManagementService {

	@Autowired
	private DevManagementMapper mapper;

}
