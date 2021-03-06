package com.pentagon.p01_android_proj.login;

import com.pentagon.p01_android_proj.login.forget.ForgetResponse;
import com.pentagon.p01_android_proj.login.login.LoginRequest;
import com.pentagon.p01_android_proj.login.mime.GetUserResponse;
import com.pentagon.p01_android_proj.login.register.RegisterRequest;
import com.pentagon.p01_android_proj.login.register.RegisterResponse;
import com.pentagon.p01_android_proj.model.User;
import com.pentagon.p01_android_proj.util.http.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginModel {

    public void login(Callback<LoginResponse> callback, User user) throws Exception {
        // baseUrl() 设置路由地址
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(ApiUtils.BUYER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(user.getUsername());
        loginRequest.setPassword(user.getPassword());

        // 设置参数
        Call<LoginResponse> call = retrofit.create(UserMgrService.class)
                .login(loginRequest);

        // 回调
        call.enqueue(callback);

    }

    public void register(Callback<RegisterResponse> callback, User user) throws Exception {
        // baseUrl() 设置路由地址
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(ApiUtils.BUYER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername(user.getUsername());
        registerRequest.setPassword(user.getPassword());

        // 设置参数
        Call<RegisterResponse> call = retrofit.create(UserMgrService.class)
                .register(registerRequest);

        // 回调
        call.enqueue(callback);

    }

    public void reset(Callback<ForgetResponse> callback, User user) throws Exception {
        // baseUrl() 设置路由地址
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(ApiUtils.BUYER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 设置参数
        Call<ForgetResponse> call = retrofit.create(UserMgrService.class)
                .reset(user.getUsername(), user.getPassword());

        // 回调
        call.enqueue(callback);

    }

    public void getUserById(String user_id, Callback<GetUserResponse> callback) {
        // baseUrl() 设置路由地址
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(ApiUtils.BUYER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 设置参数
        Call<GetUserResponse> call = retrofit.create(UserMgrService.class)
                .getUserInfo(user_id);

        // 回调
        call.enqueue(callback);

    }
}
