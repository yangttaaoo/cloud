package com.sbzc.mappers;

import com.sbzc.model.JcbkWarningFeedBack;
import java.math.BigDecimal;

public interface JcbkWarningFeedBackMapper {
    int deleteByPrimaryKey(BigDecimal pkId);

    int insert(JcbkWarningFeedBack record);

    int insertSelective(JcbkWarningFeedBack record);

    JcbkWarningFeedBack selectByPrimaryKey(BigDecimal pkId);

    int updateByPrimaryKeySelective(JcbkWarningFeedBack record);

    int updateByPrimaryKey(JcbkWarningFeedBack record);
}