package com.batu.isimsehiroyunu;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class NormalOyunActivity extends AppCompatActivity {

    private TextView txtilBilgi,txtİl, txtToplamPuan;
    private EditText editTxtTahmin;
    private String [] iller = { "Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Aksaray", "Amasya",
                                "Ankara", "Antalya", "Ardahan", "Artvin", "Aydın", "Balıkesir",
                                " Bartın","Batman", "Bayburt", "Bilecik", "Bingöl", "Bitlis",
                                "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum",
                                "Denizli", "Diyarbakır", "Düzce", "Edirne", "Elazığ", "Erzincan",
                                "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane",
                                "Hakkâri", "Hatay", "Iğdır", "Isparta", "İstanbul", "İzmir",
                                "Kahramanmaraş", "Karabük", "Karaman", "Kars", "Kastamonu",
                                "Kayseri", "Kilis", "Kırıkkale", "Kırklareli", "Kırşehir",
                                "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Mardin",
                                "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Osmaniye",
                                "Rize", "Sakarya", "Samsun", "Şanlıurfa", "Siirt", "Sinop", "Sivas",
                                "Şırnak", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Uşak", "Van", "Yalova", "Yozgat",
                                "Zonguldak"};




    private Random rndlIl,rndHarf;
    private int rndIlNumara,rndNumaraHarf,baslangicHarfSayisi;
    private String gelenIl , ilBoyutu , editTxtGelenTahmin;

   private ArrayList<Character> ilHarfleri;
   private  float maximumPuan = 100.0f, azaltilicakPuan,toplamPuan =0,bolumToplamPuan=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_oyun);


        txtilBilgi = findViewById(R.id.txtViewilBilgiS);
        txtİl = findViewById(R.id.txtViewIlS);
        editTxtTahmin = findViewById(R.id.editTxtTahminS);
        txtToplamPuan = findViewById(R.id.txtViewToplamPuanS);



        /*           Rastgele İl Gelmesi İçin Değişkenleri RndIl RndNumara Gibi Oluşturdum Ve Tanımladım         */
        rndHarf = new Random();
        randomDegerleriBelirle();

    }
    public void btnTahminEtN(View v)
    {
        editTxtGelenTahmin = editTxtTahmin.getText().toString();

        if(!TextUtils.isEmpty(editTxtGelenTahmin)) {
            if (editTxtGelenTahmin.equals(gelenIl)) {
                bolumToplamPuan += toplamPuan;
                Toast.makeText(getApplicationContext(),"Tebrikler Doğru Tahminde Bulundunuz.",Toast.LENGTH_LONG).show();
                txtToplamPuan.setText("Toplam Bölüm Puanı : " + bolumToplamPuan);
                editTxtTahmin.setText("");
                randomDegerleriBelirle();

            }
            else
                System.out.println("Yanlış Tahminde Bulundunuz.");
        }
        else
            System.out.println("Tahmin Değeri Boş Olamaz ! ");

    }


    public  void btnHarfAlN(View v)
    {
        /*     Aldığımız Harfleri Tek Tek Parçalamak İçin Yazdığım kodlar Mesela
        *       5 HARFLİ İLİ SORDU A HARFİNİ ALDIK SADECE A GELMESİ İÇİN YAPTIĞIM YER */

           if(ilHarfleri.size() > 0){
             randomHarfAl();
               toplamPuan -= azaltilicakPuan;
               Toast.makeText(getApplicationContext(),"Kalan Puan =  " +toplamPuan,Toast.LENGTH_SHORT).show();
       }else
               System.out.println("Harf Kalmadı.");
    }

    private void randomDegerleriBelirle(){
        ilBoyutu ="";

        rndlIl = new Random();
        rndIlNumara = rndlIl.nextInt(iller.length);
        gelenIl = iller[rndIlNumara];
        System.out.println(rndIlNumara+ " = " +gelenIl);
        txtilBilgi.setText(gelenIl.length() + "Harfli İlimiz");

            if(gelenIl.length() >= 5 && gelenIl.length() <=7)
                baslangicHarfSayisi =1;
            else if(gelenIl.length()>= 8 && gelenIl.length()< 10)
                baslangicHarfSayisi =2;
            else if (gelenIl.length() >=10)
                baslangicHarfSayisi =3;
            else
                baslangicHarfSayisi =0;
        System.out.println("İl Harf sayısı = " + gelenIl.length() + "Başlangıc Harf Sayısı = " +baslangicHarfSayisi); /* test amaçlı yazdırdım */

        for(int i = 0; i < gelenIl.length(); i++){
            if( i< gelenIl.length() -1)
                ilBoyutu += "_ ";
            else
                ilBoyutu += "_";
        }

        txtİl.setText(ilBoyutu);

        ilHarfleri = new ArrayList<>();


        /*     TO CHAR ARRAY İLE Harfleri Parçalarına ayırıyorum     */
        for(char c : gelenIl.toCharArray()) {
            ilHarfleri.add(c);
        }
            for( int c=0; c <baslangicHarfSayisi; c++)
            {
                System.out.println("");
            }

                randomHarfAl();

            azaltilicakPuan = maximumPuan /ilHarfleri.size();
            toplamPuan = maximumPuan;

    }

    private void randomHarfAl(){
        rndNumaraHarf = rndHarf.nextInt(ilHarfleri.size());
        String [] txtHarfler = txtİl.getText().toString().split(" ");
        char [] gelenIlHarfler = gelenIl.toCharArray();

        for(int i = 0; i < gelenIl.length(); i++){
            /*  Mesela Adana'nın 3 A sı olduğu için hangi a yı atayacağını yaptırdığım işlem  */
            if( txtHarfler[i].equals("_") && gelenIlHarfler[i] == ilHarfleri.get(rndNumaraHarf)) {
                txtHarfler [i] = String.valueOf(ilHarfleri.get(rndNumaraHarf)) ;
                ilBoyutu = "";

                for ( int j = 0; j<gelenIl.length(); j++){
                    if(j == i)
                        ilBoyutu += txtHarfler [j] + " ";
                    else if (j < gelenIl.length() -1)
                        ilBoyutu += txtHarfler [j] + " ";
                    else
                        ilBoyutu += txtHarfler [j];
                }
                break;
            }
        }


        txtİl.setText(ilBoyutu);

        ilHarfleri.remove(rndNumaraHarf);
    }

}
