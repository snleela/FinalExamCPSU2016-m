package com.example.finalexamcpsu2016;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalexamcpsu2016.model.loginDatabaseAdapter;



public class RegisterActivity extends AppCompatActivity {



        EditText editTextUserName, editTextPassword, editTextUser;
        Button btnCreateAccount;
        loginDatabaseAdapter loginDataBaseAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);


            loginDataBaseAdapter = new loginDatabaseAdapter(this);
            loginDataBaseAdapter = loginDataBaseAdapter.open();

            editTextUserName = (EditText) findViewById(R.id.editTextUserName);
            editTextUser = (EditText) findViewById(R.id.editTextUser);
            editTextPassword = (EditText) findViewById(R.id.editTextPassword);


            btnCreateAccount = (Button) findViewById(R.id.buttonCreateAccount);
            btnCreateAccount.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    String userName = editTextUserName.getText().toString();
                    String User = editTextUser.getText().toString();
                    String password = editTextPassword.getText().toString();


                    if (userName.equals("") || password.equals("")) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);

                        builder.setMessage("Registionfail");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                            }
                        });
                        builder.show();
                    }

                    if (!userName.equals(userName)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);

                        builder.setMessage("Registionfail");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                            }
                        });
                        builder.show();
                    } else {

                        loginDataBaseAdapter.insertEntry(userName,User, password);
                        Toast.makeText(getApplicationContext(), "Created Account Successfully ", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

        @Override
        protected void onDestroy() {
            // TODO Auto-generated method stub
            super.onDestroy();

            loginDataBaseAdapter.close();
        }
    }
