package com.example.tourguide;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Class that initializes the Main Activity for the app.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.createFancyButton(MainActivity.this, R.id.main_btn, R.drawable.ic_next, getText(R.string.main));
        Utils.openCategoriesActivity(MainActivity.this, R.id.main_btn, 0);

    }

}
