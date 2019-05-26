package com.inspur.java_api.distribution_lock.java_api.rmi.serializable;

import java.io.*;

/**
 * User: YANG
 * Date: 2019/5/22-10:47
 * Description: No Description
 * 序列化总结:
 *      1.序列化必须要实现Serializable接口
 *      2.父类如果没有实现Serializable接口那么内部的所有属性都不会进行序列化
 *      3.序列化时对堆内存进行的,所以静态变量是不支持序列化的!
 *      4.transient 关键字 不支持序列化
 */
public class SerializableTest {

    public static void main(String[] args){
        serializablePerson();
        readSerializablePerson();
    }

    public static void serializablePerson(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("person.obj")));
            Person person = new Person();
            person.setHeight(181);
            person.setWeight(88);
            person.setName("Yang");
            person.setAge(18);
            person.setHobbies("football");

            oos.writeObject(person);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(oos != null){
                    oos.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

            }
        }
    }
    public static void readSerializablePerson(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("person.obj")));
            Person person = (Person) ois.readObject();
            System.out.println(person);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(ois != null){
                    ois.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

            }
        }
    }
}
