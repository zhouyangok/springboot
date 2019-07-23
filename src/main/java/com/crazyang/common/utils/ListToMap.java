package com.crazyang.common.utils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhouyang
 * @date 2019/7/17
 * @Description:
 */
public class ListDemo {
    public static void main(String[] args) {
        ListDemo demo = new ListDemo();
        demo.mapToList();
        demo.listToMap();
    }

    /**
     * 简单的map转String
     */
    public void mapToList() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "hello");
        map.put("2", "world");
        map.put("3", "!");
        map.put("4", "change");
        List<String> list = new ArrayList<>(map.keySet());
        List<String> list2 = new ArrayList<>(map.values());
        list.forEach(System.out::println);
        list2.forEach(System.out::println);
//        List list = (List) map.keySet().stream().collect(Collectors.toList());

        //java8应该使用的方式
        List<String> result = map.keySet().stream().collect(Collectors.toList());
        result.forEach(System.out::print);
        List<String> result1 = map.values().stream().collect(Collectors.toList());
        result1.forEach(System.out::println);
        System.out.println("---------------");
        List<String> result5 = map.values().stream()
                .filter(x -> !"apple".equalsIgnoreCase(x) && "java".equals(x))
                .collect(Collectors.toList());

        result5.forEach(System.out::println);


        //构建map对象
        Map<String, User> userMap = new HashMap();
        User user1 = new User(1, "user1", "user_1", 12);
        User user2 = new User(2, "user2", "user_2", 15);
        User user3 = new User(3, "user3", "user_3", 19);
        User user4 = new User(4, "user4", "user_4", 11);
        userMap.put("10", user1);
        userMap.put("20", user2);
        userMap.put("30", user3);
        userMap.put("40", user4);
        List<String> keyList = userMap.keySet().stream().collect(Collectors.toList());
        keyList.forEach(System.out::println);

        System.out.println("-----values----");
        List<User> values = userMap.values().stream().collect(Collectors.toList());
        values.forEach(x -> {
            System.out.println(x.getName());
        });
        System.out.println("-----userfilter过滤----");
        List<User> userfilter = userMap.values().stream().filter(
                x -> 13 < x.getAge()).collect(Collectors.toList());
        userfilter.forEach(System.out::println);
        System.out.println("-----userSorts排序----");
        List<User> userSorts = userMap.values().stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        userSorts.forEach(x->{
            System.out.println(x.getName());
        });
    }

    public void listToMap() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "list1", "user_1", 12);
        User user2 = new User(2, "list2", "user_2", 15);
        User user3 = new User(3, "list3", "user_3", 19);
        User user4 = new User(4, "list4", "user_4", 11);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        Map<Integer,User> userMap = userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
//        Map<Integer, String> maps = userList.stream().collect(Collectors.toMap(User::getId, User::getAge, (key1, key2) -> key2));

        for(Integer i:userMap.keySet()){
            System.out.println(userMap.get(i).getName());
        }
    }
}

class User {
    private int id;

    private String name;

    private String nickName;

    private int age;

    public User() {
    }

    public User(int id, String name, String nickName, int age) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
