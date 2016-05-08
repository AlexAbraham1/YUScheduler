package edu.yu.hackathon.yuscheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by alexabraham on 2/21/16.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, ScheduleMaker.class);
        intent.putExtra("ClassType", "YC");
        startActivity(intent);
        finish();
    }

}
