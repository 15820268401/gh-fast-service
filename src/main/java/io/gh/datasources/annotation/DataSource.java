package io.gh.datasources.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 * @author gh
 * @email
 * @date 2017/9/16 22:16
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
