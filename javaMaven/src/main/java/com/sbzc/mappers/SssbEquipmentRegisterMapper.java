package com.sbzc.mappers;

import com.sbzc.model.SssbEquipmentRegister;
import java.math.BigDecimal;

public interface SssbEquipmentRegisterMapper {
    int deleteByPrimaryKey(BigDecimal pkId);

    int insert(SssbEquipmentRegister record);

    int insertSelective(SssbEquipmentRegister record);

    SssbEquipmentRegister selectByPrimaryKey(BigDecimal pkId);

    int updateByPrimaryKeySelective(SssbEquipmentRegister record);

    int updateByPrimaryKey(SssbEquipmentRegister record);
}