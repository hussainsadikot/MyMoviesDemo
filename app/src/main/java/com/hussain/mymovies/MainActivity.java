package com.hussain.mymovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.hussain.mymovies.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    String email, password;
    boolean emailCheck = false, passwordCheck = false;

    int passMin = 8;
    int passMax = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.submitButton.setEnabled(false);
//        emailValidator(email);
//        passwordValidator(password);
//        checkEverything();
        email = binding.etEmailAddress.getText().toString().trim();
        password = binding.etPassword.getText().toString().trim();

        binding.etEmailAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailCheck =emailValidator(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordCheck= passwordValidator(s.toString());
                binding.submitButton.setEnabled(emailCheck && passwordCheck);

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Working", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MovieActivity.class);
                startActivity(intent);
            }
        });


    }

//    private TextWatcher loginTextWatcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//            checkEverything();
//        }
//    };


        public void checkEverything() {
            email = binding.etEmailAddress.getText().toString().trim();
            password = binding.etPassword.getText().toString().trim();
            if (!emailValidator(email)) {
                emailValidator(email);
            }
            if (!passwordValidator(password)) {
                passwordValidator(password);
            }


        }


        public boolean emailValidator(String email) {
            if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(MainActivity.this, "Email is valid", Toast.LENGTH_SHORT).show();
//                emailCheck = true;
                return true;
            } else {
//            Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
                binding.etEmailAddress.setError("Enter valid Email address !");
//                emailCheck = false;
                return false;
            }

        }

        public boolean passwordValidator(String pass) {
//        pass = binding.etPassword.getText().toString();
            if(!(pass.length() >= passMin && pass.length() <= passMax)){
                binding.etPassword.setError("Password size limitation between 8 to 15 characters");

                return false;
            }else{
                return true;
            }

        }


 }
