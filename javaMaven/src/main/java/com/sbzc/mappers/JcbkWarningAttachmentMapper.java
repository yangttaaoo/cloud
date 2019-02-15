package com.sbzc.mappers;

import com.sbzc.model.JcbkWarningAttachment;
import java.math.BigDecimal;

public interface JcbkWarningAttachmentMapper {
    int deleteByPrimaryKey(BigDecimal pkId);

    int insert(JcbkWarningAttachment record);

    int insertSelective(JcbkWarningAttachment record);

    JcbkWarningAttachment selectByPrimaryKey(BigDecimal pkId);

    int updateByPrimaryKeySelective(JcbkWarningAttachment record);

    int updateByPrimaryKey(JcbkWarningAttachment record);
}