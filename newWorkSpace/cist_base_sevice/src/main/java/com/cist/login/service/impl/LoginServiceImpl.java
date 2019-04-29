/**  

* <p>Title: LoginServiceImpl.java</p>  

* <p>Description: </p>    

* @author zah  

* @date 2018年8月29日  

* @version 1.0  

*/  
package com.cist.login.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.login.mapper.LoginMapper;
import com.cist.login.model.UserDetails;
import com.cist.login.service.LoginService;

/**  
    * @ClassName: LoginServiceImpl  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author Administrator  
    * @date 2018年8月29日  
    *    
    */
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginMapper mapper;
	
	@Override
	public UserDetails queryUserDetails(Map<String, String> map) {
		return this.mapper.queryUserDetails(map);
	}

}
