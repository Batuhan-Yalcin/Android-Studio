
Hello Activity Kodları





package com.batu.uygulama3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class HelloActivity extends AppCompatActivity {

    private TextView kullanicix;
    private String gelenKadi;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kullanicix = findViewById(R.id.kullaniciAdiEditText);

        // Intent intent = new Intent(this, KayitActivity.class);
        // MainActivity(intent);


        /*
         String kullaniciAdi = kullaniciAdiEditText.getText().toString();
        String sifre = sifreEditText.getText().toString();
        String sifreTekrar = sifreTekrarEditText.getText().toString();

        if (kullaniciAdi.equals(dogruKullaniciAdi) && sifre.equals(dogruSifre) && sifre.equals(sifreTekrar)) {
            sonucTextView.setText("Kayıt Başarılı");
        } else {
            sonucTextView.setText("Kayıt Başarısız. Lütfen bilgilerinizi kontrol edin.");
         */

        Intent gelenintent = getIntent();
        gelenKadi = gelenintent.getStringExtra("Kullanici");
        kullanicix.setText("Hoşgeldiniz" + gelenKadi);
    }




}
