package com.cist.logquery.bizoperate.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.logquery.bizoperate.modle.LogBiz;
import com.cist.logquery.bizoperate.service.BizService;

@RestController
@RequestMapping("biz")
public class BizController {
@Autowired
private BizService service;
       /**
        * 查询所有数据
        * @param map
        * @return
        */
      @RequestMapping("data")
      public PageInfo<LogBiz>  selecteData(@RequestBody HashMap<String,Object> map){
    	  try {
			PageInfo  page=new PageInfo();
			page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<LogBiz>  info=(PageInfo<LogBiz>) service.selectBizpageList(map, page);
			return info;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    	  
      }
      /**
       * 删除所有数据
       * @param pk
       * @return
       */
      @RequestMapping("deleteAll")
      public Integer deleteAll(@RequestParam("pk") String[] pk){
    	  Integer in=service.deleteAll(pk);
		return in;    	  
      }
      /**
       * 删除单条数据
       */
      @RequestMapping("deleteOne")
      public Integer deleteAll(@RequestParam String pk){
    	 Integer te= Integer.parseInt(pk);
    	  Integer in=service.deleteOne(te);
		return in;    	  
      }
}
