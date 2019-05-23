package com.inspur.rmi.serializable;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

import java.io.Serializable;

/**
 * User: YANG
 * Date: 2019/5/22-10:40
 * Description: No Description
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 3981042496935043356L;

    private static int height = 88;
    private transient int weight;

    @Protobuf(fieldType = FieldType.INT32, order = 1)
    private int age;

    @Protobuf(fieldType = FieldType.STRING, order = 2)
    private String name;

    @Protobuf(fieldType = FieldType.STRING, order = 3)
    private String hobbies;

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        Person.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }
}
