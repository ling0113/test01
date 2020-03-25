package com.test.test01.notnull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

/**
 * @ClassName: com.test.test01.notnull.NooNullAnnotation
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/11/29 11:25
 * @Version: 1.0
 */
public class NooNullAnnotation {
    public static <T> String validateResults(T t){
        //List<ValidateResult> validateResults = new ArrayList<>();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNulls.class)) {
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(t);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (value==null){
                    NotNulls nulls = field.getAnnotation(NotNulls.class);
                    ValidateResult result = new ValidateResult();
                    result.setMessage(nulls.fileName()+"不能为空");
                   return result.getMessage();
                }
            }
        }
        return null;

    }

    public static void main(String[] args) {
        /*test test = new test();
        test.setRetentionRatio(1);
        test.setRetentionAmount("123");
        //test.setReturnYear(12345);
        //String s = NooNullAnnotation.validateResults(test);
        //System.out.println("aaaa      "+s+"    bbbbb");
        System.out.println(test);
        if (test.getReturnYear()!=null){
            System.out.println(123);
        }*/
        boolean empty = StringUtils.isEmpty("");
        boolean empty2 = StringUtils.isEmpty("null");
        boolean empty3 = StringUtils.isEmpty(null);
        System.out.println(empty);
        System.out.println(empty2);
        System.out.println(empty3);
    }

}
