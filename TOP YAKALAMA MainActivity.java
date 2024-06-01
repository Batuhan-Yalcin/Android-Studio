package com.batu.topyakalama;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView skorMetni;
    private ImageView topResmi;
    private int skor = 0;
    private Handler isleyici = new Handler();
    private Runnable geriSayim;
    private Random rastgele = new Random();
    private RelativeLayout anaLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skorMetni = findViewById(R.id.skorMetni);
        topResmi = findViewById(R.id.topResmi);
        anaLayout = findViewById(R.id.anaLayout);

        Log.d("AnaEkran", "Oyun başlatıldı");

        oyunuBaslat();
    }
// Oyunu başlattığım metot Bu metot topun rastgele bir konuma hareket etmesini sağlar
    private void oyunuBaslat() {
        geriSayim = new Runnable() {
            @Override
            public void run() {
                int x = rastgele.nextInt(anaLayout.getWidth() - topResmi.getWidth());
                int y = rastgele.nextInt(anaLayout.getHeight() - topResmi.getHeight());
                Log.d("AnaEkran", "X: " + x + ", Y: " + y);
                topResmi.setX(x);
                topResmi.setY(y);

                //  her 1000 milisaniyede bir topun yeni konumu belirlenir
                isleyici.postDelayed(this, 1000);
            }
        };
        isleyici.post(geriSayim);
    }

    //  Topa tıklandığında çağırdığım metottur
    //  Her tıklamada, oyuncunun skoru bir arttırdım ve skormetninde güncelledim
    public void topaTiklandi(View view) {
        skor++;
        skorMetni.setText("Skor: " + skor);
    }
}
