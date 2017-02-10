package com.example.administrator.mytestapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CameraActivity extends AppCompatActivity {

    public static final int TAKE_PHOTO = 0;
    public static final int CROP_PHOTO = 1;
    private Button btnTakePhoto;
    private Button btnChosePic;
    private ImageView ImgPicture;
    private Uri ImgUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btnTakePhoto = (Button)findViewById(R.id.btnTakePhoto);
        btnChosePic = (Button)findViewById(R.id.btnChosePic);
        ImgPicture = (ImageView)findViewById(R.id.Img_Picture);
        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File OutImage = new File(Environment.getExternalStorageDirectory(), "tempImg.jpg");
                try {
                    if(OutImage.exists()){
                        OutImage.delete();
                    }
                    OutImage.createNewFile();

                }catch (IOException e){
                    e.printStackTrace();
                }
                ImgUri = Uri.fromFile(OutImage);
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,ImgUri);
                startActivityForResult(intent,TAKE_PHOTO);
            }
        });

        btnChosePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File  OutputImg = new File(Environment.getExternalStorageDirectory(),"output_img.jpn");
                try {
                    if (OutputImg.exists()){
                        OutputImg.delete();
                    }
                    OutputImg.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
                ImgUri = Uri.fromFile(OutputImg);
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
                intent.putExtra("crop",true);
                intent.putExtra("scale",true);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,ImgUri);
                startActivityForResult(intent, CROP_PHOTO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       switch (requestCode){
           case TAKE_PHOTO:
               if(resultCode == RESULT_OK){
                   Intent intent = new Intent("com.android.camera.action.CROP");
                   intent.setDataAndType(ImgUri,"image/*");
                   intent.putExtra("scale",true);
                   intent.putExtra(MediaStore.EXTRA_OUTPUT,ImgUri);
                   startActivityForResult(intent,CROP_PHOTO);
               }
               break;
           case CROP_PHOTO:
               if (resultCode == RESULT_OK){
                   try {
                       Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(ImgUri));
                       ImgPicture.setImageBitmap(bitmap);
                   }catch (FileNotFoundException e){
                       e.printStackTrace();
                   }
               }
               break;
           default:
               break;
       }
    }
}
