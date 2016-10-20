package co.raffler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import co.raffler.Model.Country;
import co.raffler.Networking.RafflerAPIRequest;
import co.raffler.Networking.RafflerArrayListener;
import co.raffler.Networking.RafflerArrayRequestHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RafflerAPIRequest request = new RafflerAPIRequest("https://api.raffler.co/country", false, 1);
        new RafflerArrayRequestHandler()
                .retrieveObjects(request,
                        new Country.CountryFactory(),
                        getApplicationContext(),
                        new RafflerArrayListener<Country>() {
                            @Override
                            public void onGot(List<Country> countries) {
                                for (int i = 0; i < countries.size(); i++) {
                                    Log.d("ARRAY TEST", countries.get(i).getName());
                                }
                            }

                            @Override
                            public void onError() {
                                Log.d("ARRAY TEST", "COUNTRY REQUEST FAILED");
                            }
                        });


    }
}
