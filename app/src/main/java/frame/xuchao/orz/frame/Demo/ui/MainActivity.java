package frame.xuchao.orz.frame.Demo.ui;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import frame.xuchao.orz.frame.Demo.presenter.GetHomePicturePresenter;
import frame.xuchao.orz.frame.Demo.viewmodle.GetHomePictureViewMode;
import frame.xuchao.orz.frame.R;
import frame.xuchao.orz.frame.base.base.BaseActivity;
import frame.xuchao.orz.frame.base.util.FileUtil;
import frame.xuchao.orz.frame.base.util.ToastUtil;
import frame.xuchao.orz.frame.bean.MainBtnBean;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;


//程序第一个页面先来个读写权限的申请，让日志记录能正常运行

@RuntimePermissions
public class MainActivity extends BaseActivity implements GetHomePictureViewMode {

    private TextView testTV;
    private Button getB;
    GetHomePicturePresenter mGetHomePicturePresenter=new GetHomePicturePresenter();

    MainBtnBean mainBtnBean;
    private Button getB2;
    private Button getB3;

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    public void getWritePermissions(){

    }
    @OnPermissionDenied(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void showDeniedForStorage() {
        Toast.makeText(this, "WRITE_EXTERNAL_STORAGE_denied", Toast.LENGTH_SHORT).show();
        finish();
    }


    @Override
    protected void setView() {
        setContentView(R.layout.activity_main);
        testTV=(TextView)findViewById(R.id.testTV);
        getB=(Button)findViewById(R.id.getB);
        getB2=(Button)findViewById(R.id.getB2);
        getB3=(Button)findViewById(R.id.getB3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

// App Logo
        toolbar.setLogo(R.mipmap.ic_launcher);
// Title
        toolbar.setTitle("My Title");
// Sub Title
        toolbar.setSubtitle("Sub title");

        setSupportActionBar(toolbar);

// Navigation Icon 要設定在 setSupoortActionBar 才有作用
// 否則會出現 back button
        toolbar.setNavigationIcon(R.drawable.ab_android);

    }

    @Override
    protected void setDate() {

        mGetHomePicturePresenter.attach(this);
        MainActivityPermissionsDispatcher.getWritePermissionsWithCheck(MainActivity.this);
    }

    @Override
    protected void setControl() {


        getB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetHomePicturePresenter.loadDate();
//测试异常的奔溃日志的
//                mainBtnBean.getId();

            }
        });
        getB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });


        getB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (ContextCompat.checkSelfPermission(MainActivity.this,
//                        Manifest.permission.CAMERA)
//                        != PackageManager.PERMISSION_GRANTED) {
//
//                    // Should we show an explanation?
//                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
//                            Manifest.permission.READ_CONTACTS)) {
//
//                        // Show an expanation to the user *asynchronously* -- don't block
//                        // this thread waiting for the user's response! After the user
//                        // sees the explanation, try again to request the permission.
//                        ToastUtil.showLongToast(MainActivity.this,"aaaaaaaaaaaaa");
//                    } else {
//
//                        // No explanation needed, we can request the permission.
//
//                        ActivityCompat.requestPermissions(MainActivity.this,
//                                new String[]{Manifest.permission.CAMERA},
//                                0);
//                        // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
//                        // app-defined int constant. The callback method gets the
//                        // result of the request.
//                    }
//
//
//                }else{
//                    //启动相机程序
//                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//                    startActivityForResult(intent, 0);
//                }

                MainActivityPermissionsDispatcher.showCameraWithCheck(MainActivity.this);


            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // NOTE: delegate the permission handling to generated method
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    public  void showCamera(){
        //启动相机程序
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, 0);
    }

    @OnShowRationale(Manifest.permission.CAMERA)
    void showRationaleForCamera(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage("permission_camera_rationale")
                .setPositiveButton("R.string.button_allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton("R.string.button_deny", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.cancel();
                    }
                }  )
                .show();
    }

    @OnPermissionDenied(Manifest.permission.CAMERA)
    void showDeniedForCamera() {
        Toast.makeText(this, "R.string.permission_camera_denied", Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)
    void showNeverAskForCamera() {
        Toast.makeText(this," R.string.permission_camera_neverask", Toast.LENGTH_SHORT).show();
    }




//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case 0: {
//                // If request is cancelled, the result arrays are empty.
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                    //启动相机程序
//                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//                    startActivityForResult(intent, 0);
//
//                } else {
//
//                    ToastUtil.showLongToast(this,"权限未能得到授权");
//                    // permission denied, boo! Disable the
//                    // functionality that depends on this permission.
//                }
//                return;
//            }
//        }
//    }

    @Override
    public void getHomePictureSuccess(int status, String msg, ArrayList<MainBtnBean> mMainBtnBeans) {

        ToastUtil.showLongToast(this,mMainBtnBeans.get(0).getTitle());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mGetHomePicturePresenter.detach();
    }

    @Override
    public void onShowLoding(String TAG) {

    }

    @Override
    public void onHideLoding(String TAG) {

    }

}
