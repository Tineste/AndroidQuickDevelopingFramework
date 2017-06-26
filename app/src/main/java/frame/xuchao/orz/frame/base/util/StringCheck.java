package frame.xuchao.orz.frame.base.util;


import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/4/27 0027.
 */

public class StringCheck {

    /**
     * 手机号验证
     * @param phone_num
     * @return
     */
    public static boolean isPhone(String phone_num){
        if (TextUtils.isEmpty(phone_num)){
            return false;
        }
        Pattern p = Pattern.compile("^(1(([3456789][0-9])|(47)|[8][0126789]))\\d{8}$");
        Matcher m = p.matcher(phone_num);
        return m.find();


    }

    /**
     *    验证码验证
     * @param yzm
     * @return
     */
    public static boolean isyzm(String yzm){
        Pattern p = Pattern.compile("^\\d{6}$");
//		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(yzm);
        return m.find();
    }

    /**
     * 密码验证
     * @param pwd
     * @return
     */
    public static boolean ispwd(String pwd){
        if (pwd.length()>20){
            return false;
        }
        Pattern pat = Pattern.compile("[\\da-zA-Z]{6,20}");
        Matcher m = pat.matcher(pwd);
        return m.find();
    }

    public static boolean isEmpty(CharSequence s) {
        return TextUtils.isEmpty(s);
    }


}
