package com.example.reivin.logi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText user;
    private EditText contra;
    private TextView info;
    private Button login;
    private Button regis;
    private int cont=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=(EditText)findViewById(R.id.txt_user);
        contra=(EditText)findViewById(R.id.txt_pass);
        info=(TextView)findViewById(R.id.alert);
        login=(Button)findViewById(R.id.bt_login);
        regis=(Button)findViewById(R.id.bt_registra);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(user.getText().toString(), contra.getText().toString());
            }
        });



    }


    private void validate(String username, String userpass){
        if ((username.equals("admin")) && (userpass.equals("1234"))){
            Intent intent=new Intent(MainActivity.this, menu.class);
            startActivity(intent);
        }else {
            cont--;
            info.setText("usuario o contraseña inconrreca" + String.valueOf(cont));
            if (cont == 0){
                login.setEnabled(false);
            }
        }

    }
}
