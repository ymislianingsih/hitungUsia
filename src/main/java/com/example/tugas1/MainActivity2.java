package com.example.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    String nama, tglLahir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nama = getIntent().getStringExtra("EXTRA_NAMA");
        tglLahir = getIntent().getStringExtra("EXTRA_TANGGAL");

        TextView tvName = findViewById(R.id.hasilNama);
        TextView tvTglLahir = findViewById(R.id.tanggalLahir);
        TextView tvTahun = findViewById(R.id.hasilTahun);
        TextView tvBulan = findViewById(R.id.hasilBulan);
        TextView tvHari = findViewById(R.id.hasilHari);

        tvName.setText(nama);
        tvTglLahir.setText(tglLahir);

        String birthDate = tglLahir;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        try {
            Date tglLahir = sdf.parse(birthDate);
            Date currentDate = new Date();

            long diff = currentDate.getTime() - tglLahir.getTime();
            long umur = diff;

            int Tahun = (int) (umur / (1000 * 60 * 60 * 24 * 365.25));
            int Bulan = (int) ((umur % (1000 * 60 * 60 * 24 * 365.25)) / (1000 * 60 * 60 * 24 * 30.44));
            int Hari = (int) ((umur % (1000 * 60 * 60 * 24 * 365.25)) / (1000 * 60 * 60 * 24));

            tvTahun.setText(Tahun + " Tahun");
            tvBulan.setText(Bulan + " Bulan");
            tvHari.setText(Hari + " Hari");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}