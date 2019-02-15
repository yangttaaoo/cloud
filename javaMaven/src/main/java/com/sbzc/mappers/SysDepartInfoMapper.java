package com.sbzc.mappers;

import com.sbzc.model.SysDepartInfo;
import java.math.BigDecimal;

public interface SysDepartInfoMapper {
    int deleteByPrimaryKey(BigDecimal deptPk);

    int insert(SysDepartInfo record);

    int insertSelective(SysDepartInfo record);

    SysDepartInfo selectByPrimaryKey(BigDecimal deptPk);

    int updateByPrimaryKeySelective(SysDepartInfo record);

    int updateByPrimaryKeyWithBLOBs(SysDepartInfo record);

    int updateByPrimaryKey(SysDepartInfo record);
}