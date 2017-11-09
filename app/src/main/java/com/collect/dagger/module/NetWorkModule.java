package com.collect.dagger.module;

import com.collect.base.GlobalValue;
import com.collect.retrofit.AuthenticationInterceptor;
import com.collect.retrofit.BaseUrlInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangyuncai on 2017/11/6.
 */
@Module
public class NetWorkModule {
    private NetWorkModule() {

    }

    @Provides
    @Singleton
    public static HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @Singleton
    public static BaseUrlInterceptor providesBaseUrlInterceptor() {
        return new BaseUrlInterceptor();
    }

    private static final long TIMEOUT_CONNECT = 60 * 1000;

    @Provides
    @Singleton
    public static OkHttpClient provideOkhttpClient(HttpLoggingInterceptor httpLoggingInterceptor,
                                                   BaseUrlInterceptor baseUrlInterceptor) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.connectTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS);
        builder.writeTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS);
        builder.readTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS);

        builder.addNetworkInterceptor(new AuthenticationInterceptor());
        builder.addInterceptor(baseUrlInterceptor);
        builder.addInterceptor(httpLoggingInterceptor);

        return builder.build();


    }

    @Singleton
    @Provides
    public static Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GlobalValue.BASE_API_URL)
                .validateEagerly(true)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;

    }
}
