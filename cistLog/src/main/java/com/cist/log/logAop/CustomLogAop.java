package com.cist.log.logAop;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cist.log.logAnnotation.CistLog;
import com.cist.log.logAnnotation.LogType;
import com.cist.log.logService.LogService;
import com.cist.login.model.UserDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Aspect
public class CustomLogAop {

	@Autowired
	private LogService service;
	 // 配置织入点
    @Pointcut("@annotation(com.cist.log.logAnnotation.CistLog)")
    public void logPointCut() {}
    
    @SuppressWarnings("unchecked")
	@AfterReturning(pointcut="logPointCut()",returning="rvt")
    public void doLog(JoinPoint join,Object rvt) {
    	try {
    		CistLog log  = getAnnotationLog(join);
    		if (log==null) {
    			return ;
    		}
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpServletRequest request = attributes.getRequest();
			// 获取ip
			String ip = getLocalIp(request);
			if (log.type()==LogType.LOGIN) {
				if (null!=rvt) {
					Map<String,Object> map = (Map<String, Object>) rvt;
					String url = map.get("redirectUrl").toString();
					if ("index".equals(url)) {
						String user="";
						String username = "";
						UserDetails userdetail =  ((UserDetails)map.get("userInfo"));
						if (null!=userdetail) {
							user = userdetail.getSypi_code();
							username = userdetail.getSypi_name();
						}
						Map<String,Object> arg = new HashMap<String, Object>();
						arg.put("username", user);
						arg.put("login_time", new Date());
						arg.put("user_cn",username);
						arg.put("user_flag", "0");
						arg.put("ip", ip);
						service.insertLoginLog(arg);
					} else {
						
					}
				}
			}else 
			{
				Map<String,Object> map  = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				Object atr = session.getAttribute("userInfo"+session.getId());
				String usercn="";
				String usercode = "";
				if (null!=atr) 
				{
					Object usercnobj = ((Map<String,Object>) atr).get("sypi_name");
					Object usercodeobj = ((Map<String,Object>) atr).get("sypi_code");
					if( null !=usercnobj )
					{
						usercn = usercnobj.toString();
					}
					if( null != usercodeobj )
					{
						usercode = usercodeobj.toString();
					}
				}
				String requestAddr = request.getRequestURL().toString();
				Object args[] = join.getArgs();
				ObjectMapper ob = new ObjectMapper();
				String paramstr = ob.writeValueAsString(args);
				map.put("syol_user_cn", usercn);
				map.put("sypi_pk", usercode);
				map.put("syol_request_url", requestAddr);
				map.put("syol_ip", ip);
				map.put("syol_time", new Date());
				map.put("syol_content", log.content());
				map.put("syol_action", log.type().getValue());
				map.put("syol_type", "1");
				map.put("syol_param_values", paramstr);
				map.put("syol_err_location", "");
				map.put("syol_ex_msg", "");
				map.put("syol_flag","1");
				service.insertOperLog(map);
			}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    private String getLocalIp(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String forwarded = request.getHeader("X-Forwarded-For");
        String realIp = request.getHeader("X-Real-IP");

        String ip = null;
        if (realIp == null) {
            if (forwarded == null) {
                ip = remoteAddr;
            } else {
                ip = forwarded.split(",")[0];
            }
        } else {
            if (realIp.equals(forwarded)) {
                ip = realIp;
            } else {
                if(forwarded != null){
                    forwarded = forwarded.split(",")[0];
                }
                ip = realIp + "/" + forwarded;
            }
        }
        return ip;
    }
    
   private CistLog getAnnotationLog(JoinPoint join){
    	Signature sign = join.getSignature();
    	MethodSignature methodSign = (MethodSignature) sign;
    	Method method = methodSign.getMethod();
    	if(method != null) {
    		return method.getAnnotation(CistLog.class);
    	}else {
    		return null;
    	}
    }
}