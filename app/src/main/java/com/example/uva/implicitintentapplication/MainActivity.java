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
                    startActivity(chooser);
                break;
            case R.id.bShowMap:
                intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://maps.google.com/maps?q=" + latitude + "," + longitude + "(Label Point)"));
                intent.setData(Uri.parse("http://maps.google.com/maps?q=38.8977,-77.0365" + "(Label Point)"));
                chooser = Intent.createChooser(intent, "Open Map Using...");
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(chooser);
                break;
            case R.id.bSendEmail:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("message/rfc822");
                String[] send_to = {"uvaprakash@outlook.com", "uvaprakashp@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, send_to);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Sample Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "Sample Message");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource//com.example.uva.implicitintentapplication/drawable/" + R.drawable.ic_launcher));
                chooser = Intent.createChooser(intent, "Select email...");
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(chooser);
                break;
            case R.id.bSendImage:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                Uri uri_image = Uri.parse("android.resource//com.example.uva.implicitintentapplication/drawable/" + R.drawable.ic_launcher);
                intent.putExtra(Intent.EXTRA_STREAM, uri_image);
                intent.putExtra(Intent.EXTRA_TEXT, "Check the attached image");
                chooser = Intent.createChooser(intent, "Share Image Via...");
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(chooser);
                break;
            case R.id.bShareMessage:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Sample Text Message");
                chooser = Intent.createChooser(intent, "Share Message Via...");
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(chooser);
                break;
            case R.id.bCallNumber:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919952974163"));
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                break;
        }
    }
}
