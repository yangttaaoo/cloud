package com.sbzc.mappers;

import com.sbzc.model.JcsjDevice;

public interface JcsjDeviceMapper {
    int insert(JcsjDevice record);

    int insertSelective(JcsjDevice record);
}