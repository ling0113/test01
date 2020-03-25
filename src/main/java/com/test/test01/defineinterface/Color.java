package com.test.test01.defineinterface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: com.test.test01.defineinterface.Color
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/10/18 18:06
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Color {

    String value() default "Color";

}
