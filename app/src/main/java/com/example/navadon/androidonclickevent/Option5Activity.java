package com.example.navadon.androidonclickevent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// TODO: View.OnClickListener as inner class and selecting view via id

public class Option5Activity extends AppCompatActivity {

    private EditText etInput;
    private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option5);
        bindView();
        initView();
    }

    // To bind views to this activity
    private void bindView(){
        etInput = findViewById(R.id.et_input_5);
        tvOutput = findViewById(R.id.tv_body_5);

    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_process_5).setOnClickListener(new InnerOnClickListener());

        findViewById(R.id.btn_next5).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.btn_back5).setOnClickListener(new InnerOnClickListener());
    }

    // A class that handles all of click events
    // It is private from other android class since it is within the Activity.
    class InnerOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_process_5:
                    greet();
                    break;
                case R.id.btn_next5:
                    Intent intent0 = new Intent(Option5Activity.this, Option0Activity.class);
                    startActivity(intent0);
                    break;
                case R.id.btn_back5:
                    Intent intent4 = new Intent(Option5Activity.this, Option4Activity.class);
                    startActivity(intent4);
                    break;
            }
            hideKeyboardInput(v);
        }
    }

    // To greet the user
    private void greet(){
        tvOutput.setText(getString(R.string.greeting) + " " + etInput.getText().toString());
    }

    // To hide Android soft keyboard
    private void hideKeyboardInput(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
