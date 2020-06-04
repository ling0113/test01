package com.test.test01.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: com.test.test01.list.TwoList
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/4/30 10:56
 * @Version: 1.0
 */
public class TwoList {

    public static void main(String[] args) {
        ArrayList<Object> c = new ArrayList<>();
        ArrayList<Object> a = new ArrayList<>();
        a.add("aa");
        a.add("bb");
        a.add("cc");
        a.add("dd");
        a.add("ee");
        a.add("ff");
        a.add("gg");
        a.add("hh");
        a.add("yy");
        a.add("qq");
        a.add("ww");
        a.add("ee");
        a.add("zz");
        ArrayList<Object> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(4);
        b.add(5);
        b.add(6);
        b.add(7);
        b.add(8);
        b.add(9);

        ArrayList<Object> d = new ArrayList<>();
        d.add("&&");
        d.add("!!");
        d.add("@@");
        d.add("$$");
        d.add("%%");
        d.add("^^");
        d.add("**");
        d.add("((");

        // 6/4
        int aSize = a.size();
        int x = aSize / 6;
        if (aSize%6>0){
            x++;
        }
        int bSize = b.size();
        int y = bSize / 4;
        if (bSize%4 >0){
            y++;
        }
        int dSize = d.size();
        int z = dSize / 2;
        if (dSize%2 >0){
            z++;
        }

        int max = Math.max(x, y);
        max = Math.max(max, z);

        //6:2:4存放
        for (int i = 0; i < max; i++) {

            if (i<=x-1) {
                if ((i * 6 + 5) <= (aSize-(aSize%6)-1)) {
                    c.addAll(a.subList(i * 6, i * 6 + 6));
                } else  {
                    c.addAll(a.subList(i * 6, aSize));
                }
            }

            if (i<=z-1) {
                if ((i * 2 + 1) <= (dSize-(dSize%2)-1)) {
                    c.addAll(d.subList(i * 2, i * 2 + 2));
                } else  {
                    c.addAll(d.subList(i * 2, dSize));
                }
            }

            if (i<=y-1) {
                if ((i * 4 + 3) <= (bSize-(bSize%4)-1)) {
                    c.addAll(b.subList(i * 4, i * 4 + 4));
                } else {
                    c.addAll(b.subList(i * 4, bSize));
                }
            }
        }
        System.out.println(c);


    }

}
