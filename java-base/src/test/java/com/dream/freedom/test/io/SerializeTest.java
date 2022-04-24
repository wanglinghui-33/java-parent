package com.dream.freedom.test.io;

import com.dream.freedom.io.SerializeAndDeSerialize;
import org.junit.Test;

public class SerializeTest {

    @Test
    public void test(){
        SerializeAndDeSerialize ser = new SerializeAndDeSerialize();
        ser.serializeTest();
        ser.deSerializableTest();

    }

    @Test
    public void test2(){
        SerializeAndDeSerialize ser = new SerializeAndDeSerialize();
        ser.serializeTest2();
        ser.deSerializableTest2();


    }
}
