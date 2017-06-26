package frame.xuchao.orz.frame.base.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/4/25 0025.
 */

public class ToastUtil {
    private static Toast mToast;
    private static Handler mhandler = new Handler();
    private static Runnable r = new Runnable() {
        public void run() {
            mToast.cancel();
        };
    };


    public static void showLongToast(Context context, String text){
        showToast(context,text,Toast.LENGTH_LONG);
    }

    public static void showShortToast(Context context, String text){
        showToast(context,text,Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, String text, int duration) {
        mhandler.removeCallbacks(r);
        if (null != mToast) {
            mToast.setText(text);
        } else {
            mToast = Toast.makeText(context, text, duration);
        }
        mhandler.postDelayed(r, 5000);
        mToast.show();
    }

}