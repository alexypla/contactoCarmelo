package com.example.usuario.contactoscarmelo;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioGroup rg;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    rb1=(RadioButton)findViewById(R.id.radioButton);
    rb2=(RadioButton)findViewById(R.id.radioButton2);
    rg=(RadioGroup) findViewById(R.id.radioGroup);
    bt=(Button)findViewById(R.id.button);
        Intent i=new Intent();

    }
public void btA(View v){
        rb3=(RadioButton)findViewById( rg.getCheckedRadioButtonId());

    getIntent().putExtra("opcion",rb3.getText());
}

}
