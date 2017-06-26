package frame.xuchao.orz.frame.base.util.activitymanage;

/**
 * Created by Administrator on 2017/4/21 0021.
 */


import android.app.Activity;

import java.util.Stack;

public class ActivityControl {
    public static Stack<Activity> activityStack;
    private static ActivityControl instance;

    private ActivityControl() {
    }

    public static ActivityControl getAppManager() {
        if(instance == null) {
            instance = new ActivityControl();
        }
        return instance;
    }
//    加入activity
    public void addActivity(Activity activity) {
        if(activityStack == null) {
            activityStack = new Stack();
        }
        activityStack.add(activity);
    }
    //    删除并且移除activity
    public void RemoveActivity(Activity activity) {
        if(null!=activity)
            activity.finish();
        if(activityStack.contains(activity))
            activityStack.remove(activity);

    }
//    删除所有activity
    public void finishAllActivity() {
        int i = 0;
        for(int size = activityStack.size(); i < size; ++i) {
            if(null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

}