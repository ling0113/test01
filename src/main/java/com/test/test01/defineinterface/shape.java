package com.test.test01.defineinterface;

import lombok.Data;

/**
 * @ClassName: com.test.test01.defineinterface.shape
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/10/18 16:29
 * @Version: 1.0
 */
@Data
public class shape {

    /**
     * 形状的边数
     */
    @Line
    private int lines;

    /**
     * 颜色
     */
    @Color(value = "red")
    private String color;

}
