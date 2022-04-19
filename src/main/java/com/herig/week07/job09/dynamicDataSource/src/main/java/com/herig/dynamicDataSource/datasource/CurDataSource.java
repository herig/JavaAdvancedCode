package com.herig.dynamicDataSource.datasource;

import java.lang.annotation.*;

/**
 * @author Qian Yuanfeng
 * @date 2022/4/17 - 18:02
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurDataSource {

    String name() default "";

}
