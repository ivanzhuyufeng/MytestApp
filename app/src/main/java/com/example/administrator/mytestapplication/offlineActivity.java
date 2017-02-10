package com.example.administrator.mytestapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class offlineActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
        Button forceOffline = (Button)findViewById(R.id.btnoff);
        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.administrator.mytestapplication.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
