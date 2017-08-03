package syahrulnizam.stormy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Stormy extends AppCompatActivity {
    private static final String TAG = Stormy.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String apiKey = "942f954f9b822b85b631edb377916c4c";
        double latitude = 37.8267;
        double longitude = -122.4233;
        String forecastUrl ="https://api.darksky.net/forecast/"+apiKey+"/"+latitude+","+longitude;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(forecastUrl).build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            if(response.isSuccessful()) {
                Log.v(TAG,response.body().string());
            }

        } catch (IOException e) {
            Log.e(TAG,"EXCEIPTION CAUGHT",e);
        }

    }
}
