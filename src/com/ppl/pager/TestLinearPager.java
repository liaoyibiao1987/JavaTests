package com.ppl.pager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestLinearPager {
    public static void main(String[] args) {
        String[] names = new String[]{"第一页", "万物", "里斯", "勾留", "起吧", "南京市",
                "第二页", "pai", "挂镀", "三爷", "三槐", "琉璃",
                "第三页", "额度", "io", "越界", "lobotomy", "挂机面",
                "第四页"};
        List<Person> list = new ArrayList<>();
        for (String x : names) {
            Person p = new Person(x, 20);
            list.add(p);
        }
        LinearPager<Person> pager = new LinearPager<>(6);
        pager.init(list);
        pager.setOnDataSourceChangedEventHandler(new LinearPager.DataSourceChangedEventHandle() {
            @Override
            public void OnDataChanged(Object o) {
                List<Person> list1 = (List<Person>) o;
                if (list1 != null) {
                    System.out.println("OnDataChanged===");
                    for (Person x : list1) {
                        System.out.println(x.toString());
                    }
                } else {
                    System.out.println("OnDataChanged is null");
                }
            }
        });
        Random random = new Random(1);

        for (int i = 0; i < 200; i++) {
            int r = random.nextInt(2);
            List<Person> temp;
            if (r % 2 == 1) {
                System.out.println("getNextPage:" + i);
                temp = pager.getNextPage();
            } else {
                System.out.println("getPreviousPage:" + i);
                temp = pager.getPreviousPage();
            }
            if (temp != null) {
                for (Person x : temp) {
                    System.out.println(x.toString());
                }
            }
        }

        List<Person> list2 = new ArrayList<>();
        for (String x : names) {
            Person p = new Person("New" + x, 200);
            list2.add(p);
        }
        pager.update(list2, null);

        for (int i = 0; i < 100; i++) {
            int r = random.nextInt(2);
            List<Person> temp;
            if (r % 2 == 1) {
                System.out.println("getNextPage:" + i);
                temp = pager.getNextPage();
            } else {
                System.out.println("getPreviousPage:" + i);
                temp = pager.getPreviousPage();
            }
            if (temp != null) {
                for (Person x : temp) {
                    System.out.println(x.toString());
                }
            }
        }
    }
}
