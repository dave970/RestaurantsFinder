package com.example.abbieturner.restaurantsfinder.Activitys;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;

import com.example.abbieturner.restaurantsfinder.R;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }




    @Override
    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finish();
            setEnterExitTransition(new Intent(MainActivity.this, CuisineActivity.class));
        } else {
            finish();
            startActivity(new Intent(MainActivity.this, CuisineActivity.class));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)  //Transactiom from activity to activity
    private void setEnterExitTransition(Intent intent) {
        getWindow().setExitTransition(new Fade().setDuration(1000));
        getWindow().setReenterTransition(new Fade().setDuration(1000));
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
    }
}
