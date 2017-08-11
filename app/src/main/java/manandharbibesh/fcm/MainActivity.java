package manandharbibesh.fcm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.iid.FirebaseInstanceId;

import manandharbibesh.fcm.rest.ClassApi;
import manandharbibesh.fcm.rest.InterfaceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(FirebaseInstanceId.getInstance().getToken());
        Retrofit retrofit = ClassApi.getInstance().makeRetrofit();
        final InterfaceApi res = retrofit.create(InterfaceApi.class);
        Call<Void> result = res.saveToken(FirebaseInstanceId.getInstance().getToken());
        result.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println(response.message());
                System.out.println(response.code());
                System.out.println(response.errorBody());
                System.out.println(response.headers());
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
