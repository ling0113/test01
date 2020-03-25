package com.test.test01.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName: com.test.test01.hashmap.hashmap
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/12/17 16:59
 * @Version: 1.0
 */
public class hashmap {
    int b = 4;

    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"aaaaaaaaaaaaaaaaaaa");
        ArrayList<Object> objects = new ArrayList<>();
        LinkedList<Object> objects1 = new LinkedList<>();
        boolean a = map.get(1).equals("a");
        System.out.println(a);


    }

}
