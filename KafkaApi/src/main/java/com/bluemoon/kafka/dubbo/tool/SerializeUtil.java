package com.bluemoon.kafka.dubbo.tool;

import java.io.*;

/**
 * 简易序列化工具,报错需要调用者自己抓取
 *
 * Created by LeonWong on 15/10/15.
 */
public class SerializeUtil {
    /**
     * 序列化，将对象存储为二进制数据，这里返回字节数组
     *
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        return baos.toByteArray();
    }

    /**
     * 反序列化，将二进制数据转化为对象
     *
     * @param bytes
     * @return
     */
    public static Object unserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        return ois.readObject();
    }
}
