package frame.xuchao.orz.frame.base.manager;

import android.content.Context;

import frame.xuchao.orz.frame.bean.User;

/**
 * Created by Administrator on 2017/4/25 0025.
 * 统一管理用户信息
 */

public class UserManager {
    private static User mUser=null;
    private UserManager(){

    }
    public static User getUser(Context context) {
        if(null==mUser)
            mUser= new User();
        return mUser;
    }

    public static void saveUser(User User, Context context) {
        mUser=User;
    }


    public static void clearUser( Context context){
        mUser=null;

    }

}
