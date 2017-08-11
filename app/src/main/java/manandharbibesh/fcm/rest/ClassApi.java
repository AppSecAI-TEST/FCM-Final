package manandharbibesh.fcm.rest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bibesh on 8/11/17.
 */

public class ClassApi {

    String BASE_URL = "http://192.168.0.103/";

    public static ClassApi api = new ClassApi();
    Retrofit retrofit;

    public static ClassApi getInstance() {
        if (api == null) {
            api = new ClassApi();
        }
        return api;
    }


    public Retrofit makeRetrofit() {
        retrofit = new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL).build();
        return retrofit;
    }
}
