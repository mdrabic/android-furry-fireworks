package com.mdrabic.ctcrunch;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mdrabic.furryfireworks.MaterialDrawable;


public class MainActivity extends Activity {

    private Button transform;
    private ImageView ctCrunchImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transform = (Button) findViewById(R.id.transform);
        ctCrunchImg = (ImageView) findViewById(R.id.ctcrunch_img);

        transform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.guy);
                ctCrunchImg.setImageDrawable(new MaterialDrawable(getResources(), b));
            }
        });
    }
}
