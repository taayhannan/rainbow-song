package com.example.mtaayhannan.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button cameraButton;
ImageView imageView;
static final int CAMERA_PIC_REQUEST=1024;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraButton=(Button) findViewById(R.id.button);
        imageView=(ImageView) findViewById(R.id.imageView);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //declaring intent to move from one activity to other
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //start intent
                startActivityForResult(intent,CAMERA_PIC_REQUEST);



            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_PIC_REQUEST && resultCode==RESULT_OK)
        {
            Bitmap image=(Bitmap)data.getExtras().get("data");
imageView.setImageBitmap(image);
        }

    }
}
