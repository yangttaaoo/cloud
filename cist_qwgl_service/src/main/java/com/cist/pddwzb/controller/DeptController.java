package com.cist.pddwzb.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.khpdgl.model.Qw_AppraiseTopic;
import com.cist.mymetrics.model.Regulations;
import com.cist.mymetrics.service.MyMetricsService;
import com.cist.pddwzb.model.NameAndSocre;
import com.cist.pddwzb.service.DeptService;
import com.cist.pdgrzb.model.DateList;
import com.cist.pdgrzb.model.DeptInfo;
import com.cist.pdgrzb.model.Qw_I_C_Metricr;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("dept")
public class DeptController {
	@Autowired
	private DeptService dService;
	@Autowired
	private MyMetricsService mService;

	@RequestMapping("index")
	public PageInfo<Qw_I_C_Metricr> selectPersonAll(@RequestBody HashMap<String, Object> map) {
		PageInfo pInfo = new PageInfo();
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<Qw_I_C_Metricr> pageInfo = (PageInfo<Qw_I_C_Metricr>) dService.selectDeptAllpageList(map, pInfo);
		List<Qw_I_C_Metricr> list = pageInfo.getList();
		int size = list.size();
		List<NameAndSocre> list2 = null;
		List<Regulations> list4 = null;
		Regulations regulations = null;
		for (int i = 0; i < size; i++) {
			String allscore = list.get(i).getAllsocre();
			String[] scores = allscore.split(",");
			Integer totalsocre = 0;
			for (String string : scores) {
				totalsocre += Integer.valueOf(string);
			}
			list.get(i).setTotalSocre(totalsocre);
			
			Integer defaulttotalsocre = 0; 
			//查询栏目下的条例分值			
			String topicd = list.get(i).getTopicids();
			String[] topicds = topicd.split(",");
			for (int j = 0; j < topicds.length; j++) {
				map.put("id", topicds[j]);
				list4 = mService.selectRegulations(map);
				for (int j2 = 0; j2 < list4.size(); j2++) {
					regulations = list4.get(j2);
					if (regulations.getAssessment_rules().equals("1")) {
						defaulttotalsocre += regulations.getAssessment_num();
					}else {
						defaulttotalsocre -= regulations.getAssessment_num();
					}
				}
			}
			//对应的所有栏目默认分值		
			map.put("ids", topicds);
			list2 = dService.selectTopicById(map);
			for (NameAndSocre nameAndSocre : list2) {
				defaulttotalsocre += nameAndSocre.getDefault_value();
			}
			
		}

		pageInfo.setList(list);
		return pageInfo;
	}
	/**
	 * 查询指标对应的栏目和分数
	 * @param map
	 * @return
	 */
	@RequestMapping("selecttolist")
	public List<NameAndSocre> selecttolist(@RequestBody HashMap<String, Object> map) {
		String wareIds = (String) map.get("ids");
		List<String> wareIdList = Arrays.asList(wareIds.split(","));
		map.put("ids", wareIdList);
		List<NameAndSocre> names = dService.selectTopicById(map);
		List<Regulations> list3 = null;
		String socres1 = (String) map.get("socres");
		String[] socres = socres1.split(",");
		List<NameAndSocre> list = new ArrayList<>();
		NameAndSocre object = null;
		Integer score;
		Regulations regulations = null;
		for (int i = 0; i < socres.length; i++) {
			score = 0;
			map.put("id", wareIdList.get(i));
			list3 = mService.selectRegulations(map);
			for (int j2 = 0; j2 < list3.size(); j2++) {
				regulations = list3.get(j2);
				if (regulations.getAssessment_rules().equals("1")) {
					score += regulations.getAssessment_num();
				}else {
					score -= regulations.getAssessment_num();
				}
			}
			object = new NameAndSocre();
			object.setTopic_name(names.get(i).getTopic_name());
			object.setScore(Integer.valueOf(socres[i]));
			object.setPk_id(names.get(i).getPk_id());
			object.setDefault_value(names.get(i).getDefault_value()+score);
			list.add(object);
		}
		return list;
	}
	/**
	 * 查询所有的栏目
	 * @param map
	 * @return
	 */
	@RequestMapping("selectTopics")
	public List<Qw_AppraiseTopic> selectTopics(@RequestBody HashMap<String, Object> map) {
		return dService.selectTopic(map);
	}
	/**
	 * 新增单位指标
	 * @param map
	 * @param request
	 * @return
	 */
	@Transactional
	@RequestMapping("save")
	public Integer save(@RequestBody HashMap<String, Object> map,HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
//		String deptCode = userMap.get("sypi_dept_pk")==null?null:userMap.get("sypi_dept_pk").toString();
//		map.put("fk_user_id", deptCode);//登录用户的部门
		Calendar a = Calendar.getInstance();
		String year = map.get("year").toString();
		String month = map.get("month").toString();
		a.set(Calendar.YEAR, Integer.valueOf(year));
		a.set(Calendar.MONTH, Integer.valueOf(month) - 1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("evaluate_date_end", sdf.format(a.getTime()));
		String selectDept = map.get("selectdept").toString();
		String[] depts = selectDept.split(",");
		map.put("metrics_type", 2);
		for (int j = 0; j < depts.length; j++) {
			map.put("fk_dept_id", depts[j]);
			map.put("evaluate_date_start", sdf.format(new Date()));
			Integer isInsertDept = dService.insertDept(map);
			if (isInsertDept != 0) {
//				Integer pk_id = dService.selectMetricsId(map);
				map.put("FK_RELATION_ID", map.get("pk_id"));
				ArrayList<Integer> topicids = (ArrayList<Integer>) map.get("xzzbList");
				ArrayList<Integer> socres = (ArrayList<Integer>) map.get("socres");
				for (Integer i = 0; i < topicids.size(); i++) {
					map.put("FK_TOPIC_ID", topicids.get(i));
					map.put("METRICS_NUM", socres.get(i));
					Integer isinsert = dService.insertZb(map);
					if (isinsert == 0) {
						throw new RuntimeException();
					}
				}
			} else throw new RuntimeException();
		}
		return 1;
	}
	/**
	 * 更新单位指标
	 * @param map
	 * @return
	 */
	@Transactional
	@RequestMapping("update")
	public Integer update(@RequestBody HashMap<String, Object> map) {
		Calendar a = Calendar.getInstance();
		String year = map.get("year").toString();
		String month = map.get("month").toString();
		a.set(Calendar.YEAR, Integer.valueOf(year));
		a.set(Calendar.MONTH, Integer.valueOf(month) - 1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("evaluate_date_end", sdf.format(a.getTime()));
		Integer isupdate = dService.updateDept(map);
		if (isupdate!=0) {
			Integer isUpdateMetrics = dService.deleteMetrics(map);
			if (isUpdateMetrics!=0) {
				ArrayList<Integer> topicids = (ArrayList<Integer>) map.get("xzzbList");
				ArrayList<Integer> socres = (ArrayList<Integer>) map.get("socres");
				for (Integer i = 0; i < topicids.size(); i++) {
					map.put("FK_TOPIC_ID", topicids.get(i));
					map.put("METRICS_NUM", socres.get(i));
					Integer isinsert = dService.insertZb(map);
					if (isinsert == 0) {
						throw new RuntimeException();
					}
				}
			}else throw new RuntimeException();
		}else throw new RuntimeException();
		return 1;
	}
	//单条删除	
	@Transactional
	@RequestMapping("delete")
	public Integer delete(@RequestBody HashMap<String, Object> map) {
		Integer isdelete1 = dService.deleteDept(map);
		if (isdelete1!=0) {
			Integer isdelete2 = dService.deleteMetrics(map);
			if (isdelete2!=0) {
			}else throw new RuntimeException();
		}else throw new RuntimeException();
		return 1;
	}
	//批量删除	
	@Transactional
	@RequestMapping("deleteAll")
	public Integer deleteAll(@RequestParam("pks") String[] pks) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("pks", pks);
		Integer isdelete1 = dService.deleteDeptAll(map);
		if (isdelete1!=0) {
			Integer isdelete2 = dService.deleteMetricsAll(map);
			if (isdelete2!=0) {
			}else throw new RuntimeException();
		}else throw new RuntimeException();
		return 1;
	}
	/**
	 * 级联选择的数据
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("datalist")
	public String DateList() throws JsonProcessingException {
		Calendar calendar = Calendar.getInstance();
		Integer year = calendar.get(Calendar.YEAR);
		String[] jd = { "年度", "季度", "月度" };
		String[] jdarray = { "第一季度", "第二季度", "第三季度", "第四季度" };
		String[] months = new String[12];

		List<DateList> yearlist = new ArrayList<>();
		DateList vTree = null;
		for (int i = 1; i <= 12; i++) {
			months[i - 1] = i + "月";
		}
		for (int i = 0; i < 5; i++) {
			vTree = new DateList();
			vTree.setValue(year.toString());
			vTree.setLabel(year.toString());
			yearlist.add(vTree);
			List<DateList> jdList = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				vTree = new DateList();
				vTree.setValue(String.valueOf(j));
				vTree.setLabel(jd[j]);
				jdList.add(vTree);
				yearlist.get(i).setChildren(jdList);
				List<DateList> monthList = new ArrayList<>();

				if (j == 2) {
					for (int k = 0; k < 12; k++) {
						vTree = new DateList();
						vTree.setValue(String.valueOf(k + 1));
						vTree.setLabel(months[k]);
						vTree.setIsLeaf(true);
						monthList.add(vTree);
						jdList.get(j).setChildren(monthList);
					}
				}
				if (j == 1) {
					for (int k = 0; k < 4; k++) {
						vTree = new DateList();
						vTree.setValue(String.valueOf(k + 1));
						vTree.setLabel(jdarray[k]);
						vTree.setIsLeaf(true);
						monthList.add(vTree);
						jdList.get(j).setChildren(monthList);
					}
				}
				if (j == 0) {
					vTree.setIsLeaf(true);
					jdList.get(j).setChildren(null);
				}
			}

			year++;
		}
		ObjectMapper objmapper = new ObjectMapper();
		return objmapper.writeValueAsString(yearlist);
	}

	/**
	 * 管理部门树
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfos")
	public String deptinfos() throws JsonProcessingException {
		// 顶级部门
		List<DeptInfo> departinfo = dService.depart_infolists(null);
		ObjectMapper mapper = new ObjectMapper();
		List<DeptInfo> list = departinfodgs(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidians(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidians(List<DeptInfo> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (DeptInfo depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_code());
			map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());
			if (null != depart_info.getChildren()) {// 下级

				map.put("children", getdiwfdidians(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}

	public List<DeptInfo> departinfodgs(List<DeptInfo> departinfo) {
		for (DeptInfo depart_info : departinfo) {
			// 部门
			List<DeptInfo> list = dService.depart_infolists(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodgs(list);
			}
		}
		return departinfo;
	}
}
