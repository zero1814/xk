package org.product.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 类: ServiceCacheAop <br>
 * 描述: 判断 <br>
 * 作者: zhy<br>
 * 时间: 2019年6月17日 下午4:16:25
 */
@Aspect
@Component
@Slf4j
public class ServiceCacheAop {

	@Pointcut("execution(public * org.product.service.impl.*.*(..))")
	public void select() {
	}

	@Around(value = "select()")
	public void around(ProceedingJoinPoint point) {
		log.info("进入切面开始执行----->");
		log.info("point.getArgs=" + JSON.toJSONString(point.getArgs()));
		log.info("进入切面结束执行----->");
	}
}
