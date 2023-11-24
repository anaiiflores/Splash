package com.example.interface1;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.GridLayout;


import androidx.core.view.GestureDetectorCompat;


public class MainActivity extends Activity {

    int matrizButtons [][];
    int filas = 4;
    int columnas = 4;
    Button buttons;
    private GestureDetectorCompat mDetector;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());
        int numAlea = (int) (Math.floor(Math.random()*(16-1+1)+1));
        int numAlea2 = (int) (Math.floor(Math.random()*(16-1+1)+1));
int id =0;
        for(int i=0;i<filas;i++){
            for (int j=0;j<columnas;j++){
                id++;

                int buttonId = getResources().getIdentifier("but" + (id), "id", getPackageName());


                 buttons = findViewById(buttonId);

                buttons.setText("2");
                //cambiar el color.
            }


        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final String DEBUG_TAG = "Gestures";




        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {


            float posx = event2.getX() - event1.getX();
            float posy = event2.getY() - event1.getY();


            if (Math.abs(posx) > Math.abs(posy)) {
                if (posx > 0) {
                    Log.d(DEBUG_TAG, "hacia derecha");
                } else {
                    Log.d(DEBUG_TAG, "hacia izquierda");
                }
            } else {
                if (posy > 0) {
                    Log.d(DEBUG_TAG, "hacia abajo");
                } else {
                    Log.d(DEBUG_TAG, "hacia arriba");
                }
            }


            return true;
        }
    }
}


