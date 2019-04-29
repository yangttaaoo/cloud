package com.cist.frame.pageAop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.cist.frame.page.PageInfo;
import com.github.pagehelper.PageHelper;

@Component
@Aspect
@SuppressWarnings({ "rawtypes", "unchecked" })
public class PageAop {
	@Pointcut("execution(public * com.cist..service..*.*pageList(..))")
	public void PageAspect() {
	}

	@Around("PageAspect()")
	public Object arround(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		if (null != args && args.length > 0 && args[args.length - 1] instanceof PageInfo) {
			PageInfo pa = (PageInfo) args[args.length - 1];
			PageHelper.startPage(pa.getPageNum(), pa.getPageSize());
			Object o = pjp.proceed(args);
			if (null != o) {
				PageInfo pageInfo = new PageInfo((List) o);
				return pageInfo;
			} else {
				return null;
			}
		} else {
			return pjp.proceed(args);
		}
	}
}
