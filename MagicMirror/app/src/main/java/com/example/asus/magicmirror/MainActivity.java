package com.example.asus.magicmirror;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private boolean haveCamera;
    private int mCurrentCamIndex;
    private int ROTATE;
    private int minFocus;
    private int maxFocus;
    private int everyFocus;
    private int nowFocus;

    private Camera camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
private void initViews(){

}
private boolean checkCameraHadware(){
        if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            return true;
        }else{
            return false;
        }
}


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public int getOrientation(final int cameraId) {
        try {
            CameraManager manager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
            String[] cameraIds = manager.getCameraIdList();
            CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraIds[cameraId]);
            return characteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
        } catch (CameraAccessException e) {
            // TODO handle error properly or pass it on
            return 0;
        }
    }

/*private Camera openFontFacingCamera(){
    int cameraCount;
    Camera mCamera=null;
    Camera.CameraInfo cameraInfo=new Camera.CameraInfo();
    cameraCount=Camera.getNumberOfCameras();


}*/
}






