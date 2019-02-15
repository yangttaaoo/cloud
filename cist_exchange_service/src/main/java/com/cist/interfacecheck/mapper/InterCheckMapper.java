package com.cist.interfacecheck.mapper;


import java.util.HashMap;
import java.util.List;
import com.cist.interfaceapply.model.SjgxDevCompany;
import com.cist.interfaceapply.model.SjgxInterface;
import com.cist.interfaceapply.model.SjgxInterfaceList;
import com.cist.interfaceapply.model.SjgxInterfaceUseApply;
import com.cist.interfaceapply.model.VwDeptList;

public interface InterCheckMapper {
	
	//审核通过
	Integer pass(HashMap<String,Object> map);
	
	//审核不通过
	Integer notPass(HashMap<String,Object> map);
	
	//条件分页查询
	List<SjgxInterfaceUseApply> list(HashMap<String,Object> map); 
}
