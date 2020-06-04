package com.test.test01.arraylist;

import com.test.test01.notnull.NotNulls;
import java.util.List;
import lombok.Data;

/**
 * @ClassName: com.test.test01.notnull.test
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/11/29 11:32
 * @Version: 1.0
 */
@Data
public class testss {
    @NotNulls(fileName = "质保金比例")
    private Integer retentionRatio;

    @NotNulls(fileName = "质保金")
    private String retentionAmount;

    @NotNulls(fileName = "返还年限")
    private Integer returnYear;
    private List<String> list;

}
