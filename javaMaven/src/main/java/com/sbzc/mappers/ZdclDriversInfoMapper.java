package com.sbzc.mappers;

import com.sbzc.model.ZdclDriversInfo;

public interface ZdclDriversInfoMapper {
    int insert(ZdclDriversInfo record);

    int insertSelective(ZdclDriversInfo record);
}