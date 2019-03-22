package com.sbzc.mappers;

import com.sbzc.model.SysConfig;

public interface SysConfigMapper {
    int insert(SysConfig record);

    int insertSelective(SysConfig record);
}