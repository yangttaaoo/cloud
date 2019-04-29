/**  

* <p>Title: LoginController.java</p>  

* <p>Description: </p>    

* @author zah  

* @date 2018年8月29日  

* @version 1.0  

*/  
package com.cist.login.controller;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.support.json.JSONUtils;
import com.cist.BaseInfo.model.Des3ECB;
import com.cist.BaseInfo.model.RsaUtil;
import com.cist.configUrl.model.ConfigUrlBean;
import com.cist.frame.springContext.SpringContextUtil;
import com.cist.frame.utils.SysTempStoreUtils;
import com.cist.log.logAnnotation.CistLog;
import com.cist.log.logAnnotation.LogType;
import com.cist.login.model.Authority;
import com.cist.login.model.UserDetails;
import com.cist.login.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
/**  
    * @ClassName: LoginController  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author Administrator  
    * @date 2018年8月29日  
    *    
    */
@RestController
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("userLogin")
	@CistLog(type=LogType.LOGIN)
	public Map<String,Object> login(@RequestBody Map<String,String> param,HttpServletRequest request){
		UserDetails user;
		String redirectUrl = "login";
		String loginMess = "";
		Map<String,Object> map = new HashMap<String,Object>();
		try{
		  user = service.queryUserDetails(param);
		  if(null!=user){
			  ConfigUrlBean cfg = SpringContextUtil.getBeanByName("configUrlBean", ConfigUrlBean.class);
			  String privateKey = cfg.getPrivatekey();
			  String encryptPassWord = param.get("sypi_comp");
			  String password =RsaUtil.privateDecrypt(encryptPassWord,RsaUtil.getPrivateKey(privateKey));
			  if(Des3ECB.EncoderByMd5(param.get("sypi_code")+password).equals(user.getSypi_comp())){
				  Map<String,Object> openr_menu = this.splitMenuAndAuth(user);
				  redirectUrl = "index";
				  loginMess = "登录成功！";
				  user.setAuthorityMap(openr_menu);
				  map.put("userInfo", user);
				  ObjectMapper ob = new ObjectMapper();
				  String str = ob.writeValueAsString(user);
				  Map<String,Object> m = (Map<String,Object>)JSONUtils.parse(str);
				  request.getSession().setAttribute("userInfo"+request.getSession().getId(), m);
				  map.put("syscfg",SysTempStoreUtils.getSysConfig("SCFG"));
			  }else{
				  redirectUrl = "login";
				  loginMess = "登录失败，用户或密码错误！";
			  }  
		  }else{
			  redirectUrl = "login";
			  loginMess = "登录失败，用户或密码错误！";
		  }
		}catch(Exception e){
			e.printStackTrace();
			redirectUrl = "login";
			loginMess = "登录失败，数据查询错误！";
		}
		map.put("redirectUrl", redirectUrl);
		map.put("loginMess", loginMess);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("getUserFromSession")
	public Map<String,Object> getUserInfoFromSession(HttpServletRequest request){
		Map<String,Object>  map = (Map<String,Object>)request.getSession().getAttribute("userInfo"+request.getSession().getId());
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("userInfo", map);
		map1.put("syscfg",SysTempStoreUtils.getSysConfig("SCFG"));
		return map1;
	}
	
	/**
	 * 分离菜单
	 * 和操作权限
	 * 
	 * ***/
	private Map<String,Object> splitMenuAndAuth(UserDetails user) throws Exception{
		Set<Authority> authority= user.getAuthority();
		Authority temp = new Authority("顶级菜单",1);
		List<String> auth_list = new LinkedList<String>();
		Map<String,Object> menuAndopermap = new HashMap<String,Object>();
		if(null!=authority && !authority.isEmpty()){
			for(Authority auth : authority){
				if(auth.getSymi_level()!=5) {  //去掉操作权限增删改
					for(Authority auth1 : authority){
						if(auth1.getSymi_level()!=5 && auth.getSymi_pk() == auth1.getSymi_parent()){
							auth.getChild().add(auth1);
						}
					}
					if(auth.getSymi_level()==2){
						temp.getChild().add(auth);
					}
				}else {  //添加操作权限
					auth_list.add(auth.getSymi_url());
				}
			}
		}
		menuAndopermap.put("menu", temp);
		menuAndopermap.put("operation",auth_list);
		return menuAndopermap;
	}
	
	@RequestMapping("userLogout")
	public String userLogout(HttpServletRequest request){
		HttpSession session = request.getSession();
		String sessionID = session.getId();
		if(null!=session){
			session.removeAttribute("userInfo"+sessionID);
			session.invalidate();
		}
		return null;
	}
}
