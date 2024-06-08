package com.batu.isimsehiroyunu;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void btnAnasayfaAyar(View v){
        int id = v.getId();
        if (id == R.id.btnNormalOyun) {
            aktiviteyeGec("Normal Oyun");
            // Normal Oyun butonuna tıklandığında yapılacak işlemler


        } else if (id == R.id.btnSureliOyun) {
            aktiviteyeGec("Süreli Oyun");
            // Süreli Oyun butonuna tıklandığında yapılacak işlemler


        } else if (id == R.id.btnCikis) {
            cikisYap();
            // Çıkış butonuna tıklandığında yapılacak işlemler
        }
    }

    private void aktiviteyeGec(String aktiviteIsmi){
        if(aktiviteIsmi.equals("Normal Oyun"))
            intent = new Intent(this,NormalOyunActivity.class);
        else
            intent = new Intent(this,SureliOyunActivity.class);

        startActivity(intent);
    }

    private void cikisYap(){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid()); // Bu kod sayesinde  cikis işlemi yapıyor uygulama */
        System.exit(0);
    }


    public void onBackPressed() {
        super.onBackPressed();
        cikisYap();
    }
}
