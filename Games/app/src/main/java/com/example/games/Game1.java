package com.example.games;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;

import java.util.Random;

public class Game1 extends Activity {

    private Button[][] botones;
    private GestureDetector gestureDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        botones = new Button[4][4];

        // Asignar botones por sus IDs y agregarlos al array bidimensional
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int buttonId = getResources().getIdentifier("but" + (i * 4 + j + 1), "id", getPackageName());
                botones[i][j] = findViewById(buttonId);
            }
        }
        cambiarTextoEnPosicionAleatoria();
        cambiarTextoEnPosicionAleatoria();
//--
        gestureDetector = new GestureDetector(this, new MyGestureListener());


    }


    private void cambiarTextoEnPosicionAleatoria() {
        Random random = new Random();
        int filaAleatoria, columnaAleatoria;
        //int colorEspecifico = ContextCompat.getColor(this, R.color.colorFondo);

        do {
            filaAleatoria = random.nextInt(botones.length);
            columnaAleatoria = random.nextInt(botones[0].length);
        } while (!botones[filaAleatoria][columnaAleatoria].getText().toString().isEmpty());

        botones[filaAleatoria][columnaAleatoria].setBackgroundResource(R.drawable.button_draq);

        botones[filaAleatoria][columnaAleatoria].setText("2");
        botones[filaAleatoria][columnaAleatoria].setTextSize(20.890F);


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Delega el evento al GestureDetector
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event);
    }

    // Clase interna para escuchar gestos
    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float diffY = e2.getY() - e1.getY();

            // Verifica si el gesto es hacia arriba y si la distancia supera el umbral
            if (diffY < -SWIPE_THRESHOLD) {
                // Llama a la función para mover los botones hacia arriba
                moverBotonesHaciaArriba();
                return true;
            }

            return false;
        }
    }
// ... Otro código ...

    private void moverBotonesHaciaArriba() {
        // Implementa la lógica para mover los botones hacia arriba en la misma columna
        // Asegúrate de que no sobrepasen los límites

        for (int columna = 0; columna < botones[0].length; columna++) {
            // Encuentra los botones con texto "2" en la misma columna
            Button botonUltimo = null;
            Button botonPenultimo = null;

            for (int fila = botones.length - 1; fila >= 0; fila--) {
                if (botones[fila][columna].getText().toString().equals("2")) {
                    if (botonUltimo == null) {
                        botonUltimo = botones[fila][columna];
                    } else {
                        botonPenultimo = botones[fila][columna];
                        break;
                    }
                }
            }

            // Si hay dos botones, muévelos hacia arriba
            if (botonUltimo != null && botonPenultimo != null) {
                // Obtén las posiciones actuales de los botones
                int topUltimo = botonUltimo.getTop();
                int topPenultimo = botonPenultimo.getTop();

                // Obtén la altura de un botón
                int alturaBoton = botonUltimo.getHeight();

                // Asegúrate de que no sobrepasen los límites
                if (topUltimo > alturaBoton) {
                    // Mueve el último botón hacia arriba
                    botonUltimo.layout(
                            botonUltimo.getLeft(),
                            topUltimo - alturaBoton,
                            botonUltimo.getRight(),
                            topUltimo
                    );
                }

                if (topPenultimo > 0) {
                    // Mueve el penúltimo botón hacia arriba
                    botonPenultimo.layout(
                            botonPenultimo.getLeft(),
                            topPenultimo - alturaBoton,
                            botonPenultimo.getRight(),
                            topPenultimo
                    );
                }
            }
        }
    }
}