package com.example.scroll;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText articleEditText;
    Button addCommentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        articleEditText = findViewById(R.id.article);
        addCommentButton = findViewById(R.id.but);

        addCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(addCommentButton.getText().equals("Add comment")){
                   articleEditText.setEnabled(true);
                   addCommentButton.setText("Set comment");

               }else if(addCommentButton.getText().equals("Set comment")){

                   articleEditText.setEnabled(false);
                   addCommentButton.setText("Add comment");
               }
            }
        });
    }
}
