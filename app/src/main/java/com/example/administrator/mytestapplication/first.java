package com.example.administrator.mytestapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class first extends AppCompatActivity {

    String Uriz;
    EditText edtUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button btnfirst = (Button)findViewById(R.id.btnfirst);
        edtUri = (EditText)findViewById(R.id.edtUri);

        btnfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uriz = edtUri.getText().toString();
                Log.i("this ", Uriz);
                intent.setData(Uri.parse(Uriz));
                startActivity(intent);
            }
        });
    }
}
