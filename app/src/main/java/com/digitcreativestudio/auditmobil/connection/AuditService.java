package com.digitcreativestudio.auditmobil.connection;

import com.digitcreativestudio.auditmobil.connection.parser.LoginParser;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by faqiharifian on 03/05/16.
 */
public interface AuditService {
    @POST
    Call<LoginParser> login(@Query("email") String email, @Query("password") String password);
}
