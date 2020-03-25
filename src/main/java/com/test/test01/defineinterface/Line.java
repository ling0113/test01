package com.test.test01.defineinterface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: com.test.test01.defineinterface.Line
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/10/18 18:21
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Line {

    int line() default 3;
}
