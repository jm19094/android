package co.raffler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import co.raffler.API.UserAccount;
import co.raffler.API.UserAccountAuthenticationListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new UserAccount().authenticate(getApplicationContext(), "peter@raffler.co", "PJM@9pel1981!", new UserAccountAuthenticationListener() {
            @Override
            public void onAuthentication() {
                Log.d("login", "LOGGED IN");
            }

            @Override
            public void onAuthenticationError() {
                Log.d("login", "FAILED TO LOG IN");
            }
        });
    }
}
