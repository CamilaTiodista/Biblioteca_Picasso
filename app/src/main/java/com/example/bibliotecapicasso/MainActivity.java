package com.example.bibliotecapicasso;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.time.Instant;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "https://i.pinimg.com/originals/25/d6/7e/25d67e1ab8761a9fce706554245b2bdb.png";
    private ProgressBar progress;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView = (ImageView) findViewById(R.id.img);
        progress = (ProgressBar) findViewById(R.id.progress);
        progress.setVisibility(View.VISIBLE);

        //faz o download
        downloadImagem();
    }

    //Faz o download da imagem em uma nova thread
    private void downloadImagem(){

        Picasso.get().load(URL).placeholder(R.mipmap.aguardando).error(R.mipmap.erro).into(imgView, new Callback() {
            @Override
            public void onSuccess() {
                progress.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                progress.setVisibility(View.GONE);
            }
        });

    }
}