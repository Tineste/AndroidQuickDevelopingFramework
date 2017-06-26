package frame.xuchao.orz.frame.base.util;

import android.util.Log;

import frame.xuchao.orz.frame.base.configure.Configure;

/**
 * Created by Administrator on 2017/4/24 0024.
 */

public class LogUtil {
    /**
     * 普通的日志打印
     * @param TAG
     * @param message
     */
    public static void logV(String TAG, String message){
        if(Configure.isOpenLog)
            Log.v(TAG,message);
    }






}
