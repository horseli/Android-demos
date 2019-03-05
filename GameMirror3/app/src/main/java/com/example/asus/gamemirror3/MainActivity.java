package com.example.asus.gamemirror3;


import android.app.ProgressDialog;
import android.arch.core.util.Function;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG=MainActivity.class.getSimpleName();
    private SurfaceHolder holder;
    private SurfaceView surfaceView;
    //private PictureView pictureView;
    //private FunctionView functionView;
    private SeekBar seekBar;
    private ImageView add,minus;
    private LinearLayout bottom;
    private  ImageView save;
    private ProgressDialog dialog;
    //private  DrawView drawView;
    private  boolean haveCamera;
    private int mCurrentCamIndex;
    private int ROTATE;
    private int minFocus;
    private int maxFocus;
    private int everyFocus;
    private int nowFocus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
    surfaceView=(SurfaceView)findViewById(R.id.surface);
}
    private boolean checkCameraHardware(){
        if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;
        }else{return false;}
    }
    private String openFrontFacing(){
        CameraManager manager=(CameraManager)this.getSystemService(Context.CAMERA_SERVICE);
    }



}


