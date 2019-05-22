package com.inspur.serializable_comparable;

import com.alibaba.fastjson.JSON;
import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.inspur.serializable.Person;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * User: YANG
 * Date: 2019/5/22-14:09
 * Description: No Description
 */
public class SerializableCompareTest {

    public static void main(String[] args) throws IOException {
        jackson();

        fastJSON();

        jprotobuf();

        hessian();
    }

    public static void jackson() throws IOException {
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(18);
        person.setHobbies("football");

        ObjectMapper mapper = new ObjectMapper();
        byte[] bytes = null;

        long start = System.currentTimeMillis();
        for(int i = 0; i < 100; i++){
            bytes = mapper.writeValueAsBytes(person);
        }
        long last = System.currentTimeMillis() - start;

        System.out.println("jackson 序列化字节数:" + bytes.length + ",总耗时:" + last);

        Person person1 = mapper.readValue(bytes, Person.class);
        System.out.println(person1);
    }

    public static void fastJSON(){
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(18);
        person.setHobbies("football");


        String jsonObject = null;

        long start = System.currentTimeMillis();
        for(int i = 0; i < 100; i++){
            jsonObject = JSON.toJSONString(person);
        }
        long last = System.currentTimeMillis() - start;

        System.out.println("fastJSON 序列化字节数:" + jsonObject.getBytes().length + ",总耗时:" + last);

        Person person1 = JSON.parseObject(jsonObject.getBytes(), Person.class);
        System.out.println(person1);
    }

    public static void jprotobuf() throws IOException {
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(18);
        person.setHobbies("football");

        Codec<Person> personCodec = ProtobufProxy.create(Person.class);

        byte[] bytes = null;

        long start = System.currentTimeMillis();
        for(int i = 0; i < 100; i++){
            bytes = personCodec.encode(person);
        }
        long last = System.currentTimeMillis() - start;

        System.out.println("jprotobuf 序列化字节数:" + bytes.length + ",总耗时:" + last);

        Person person1 = personCodec.decode(bytes);
        System.out.println(person1);
    }

    public static void hessian() throws IOException {
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(18);
        person.setHobbies("football");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        HessianOutput hessianOutput = new HessianOutput(bos);

        byte[] bytes = null;

        long start = System.currentTimeMillis();
        for(int i = 0; i < 100; i++){
            hessianOutput.writeObject(person);
            if(i == 0){
                bytes = bos.toByteArray();
            }
        }
        long last = System.currentTimeMillis() - start;

        System.out.println("hessian 序列化字节数:" + bytes.length + ",总耗时:" + last);

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        HessianInput hessianInput = new HessianInput(bis);

        Person person1 = (Person) hessianInput.readObject();
        System.out.println(person1);
    }
}
