package com.sbzc.mappers;

import com.sbzc.model.JcbkWarningDocument;
import java.math.BigDecimal;

public interface JcbkWarningDocumentMapper {
    int deleteByPrimaryKey(BigDecimal pkId);

    int insert(JcbkWarningDocument record);

    int insertSelective(JcbkWarningDocument record);

    JcbkWarningDocument selectByPrimaryKey(BigDecimal pkId);

    int updateByPrimaryKeySelective(JcbkWarningDocument record);

    int updateByPrimaryKey(JcbkWarningDocument record);
}