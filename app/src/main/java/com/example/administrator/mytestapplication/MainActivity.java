package com.example.administrator.mytestapplication;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Button btntest = (Button)findViewById(R.id.btntest);
        Button btnlistview = (Button)findViewById(R.id.btnlistview);
        Button btnMsg = (Button)findViewById(R.id.btnmsg);
        Button btnbroadcast = (Button) findViewById(R.id.btnbroadcast);
        Button btnoffline = (Button)findViewById(R.id.btnoffline);
        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //用于测试网页部分
             /*   Intent intent = new Intent(MainActivity.this,first.class);
                startActivity(intent);
             */

            //测试activity返回传递数据
                Intent intent = new Intent(MainActivity.this, second.class);
                startActivity(intent);

            }
        });

        btnlistview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListView_test.class);
                startActivity(intent);
            }
        });

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MsgActivity.class);
                startActivity(intent);
            }
        });

        btnbroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BroadcastActivity.class);
                startActivity(intent);
            }
        });

        btnoffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, offlineActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "you clicked add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "you clicked remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(requestCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("MainAcitivity", returnedData);
                }
                break;
            default:
        }
    }
}
