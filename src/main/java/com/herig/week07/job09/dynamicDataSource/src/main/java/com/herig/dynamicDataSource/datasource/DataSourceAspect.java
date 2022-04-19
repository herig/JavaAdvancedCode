package com.herig.dynamicDataSource.datasource;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Qian Yuanfeng
 * @date 2022/4/17 - 18:13
 */
@Slf4j
@Aspect
@Component
@Order(1)
public class DataSourceAspect implements Ordered {

    @Pointcut("@annotation(com.herig.dynamicDataSource.datasource.CurDataSource)")
    public void dataSourcePointCut() {
        log.debug("111" );
        System.out.println("xxxx");
    }

    @Before("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("xxxx");
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        CurDataSource ds = method.getAnnotation(CurDataSource.class);
        if (ds == null) {
            DynamicDataSource.setDataSource(DataSourceNames.FIRST);
            log.debug("set datasource is " + DataSourceNames.FIRST);
        } else {
            DynamicDataSource.setDataSource(ds.name());
            log.debug("set datasource is " + ds.name());
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            log.debug("clean datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }

}
