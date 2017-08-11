package manandharbibesh.fcm.rest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Bibesh on 8/11/17.
 */

public interface InterfaceApi {
    @FormUrlEncoded
    @POST("firebase/getToken.php")
    Call<Void> saveToken(@Field("token") String token);
}
