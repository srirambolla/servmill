package com.servmill.www.servmill2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView logtext;
    EditText loguserId, logpass, logmobile;
    Button logbutton, newuser;
    String name, password, mobile;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logtext = (TextView) findViewById(R.id.login);
        loguserId = (EditText) findViewById(R.id.loguser);
        logpass = (EditText) findViewById(R.id.logpass);
        logbutton = (Button) findViewById(R.id.logbutton);
        newuser = (Button) findViewById(R.id.newuser);
        logmobile = (EditText) findViewById(R.id.logmobile);

        prefs = getSharedPreferences("loginDetails", MODE_PRIVATE);

        final String mobileNumber = prefs.getString("mobileNumber", "0");
        final String passwordSaved = prefs.getString("password", "0");




        logbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                name = loguserId.getText().toString();
                password = logpass.getText().toString();
                mobile = logmobile.getText().toString();

                if (mobile.matches(mobileNumber) && passwordSaved.matches(password)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), " Invalid email or username ", android.widget.Toast.LENGTH_SHORT).show();
                }

                if (name.equalsIgnoreCase("")) {
                    loguserId.setHint("please enter email address");//it gives user to hint
                    loguserId.setError("please enter email address");//it gives user to info message //use any one username.setHint("please enter user name" );//it gives user to hint

                } else if (mobile.equalsIgnoreCase("")) {
                    logmobile.setHint("please enter email address");//it gives user to hint
                    logmobile.setError("please enter email address");//it gives user to info message //use any one username.setHint("please enter user name" );//it gives user to hint
                } else {
                    //  Toast.makeText(getApplicationContext(), " Invalid email or username ", android.widget.Toast.LENGTH_SHORT).show();

                }

            }
        });
        newuser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "You Have To Register First  ", android.widget.Toast.LENGTH_SHORT).show();


            }
        });
    }

}




