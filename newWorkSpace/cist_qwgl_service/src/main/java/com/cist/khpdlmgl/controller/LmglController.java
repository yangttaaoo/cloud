package com.cist.khpdlmgl.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cist.frame.page.PageInfo;
import com.cist.khpdlmgl.model.LmglTarget;
import com.cist.khpdlmgl.service.LmglService;
@RestController
@RequestMapping("lmgl")
public class LmglController {
	 @Autowired
	  private LmglService service;
	  /**
	   * 查询所有
	   * @param map
	   * @return
	   */
	  @RequestMapping("all")
	  public PageInfo<LmglTarget> selectData(@RequestBody HashMap<String, Object> map){
			try {
				PageInfo page = new PageInfo();
				page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
				page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
				PageInfo<LmglTarget> info = (PageInfo<LmglTarget>) service.selectDatapageList(map, page);
				return info;
			} catch (Exception e) {
				e.printStackTrace();

			}
			return null;
		  
	  }
	  /**
	   * 增加数据
	   * @param map
	   * @return
	   */
	  @RequestMapping("add")
	 public Integer addData(@RequestBody HashMap<String,Object> map){
		  Integer  in =service.addData(map);
		return in;
	  }
	  
	  
	  /**
	   * 修改数据
	   * @param map
	   * @return
	   */
	  @RequestMapping("update")
	 public Integer updateData(@RequestBody HashMap<String,Object> map){
		  Integer  in =service.updateData(map);
		return in;
	  }
	  
	  /**
	   * 批量删除数据
	   * @param map
	   * @return
	   */
	  @RequestMapping("deleteall")
	 public Integer deleteAllData(@RequestParam("pk") String[] pk){
		  Integer  in =service.deleteData(pk);
		return in;
	  }
	  /**
	   * 删除数据
	   * @param map
	   * @return
	   */
	  @RequestMapping("delete")
	 public Integer deleteData(@RequestBody HashMap<String,Object> map){
		  Integer  in =service.deletOneData(map);
		return in;
	  }
}
