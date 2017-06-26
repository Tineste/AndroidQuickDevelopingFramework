package frame.xuchao.orz.frame.base.base;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.zhy.autolayout.AutoLayoutActivity;

import frame.xuchao.orz.frame.base.net.NetBroadcastReceiver;
import frame.xuchao.orz.frame.base.net.NetUtil;
import frame.xuchao.orz.frame.base.util.LogUtil;
import frame.xuchao.orz.frame.base.util.ToastUtil;
import frame.xuchao.orz.frame.base.util.activitymanage.ActivityControl;

import static android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;

/**
 * Created by Administrator on 2017/4/21 0021.
 */

public abstract class BaseActivity extends AutoLayoutActivity implements NetBroadcastReceiver.NetEvevt {
    public static NetBroadcastReceiver.NetEvevt evevt;
    /**
     * 网络类型
     */
    private int netMobile;

    @Override
    protected void onCreate(Bundle arg0) {


        super.onCreate(arg0);
        setView();
        setDate();
        setControl();
        evevt = this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(FLAG_TRANSLUCENT_STATUS);
        }
 //    网络的检测相关
        evevt = this;
        if( !inspectNet()){
            ToastUtil.showLongToast(this,"当前无网络，请检查网络连接");
        }

        //    Activity栈管理相关
        ActivityControl.getAppManager().addActivity(this);


        int n= ActivityControl.getAppManager().activityStack.size();
        LogUtil.logV("BaseActivity","---入栈后栈内个数--"+n+"-----");

    }


    //    初始界面
    protected abstract void setView();
    //    初始数据
    protected abstract void setDate();
    //    设置控制器
    protected abstract void setControl();

    /**
     * 初始化时判断有没有网络
     */

    public boolean inspectNet() {
        this.netMobile = NetUtil.getNetWorkState(BaseActivity.this);
        return isNetConnect();
    }

    /**
     * 网络变化之后的类型
     */
    @Override
    public void onNetChange(int netMobile) {
        // TODO Auto-generated method stub
        this.netMobile = netMobile;
        isNetConnect();

    }

    /**
     * 判断有无网络 。
     *
     * @return true 有网, false 没有网络.
     */
    public boolean isNetConnect() {
        if (netMobile == 1) {
            Log.v("aa","inspectNet：连接wifi");
            return true;
        } else if (netMobile == 0) {
            Log.v("aa","inspectNet:连接移动数据");
            return true;
        } else if (netMobile == -1) {
            Log.v("aa","inspectNet:当前没有网络");
            return false;
        }
        return false;
    }
    @Override
    protected void onDestroy() {
        ActivityControl.getAppManager().RemoveActivity(this);
        int n= ActivityControl.getAppManager().activityStack.size();
        LogUtil.logV("BaseActivity","=======出栈后栈内个数--"+n+"=======");
        super.onDestroy();
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}