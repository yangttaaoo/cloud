package com.cist.earlyplayback.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.earlyplayback.mapper.EarlyPlaybackMapper;
import com.cist.earlyplayback.service.EarlyPlaybackService;
import com.cist.frame.page.PageInfo;


@Service("EarlyPlaybackService")
public class EarlyPlaybackServiceImpl implements EarlyPlaybackService{
	@Autowired
	private EarlyPlaybackMapper mapper;
	
	@Override
	public Object playbackinfopageList(HashMap<String, Object> map,
			PageInfo pinfo) {
		return mapper.playbackinfopageList(map);
	}

}
