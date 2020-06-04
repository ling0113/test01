package com.test.test01.steam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: com.test.test01.steam.Filter
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/5/22 10:25
 * @Version: 1.0
 */
public class Filter {

    public static void main(String[] args) {
        List<User> list = new ArrayList<User>(){
            {
                add(new User(1L,"张三",10, "清华大学"));
                add(new User(2L,"李四",12, "清华大学"));
                add(new User(3L,"王五",15, "清华大学"));
                add(new User(4L,"赵六",12, "清华大学"));
                add(new User(5L,"田七",25, "北京大学"));
                add(new User(6L,"小明",16, "北京大学"));
                add(new User(7L,"小红",14, "北京大学"));
                add(new User(8L,"小华",14, "浙江大学"));
                add(new User(9L,"小丽",17, "浙江大学"));
                add(new User(10L,"小何",10, "浙江大学"));
            }
        };

        System.out.println("学校是清华大学的user");
         list = list.stream().filter(user -> "清华大学".equals(user.getSchool())).collect(Collectors.toList());
        System.out.println(list.toString());
        //userList1.forEach(user -> System.out.print(user.getName() + '、'));


    }
}
