package frame.xuchao.orz.frame.base.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import frame.xuchao.orz.frame.base.base.BaseActivity;


/**
 * Created by Administrator on 2017/4/21 0021.
 */

public class NetBroadcastReceiver extends BroadcastReceiver {

    public NetEvevt evevt = BaseActivity.evevt;


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        // 如果相等的话就说明网络状态发生了变化
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            int netWorkState = NetUtil.getNetWorkState(context);
            if(null!=evevt){
                // 接口回调传过去状态的类型
                evevt.onNetChange(netWorkState);
            }

        }
    }

    // 自定义接口
    public interface NetEvevt {
        void onNetChange(int netMobile);
    }
}