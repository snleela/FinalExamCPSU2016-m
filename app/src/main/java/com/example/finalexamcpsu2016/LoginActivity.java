package com.example.finalexamcpsu2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalexamcpsu2016.model.loginDatabaseAdapter;


public class LoginActivity extends AppCompatActivity {
    loginDatabaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginDataBaseAdapter=new  loginDatabaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        final EditText editTextUserName=(EditText) findViewById(R.id.editTextUserNameToLogin);
        final  EditText editTextPassword=(EditText) findViewById(R.id.editTextPasswordToLogin);
        Button btnSignIn=(Button) findViewById(R.id.buttonSignIn);
        Button btnSignUp = (Button)findViewById(R.id.buttonSignUP);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub


                Intent intentSignUP = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intentSignUP);
            }
        });


        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String userName= editTextUserName.getText().toString();
                String password= editTextPassword.getText().toString();
                String storedPassword= loginDataBaseAdapter.getSinlgeEntry(userName);



               if(password.equals(storedPassword)|| userName.equals("") || password.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Invaid account or password", Toast.LENGTH_LONG).show();
                }
                else{
                Intent wel = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(wel);
                }

                {

                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.userlistactivity, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_show_list) {
            Intent intent = new Intent(this, UserListActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
