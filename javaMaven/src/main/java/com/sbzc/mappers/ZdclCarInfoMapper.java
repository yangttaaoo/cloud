package com.sbzc.mappers;

import com.sbzc.model.ZdclCarInfo;

public interface ZdclCarInfoMapper {
    int insert(ZdclCarInfo record);

    int insertSelective(ZdclCarInfo record);
}