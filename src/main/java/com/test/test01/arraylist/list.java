package com.test.test01.arraylist;

import java.util.ArrayList;

/**
 * @ClassName: com.test.test01.arraylist.list
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/5/20 10:33
 * @Version: 1.0
 */
public class list {

    public static void main(String[] args) {
//        ArrayList<testss> arrayList = new ArrayList<>();
        //arrayList.add("123");
        testss testss = new testss();

//        System.out.println(arrayList);
        if (testss.getList() != null) {

            for (String s : testss.getList()) {
                System.out.println(s);
            }
        }else {
            System.out.println(123);
        }
    }

}
