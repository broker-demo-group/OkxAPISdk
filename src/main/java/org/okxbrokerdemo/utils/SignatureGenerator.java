package org.okxbrokerdemo.utils;


import cn.hutool.core.util.StrUtil;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SignatureGenerator {
    /**
     * OK-ACCESS-SIGN的请求头是对timestamp + method + requestPath + body字符串（+表示字符串连接），以及SecretKey，使用HMAC SHA256方法加密，通过Base-64编码输出而得到的。
     * <p>
     * 如：sign=CryptoJS.enc.Base64.stringify(CryptoJS.HmacSHA256(timestamp + 'GET' + '/users/self/verify', SecretKey))
     * <p>
     * 其中，timestamp的值与OK-ACCESS-TIMESTAMP请求头相同，为ISO格式，如2020-12-08T09:08:57.715Z。
     * <p>
     * method是请求方法，字母全部大写：GET/POST。
     * <p>
     * requestPath是请求接口路径。如：/api/v5/account/balance
     * <p>
     * body是指请求主体的字符串，如果请求没有主体（通常为GET请求）则body可省略。如：{"instId":"BTC-USDT","lever":"5","mgnMode":"isolated"}
     **/
    public static String Generate(String timeStamp, String requestMethod, String requestBody, String requestPath, String secertKey) {
        String signStr = timeStamp + requestMethod + requestPath + (StrUtil.isEmpty(requestBody) ? StrUtil.EMPTY : requestBody);

        String result = null;
        try {
            Mac hmac_sha256 = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secertKey.getBytes(), "HmacSHA256");
            hmac_sha256.init(secret_key);
            result = Base64.getEncoder().encodeToString(hmac_sha256.doFinal(signStr.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
