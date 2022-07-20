package com.keeson;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @author: Jeff.zheng
 * @description:
 * @date: 2022/7/20 15:02
 * @version: 1.0.0
 */
public class TestToken {
    public  static  String token ="token";//这里放要破解的token

    public static void main(String[] args) {


        String [] mykeys = {"sercet1","sercet2","sercet3","sercet4" };//这里放可能的秘钥
        for (String mykey :mykeys ) {
            if(forceToken(mykey)){
                System.out.println("成功，key=》"+mykey);//成功的key
            }else {
                System.out.println("失败，key=》"+mykey);//失败的key
            }
        }
    }


    static Boolean forceToken(String secrete){
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secrete)).build();
            DecodedJWT verify = null;
            verify = jwtVerifier.verify(token);
            return  true;
        }catch (Exception e){
            return false;
        }
    }
}
