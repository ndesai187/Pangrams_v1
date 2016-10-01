package com.example.nirav.pangrams_v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CheckPangramsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_pangrams);
        Pangrams pg = new Pangrams();
        pg.userInput();
        Toast.makeText(this, "hijo de puta", Toast.LENGTH_LONG).show();
    }

    //dummy for commit
}
