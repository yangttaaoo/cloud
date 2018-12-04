package com.cist.depttestin.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.depttestin.model.Attachment;
import com.cist.depttestin.model.DeptInfo;
import com.cist.depttestin.model.Testin;

public interface TestinMapper {
	/**
	 * 查询所有的数据
	 * @param page
	 * @return
	 */
   public List<Testin>  selectData(HashMap<String,Object> map); 
   /**
    * 增加考核单位数据
    */
   public int  addData(HashMap<String,Object> map);
   /**
    * 增加单位考核指标
    * @param map
    * @return
    */
   public int  addTarget(HashMap<String,Object> map);
   /**
    * 增加附件
    * @param map
    * @return
    */
   public int  addBag(HashMap<String,Object> map);
   /**
    * 增加日志
    * @param map
    * @return
    */
   public int  addLog(HashMap<String,Object> map);
   /**
    * 删除考核单位数据
    * @param map
    * @return
    */
   public int  deleteData(HashMap<String,Object> map);
   /**
    * 删除指标数据
    * @param map
    * @return
    */
   public int  deleteTarget(HashMap<String,Object> map);
   /**
    * 删除附件
    * @param map
    * @return
    */
   public int  deleteBag(HashMap<String,Object> map);
   /**
    * 修改考核单位数据
    * @param map
    * @return
    */
   public int  updateData(HashMap<String,Object> map);
   /**
    * 修改指标
    * @param map
    * @return
    */
   public int  updateTarget(HashMap<String,Object> map);
   /**
    * 修改附件
    * @param map
    * @return
    */
   public int  updateBag(HashMap<String,Object> map);
   /**
    * 查询部门
    * @param object
    * @return
    */
   public List<DeptInfo> depart_infolist(Object object);
   /**
	 * 查询PK
	 * @param page
	 * @return
	 */
   public Integer  selectPk();
   /**
    * 查询附件
    */
   public List<Attachment> selectAttach(HashMap<String,Object> map);
   /**
 	 * 审核
 	 * @param map
 	 * @return
 	 */
    public Integer addCheck(HashMap<String, Object> map);
}
