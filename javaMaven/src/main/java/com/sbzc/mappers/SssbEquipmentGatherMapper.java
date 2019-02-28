package com.sbzc.mappers;

import com.sbzc.model.SssbEquipmentGather;
import java.math.BigDecimal;

public interface SssbEquipmentGatherMapper {
    int deleteByPrimaryKey(BigDecimal fkEquipmentId);

    int insert(SssbEquipmentGather record);

    int insertSelective(SssbEquipmentGather record);

    SssbEquipmentGather selectByPrimaryKey(BigDecimal fkEquipmentId);

    int updateByPrimaryKeySelective(SssbEquipmentGather record);

    int updateByPrimaryKey(SssbEquipmentGather record);
}