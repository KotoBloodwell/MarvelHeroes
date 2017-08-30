package koto.marvel.Api;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.Converter.*;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KOTO on 28/08/2017.
 */

public class MarvelService {



    public static Marvel getMarvelApi(){

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request originalRequest = chain.request();

                HttpUrl originalURL = originalRequest.url();

                HttpUrl httpUrl = originalURL.newBuilder()
                        .addQueryParameter(Marvel.API_KEY_KEY,Marvel.API_KEY_VALUE)
                        .addQueryParameter(Marvel.HASH_KEY,Marvel.HASH_VALUE)
                        .addQueryParameter(Marvel.TIME_STAMP_KEY,Marvel.TIME_STAMP_VALUE)
                        .build();

                Request.Builder requestBuilder = originalRequest.newBuilder().url(httpUrl);
                Request request = requestBuilder.build();

                return chain.proceed(request);
            }
        }).build();

        return new Retrofit.Builder()
                .baseUrl(Marvel.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Marvel.class);

    }
}
