package com.example.interface2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ViewGroup transitionsContainer;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transitionsContainer = findViewById(R.id.transitions_container);
        button = transitionsContainer.findViewById(R.id.centro);

        button.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    //tamaño
                    case MotionEvent.ACTION_DOWN:
                        startButtonAnimation(1.0f, 0.8f);
                        break;
                    case MotionEvent.ACTION_UP:
                        startButtonAnimation(0.8f, 1.0f);
                        break;
                }
                return false;
            }
        });
    }

    private void startButtonAnimation(float startScale, float endScale) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                startScale, endScale,
                startScale, endScale,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        scaleAnimation.setDuration(150);
        scaleAnimation.setFillAfter(true);

        button.startAnimation(scaleAnimation);
    }




}













