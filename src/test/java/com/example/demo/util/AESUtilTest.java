package com.example.demo.util;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by weidaogang on 18/6/14.
 */
public class AESUtilTest {

    @Test
    public void testEncrypt(){

        String text="你好";

        String encryedText=AESUtil.encrypt(text,"12345678");

        String decryedText=AESUtil.decrypt(encryedText,"12345678");


        Assert.assertThat(decryedText, CoreMatchers.equalTo(text));
    }
}
