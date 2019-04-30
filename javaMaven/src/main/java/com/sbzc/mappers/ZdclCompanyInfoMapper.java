package com.sbzc.mappers;

import com.sbzc.model.ZdclCompanyInfo;

public interface ZdclCompanyInfoMapper {
    int insert(ZdclCompanyInfo record);

    int insertSelective(ZdclCompanyInfo record);
}