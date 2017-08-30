package com.example.minhaj.multitouch;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private final String TAG = "tag";
    ImageView imageView;
    private TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int pCount = motionEvent.getPointerCount();
                handleTouch(motionEvent);
                /*int pIndex = motionEvent.getActionIndex();
                int pId = motionEvent.getPointerId(pIndex);
                Log.d(TAG, "p count " + pCount);
                Log.d(TAG, "p action index " + pIndex);
                Log.d(TAG, "p id " + pId);
                int x = (int) motionEvent.getX(pIndex);
                int y = (int) motionEvent.getY();

                if (pCount > 1) {
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                        case MotionEvent.ACTION_POINTER_DOWN:
                            Log.d(TAG, "pointer down");
                            scaleImg((int)motionEvent.getX(pIndex),(int)motionEvent.getY(pIndex));
                            break;
                    }

                }*/
                return true;
            }
        });
    }

    private void handleTouch(MotionEvent motionEvent) {
        int pCount = motionEvent.getPointerCount();
        for (int i=0; i<pCount;i++){
            int x = (int) motionEvent.getX(i);
            int y = (int) motionEvent.getY(i);
            int action = motionEvent.getActionMasked();
            String ac;
            switch (action){
                case MotionEvent.ACTION_DOWN:
                    ac = "down";
                    break;

            }
            if (i==0)
                tv1.setText("x ="+x+" y ="+y);
            else
                tv2.setText("x ="+x+" y="+y);
        }
    }

    private void scaleImg(int x, int y) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout .LayoutParams(x,y);
        imageView.setLayoutParams(layoutParams);
    }
}
