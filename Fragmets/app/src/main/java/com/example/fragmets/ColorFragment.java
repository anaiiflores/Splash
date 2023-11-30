package com.example.fragmets;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class ColorFragment extends Fragment {

    private static final String TAG = "ColorFragment";
    private View rootView;

    public ColorFragment() {
        // Constructor vacío requerido por Fragment.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla el diseño del fragment.
        rootView = inflater.inflate(R.layout.fragment_color, container, false);
        Log.i(TAG, "onCreateView");

        // Configura el botón para cambiar el color
        Button changeColorButton = rootView.findViewById(R.id.changeColorButton);
        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBackgroundColor();
            }
        });

        return rootView;
    }

    private void changeBackgroundColor() {
        // Cambia el color de fondo al azar
        int color = Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        rootView.setBackgroundColor(color);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }
}
