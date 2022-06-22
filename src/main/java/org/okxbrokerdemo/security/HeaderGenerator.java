package org.okxbrokerdemo.security;

import okhttp3.Headers;
import okhttp3.Request;
import org.okxbrokerdemo.APIKeyHolder;

public interface HeaderGenerator {

    Headers generateHeaders(Request request, APIKeyHolder apiKeyHolder,boolean isSimulate,String baseUrl);
}
