package com.sbzc.mappers;

import com.sbzc.model.SssbEquipmentPc;
import java.math.BigDecimal;

public interface SssbEquipmentPcMapper {
    int deleteByPrimaryKey(BigDecimal fkEquipmentId);

    int insert(SssbEquipmentPc record);

    int insertSelective(SssbEquipmentPc record);

    SssbEquipmentPc selectByPrimaryKey(BigDecimal fkEquipmentId);

    int updateByPrimaryKeySelective(SssbEquipmentPc record);

    int updateByPrimaryKey(SssbEquipmentPc record);
}