package com.cist.redillegal.mapper;
import java.util.HashMap;
import java.util.List;

import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.redlist.model.RedListInfo;

public interface RedIllegalMapper {
	List<TblOffeEvdiInfo> redIllegalpageList(HashMap<String,Object> map);
}
