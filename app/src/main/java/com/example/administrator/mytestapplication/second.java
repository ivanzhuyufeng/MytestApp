package com.example.administrator.mytestapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class second extends AppCompatActivity implements View.OnClickListener {
    private  Button btnNotify;
    private  Button btnMessage;
    private  Button btnCamera;
    private  Button btnMp3;
    private  Button btnVedio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnNotify = (Button) findViewById(R.id.btnNotify);
        btnMessage = (Button) findViewById(R.id.btnMessage);
        btnCamera = (Button) findViewById(R.id.btnCamera);
        btnMp3 = (Button) findViewById(R.id.btnMp3);
        btnVedio = (Button)findViewById(R.id.btnVedio);

        btnNotify.setOnClickListener(this);
        btnMessage.setOnClickListener(this);
        btnCamera.setOnClickListener(this);
        btnMp3.setOnClickListener(this);
        btnVedio.setOnClickListener(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNotify:
                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                Notification.Builder localBuilder = new Notification.Builder(this);
                localBuilder.setAutoCancel(false);
                localBuilder.setSmallIcon(R.mipmap.ic_launcher);
                localBuilder.setContentTitle("您有一条新消息");
                localBuilder.setContentText("卡上余额不足，请及时充值");
                Notification notification = localBuilder.build();
                manager.notify(0, notification);




                break;
            case R.id.btnMessage:
                break;
            case R.id.btnCamera:
                Intent intent = new Intent(second.this, CameraActivity.class);
                startActivity(intent);
                break;
            case R.id.btnVedio:
                break;
            case R.id.btnMp3:
                break;
            default:
                break;
        }
    }
}
