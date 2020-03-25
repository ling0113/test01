package com.test.test01.notnull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: com.test.test01.notnull.NotNulls
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/11/29 11:20
 * @Version: 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNulls {

    /**
     * 获取参数名
     * @return
     */
    String fileName();
}
