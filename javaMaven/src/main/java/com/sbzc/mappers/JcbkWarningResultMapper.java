package com.sbzc.mappers;

import com.sbzc.model.JcbkWarningResult;
import java.math.BigDecimal;

public interface JcbkWarningResultMapper {
    int deleteByPrimaryKey(BigDecimal pkId);

    int insert(JcbkWarningResult record);

    int insertSelective(JcbkWarningResult record);

    JcbkWarningResult selectByPrimaryKey(BigDecimal pkId);

    int updateByPrimaryKeySelective(JcbkWarningResult record);

    int updateByPrimaryKey(JcbkWarningResult record);
}