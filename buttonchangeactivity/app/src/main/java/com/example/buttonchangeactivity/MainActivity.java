package com.example.buttonchangeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

    Button btnIm, btnExp;
    EditText edURL;
    private int REQUEST_IMAGE_CAPTURE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        btnIm = (Button) findViewById(R.id.buttonImIntent);
        btnExp = (Button) findViewById(R.id.buttonExIn);
        edURL = (EditText) findViewById(R.id.edURL);

        btnIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Implicit Button Pressed with URL : " + edURL.getText().toString(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/search?q=mayank+vachhani&sxsrf=ALeKk02EsWme-IkzTHFDCLg9Lq0DXwulKg:16002494522" +
                        "44&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjym5zhse3rAhU_wzgGHYJXBfkQ_AUoAnoECAsQBA&biw=1536&bih=754#imgrc=eIzWtvFqihjUSM"));
                startActivity(intent);
            }
        });


        btnExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Explicit Button Pressed", Toast.LENGTH_LONG).show();
                Uri u = Uri.parse("tel:9687315300");
                Intent i = new Intent(Intent.ACTION_DIAL, u);
                startActivity(i);
            }
        });
    }
}