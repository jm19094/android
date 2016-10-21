package co.raffler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import co.raffler.Model.Country;
import co.raffler.Model.Prize;
import co.raffler.Model.Province;
import co.raffler.Model.Winner;
import co.raffler.Networking.RafflerAPIRequest;
import co.raffler.Networking.RafflerArrayListener;
import co.raffler.Networking.RafflerArrayRequestHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
