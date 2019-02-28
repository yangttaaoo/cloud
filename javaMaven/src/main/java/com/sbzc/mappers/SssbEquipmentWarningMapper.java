package com.sbzc.mappers;

import com.sbzc.model.SssbEquipmentWarning;
import java.math.BigDecimal;

public interface SssbEquipmentWarningMapper {
    int deleteByPrimaryKey(BigDecimal pkId);

    int insert(SssbEquipmentWarning record);

    int insertSelective(SssbEquipmentWarning record);

    SssbEquipmentWarning selectByPrimaryKey(BigDecimal pkId);

    int updateByPrimaryKeySelective(SssbEquipmentWarning record);

    int updateByPrimaryKey(SssbEquipmentWarning record);
}