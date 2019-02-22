/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity {

  // Method for signup
  public void signUp(View view){
    Intent intent = new Intent(this,signUpActivity.class);
    startActivity(intent);
  }
  public void loginClick(View view){
    EditText usernameEditText = (EditText)findViewById(R.id.usernameEditText);
    EditText passwordEditText = (EditText)findViewById(R.id.passwordEditText);
    if(usernameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")){
      Toast.makeText(this,"Missing Field", Toast.LENGTH_LONG).show();
    }
    else{
      ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {
        @Override
        public void done(ParseUser parseUser, ParseException e) {
          if(e==null) {
            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
          }
          else{
            Toast.makeText(MainActivity.this, "Login Unsuccessful !! Check Username and Password", Toast.LENGTH_SHORT).show();
          }
        }
      });
    }
  }
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}