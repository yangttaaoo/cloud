package com.cist.personalstats.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.CDirectionInfo;
import com.cist.offsite.invalidtrial.model.CPlateColorInfo;
import com.cist.offsite.invalidtrial.model.CPlateKerisInfo;
import com.cist.offsite.invalidtrial.model.CPlateTypeInfo;
import com.cist.offsite.invalidtrial.model.SysDepartInfo;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.offsite.invalidtrial.model.VwDevInfo;
import com.cist.offsite.invalidtrial.utils.DynaSqlProvider;
import com.cist.personalstats.model.DeptInfo;
import com.cist.personalstats.model.PersonalStats;
import com.cist.picture.model.Depart_info;
import com.cist.picture.model.Tbl_offe_cate;

public interface PersonalStatsMapper {

	/**
	 * 查询采集单位信息
	 * 
	 * @return List<SysDepartInfo>
	 */
	List<SysDepartInfo> selectSysDepartInfo();

	/**
	 * 个人工作统计
	 * 
	 * @return List<PersonalStats>
	 */
	List<PersonalStats> selectPersonalStats(HashMap<String,Object> map);
	
	/**
	 * 个人工作统计根据违法行为统计
	 * 
	 * @return List<PersonalStats>
	 */
	List<PersonalStats> statsListByWfxw(HashMap<String,Object> map); 
	
	/**
	 * 初审个人工作统计
	 * 
	 * @return List<PersonalStats>
	 */
	List<PersonalStats> statsListByCs(HashMap<String,Object> map); 
	/**
	 * 复审个人工作统计
	 * 
	 * @return List<PersonalStats>
	 */
	List<PersonalStats> statsListByFs(HashMap<String,Object> map); 
	
	/**
	 * 使用单位树
	 * @param dept_superior
	 * @return
	 */
	List<DeptInfo> depart_infolist(Integer dept_superior);
}
