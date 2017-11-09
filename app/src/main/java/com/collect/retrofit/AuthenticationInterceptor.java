package com.collect.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhangyuncai on 2017/11/6.
 */

public class AuthenticationInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        request = builder.addHeader("client", "app").build();

        return chain.proceed(request);
    }
}
