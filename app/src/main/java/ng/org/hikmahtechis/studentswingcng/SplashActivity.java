package ng.org.hikmahtechis.studentswingcng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** START - this is the purpose of this Activity */
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();


        /** END - everything more than this is time consuming */
    }
}