package frame.xuchao.orz.frame.Demo.presenter;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import frame.xuchao.orz.frame.Demo.viewmodle.GetHomePictureViewMode;
import frame.xuchao.orz.frame.base.base.BasePresenter;
import frame.xuchao.orz.frame.base.base.MyBaseBean;
import frame.xuchao.orz.frame.base.net.HttpProxy;
import frame.xuchao.orz.frame.base.net.NetWorkCallBack;
import frame.xuchao.orz.frame.base.net.urlmanager.InterfaceUrl;
import frame.xuchao.orz.frame.base.net.urlmanager.ServerManager;
import frame.xuchao.orz.frame.base.util.LogUtil;
import frame.xuchao.orz.frame.bean.MainBtnBean;

/**
 * Created by Administrator on 2017/4/26 0026.
 */

public class GetHomePicturePresenter extends BasePresenter<GetHomePictureViewMode> implements NetWorkCallBack {
    public void loadDate() {
        HttpProxy httpProxy=new HttpProxy.Builder().setDefaultSet().builder();
        httpProxy.makePost(ServerManager.getUrl(InterfaceUrl.TEST),null,this);
    }

    @Override
    public void success(String s) {
        if(null!=mBaseViewMode){
            try {
                JSONObject jsonObject=new JSONObject(s);
                LogUtil.logV(TAG,s);
                Gson gson=new Gson();
                JSONArray jsonArray=jsonObject.getJSONArray("data");
                Type jsonType2 = new TypeToken<MainBtnBean>() {
                }.getType();
                MainBtnBean mMainBtnBean=gson.fromJson(jsonArray.getJSONObject(0).toString(),jsonType2);
                LogUtil.logV("aaa",mMainBtnBean.getTitle());

                Type jsonType = new TypeToken<MyBaseBean<ArrayList<MainBtnBean>>>() {
                }.getType();
                MyBaseBean<ArrayList<MainBtnBean>> mMyBaseBean=gson.fromJson(s, jsonType);

                mBaseViewMode.getHomePictureSuccess(jsonObject.getInt("status"),jsonObject.getString("msg"),mMyBaseBean.getData());
            } catch (Exception e) {
                e.printStackTrace();
            }
            mBaseViewMode.onHideLoding(TAG);
        }

    }

    @Override
    public void failed() {
        if(null!=mBaseViewMode)
            mBaseViewMode.onHideLoding(TAG);
    }
}
