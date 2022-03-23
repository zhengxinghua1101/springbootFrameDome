package com.keeson.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import java.util.Calendar;
import java.util.HashMap;

@Component
public class JWTUtils {



    /**
     * 加密秘钥
     */
    private  static String secrete = "secrete1";

    /**
     * 有效时间
     */
    private  static  Integer second = 60*60;


    /**
     * 加密
     * @param userId
     * @return
     */
     public  String createToken(String  userId){
         Calendar calendar = Calendar.getInstance();
         calendar.add(Calendar.SECOND, second);//一小时
         String token =  JWT.create().withHeader(new HashMap<>())
                 .withClaim("userId",userId)
                 .withExpiresAt(calendar.getTime())
                 .sign(Algorithm.HMAC256(secrete));
         return  token;
     }

    /**
     * 解密
     * @param token
     * @return
     */
    public  String verifyToken(String  token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secrete)).build();
        DecodedJWT verify = null;
        try {
            verify = jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            System.out.println("解析token发生错误");
            return  "";
        }
        Claim userId = verify.getClaim("userId");
        return  userId.asString();
    }



}
