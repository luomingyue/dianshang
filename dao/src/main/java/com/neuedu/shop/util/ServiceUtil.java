package com.neuedu.shop.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceUtil {
	private ServiceUtil() {}
	public static void setEncoding(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
	}
	public static String getMD5String(String str) {
        try {
          
            MessageDigest md = MessageDigest.getInstance("MD5");
           
            md.update(str.getBytes());
            
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
	

}
