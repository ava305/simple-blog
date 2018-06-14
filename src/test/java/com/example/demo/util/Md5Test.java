package com.example.demo.util;

import com.example.demo.util.Md5;
import org.junit.Assert;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by weidaogang on 18/6/14.
 */
public class Md5Test {


    @Test
    public void testMd5(){
        String s="123";

        String md5Value= Md5.md5(s);
        Assert.assertTrue("202cb962ac59075b964b07152d234b70".equals(md5Value));
    }
}
