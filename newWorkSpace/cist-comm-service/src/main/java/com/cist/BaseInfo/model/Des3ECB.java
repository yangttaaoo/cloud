
package com.cist.BaseInfo.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Des3ECB {
      public static String EncoderByMd5(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
    	  MessageDigest md5=MessageDigest.getInstance("MD5");
    	  BASE64Encoder base64en = new BASE64Encoder();
    	  //加密后的字符串
    	  String md5str=base64en.encode(md5.digest(str.getBytes("utf-8")));
    	  return  md5str;
      }
      /**判断用户密码是否正确
          * @param newpasswd  用户输入的密码
          * @param oldpasswd  数据库中存储的密码－－用户密码的摘要
          * @return
          * @throws NoSuchAlgorithmException
          * @throws UnsupportedEncodingException
          */
      public static boolean checkpassword(String newpasswd,String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException{
    	if(EncoderByMd5(newpasswd).equals(oldpasswd))
    	return true;
    	 else
    	 return false;
    }
}