package org.okxbrokerdemo.security.imp;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import org.okxbrokerdemo.APIKeyHolder;
import org.okxbrokerdemo.security.HeaderGenerator;
import org.okxbrokerdemo.security.utils.SignatureGenerator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class OkxHeaderGenerator implements HeaderGenerator {


    @Override
    public Headers generateHeaders(Request request, APIKeyHolder apiKeyHolder,boolean isSimulate,String baseUrl) {
        Headers.Builder headerBuilder = new Headers.Builder();
        headerBuilder.add("Content-Type", "application/json");

        if(isSimulate){
            headerBuilder.add("x-simulated-trading","1");
        }
        String timeStamp = Instant.now().toString();
        headerBuilder.add("OK-ACCESS-KEY",apiKeyHolder.getApiKey());
        headerBuilder.add("OK-ACCESS-SIGN", SignatureGenerator.Generate(timeStamp,
                                                                    request.method().toUpperCase(),
                                                                    getBody(request),
                                                                    getPath(request,baseUrl),
                                                                    apiKeyHolder.getSecretKey()));
        headerBuilder.add("OK-ACCESS-TIMESTAMP",timeStamp);
        headerBuilder.add("OK-ACCESS-PASSPHRASE",apiKeyHolder.getPassPhrase());
        return headerBuilder.build();
    }

    public static String getPath(Request request,String baseUrl){
        // todo 考虑其他异常情况
        String url = request.url().toString();
        return url.replace(baseUrl,"");
    }

    public static String getBody(Request request) {

        RequestBody body = request.body();
        if (body == null) {
            return "";
        }
        Buffer buffer = new Buffer();
        try {
            body.writeTo(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return buffer.readString(Charset.defaultCharset());

    }
}
