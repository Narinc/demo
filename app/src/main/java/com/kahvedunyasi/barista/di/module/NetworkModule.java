package com.kahvedunyasi.barista.di.module;

import com.kahvedunyasi.barista.BuildConfig;
import com.kahvedunyasi.barista.data.network.error.RxErrorHandlingCallAdapterFactory;
import com.kahvedunyasi.barista.data.network.service.RobotposService;
import com.kahvedunyasi.barista.data.network.serviceimpl.barista.RobotbosServiceImpl;

import java.io.IOException;
import java.util.Calendar;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    public NetworkModule() {

    }

    @Provides
    Retrofit getRetrofit() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new Retrofit.Builder()
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request request = chain.request().newBuilder()
                                        .addHeader("Date", Calendar.getInstance().getTime().toString())
                                        .addHeader("Content-Type", "application/json")
                                        .addHeader("Language", "TR")
                                        .build();
                                return chain.proceed(request);
                            }
                        })
                        .addInterceptor(loggingInterceptor).build())
                .baseUrl(BuildConfig.BASE_URL)
                .build();

        // if you want to try Sample Service, you can change BASE_URL with SAMPLE_URL
    }

    /*@Provides
    public LoginServiceImpl providesLoginService(
            Retrofit retrofit) {
        return retrofit.create(LoginServiceImpl.class);
    }

    @Provides
    public LoginService providesLoginServiceHelper(
            LoginServiceImpl loginServiceImpl) {
        return new LoginService(loginServiceImpl);
    }*/

    /* barista */
    @Provides
    @SuppressWarnings("unused")
    public RobotbosServiceImpl providesRobotPosService(
            Retrofit retrofit) {
        return retrofit.create(RobotbosServiceImpl.class);
    }

    @Provides
    @SuppressWarnings("unused")
    public RobotposService providesRobotposServiceHelper(
            RobotbosServiceImpl robotbosServiceImpl) {
        return new RobotposService(robotbosServiceImpl);
    }
    /* barista */

}
