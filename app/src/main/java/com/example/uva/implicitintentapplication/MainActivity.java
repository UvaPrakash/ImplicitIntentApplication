package com.example.uva.implicitintentapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void performAction(View view) {
        Intent intent = null, chooser = null;

        switch (view.getId()) {

            case R.id.bShowWebsite:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.google.com"));
                chooser = Intent.createChooser(intent, "Open Website Using...");
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                break;
            case R.id.bShowMap:
                break;
            case R.id.bSendEmail:
                break;
            case R.id.bSendImage:
                break;
            case R.id.bShareMessage:
                break;
            case R.id.bCallNumber:
                break;
        }
    }
}
