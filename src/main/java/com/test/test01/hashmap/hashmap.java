package com.test.test01.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
        String s = map.get(1);
        ArrayList<Object> objects = new ArrayList<>();
        LinkedList<Object> objects1 = new LinkedList<>();
        boolean a = map.get(1).equals("a");
        System.out.println(a);
        System.out.println(s);
        HashSet<Object> objects2 = new HashSet<>();

        String x = "string";
        String y = "string";
        StringBuffer stringBuffer = new StringBuffer();
        boolean equals = x.equals(y);
        Cat c1 = new Cat("王磊");
        Cat c2 = new Cat("王磊");
        System.out.println(c1.equals(c2));

        HashMap<String,String> map2 = new HashMap<>();

        map2.put("1","1");
    }

}
