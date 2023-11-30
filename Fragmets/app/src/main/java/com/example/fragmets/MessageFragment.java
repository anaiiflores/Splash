package com.example.fragmets;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class MessageFragment extends Fragment {

    private static final String TAG = "MessageFragment";

    public MessageFragment() {
        // Constructor vacío requerido por Fragment.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla el diseño del fragment.
        View rootView = inflater.inflate(R.layout.fragment_message, container, false);
        Log.i(TAG, "onCreateView");

        return rootView;


        // Configura el OnClickListener para el botón
        Button btnSwitchFragment = findViewById(R.id.buttonFra);
        btnSwitchFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Reemplaza el fragmento actual con el fragmento de colores
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.buttonFra, new ColorFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

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
