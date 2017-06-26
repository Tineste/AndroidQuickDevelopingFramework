package frame.xuchao.orz.frame.base.net;


import android.os.AsyncTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/4/21 0021.
 */

public class OkhttpNetWork extends AsyncTask<Integer, Integer, String> implements HttpProxyInterface{

    OkHttpClient client = new OkHttpClient();

    private NetWorkCallBack mNetWorkInterface;
    private HashMap map;
    private String url;


    private byte state=0;//0是post，1是get

    @Override
    public void setHttpSet(HttpProxy.Builder builder) {
        OkHttpClient.Builder builder1= new OkHttpClient.Builder().connectTimeout(builder.connectTimeout, TimeUnit.SECONDS);
        client=builder1.build();

    }

    @Override
    public void makePost(String url, HashMap map, final NetWorkCallBack mNetWorkCallBack) {

        this.url=url;
        this.map=map;
        this.mNetWorkInterface=mNetWorkCallBack;
        this.execute();
    }

    @Override
    public void makeGet(String url, HashMap map, NetWorkCallBack mNetWorkCallBack) {
        state=1;
        this.url=url;
        this.map=map;
        this.mNetWorkInterface=mNetWorkCallBack;
        this.execute();
    }

    @Override
    protected String doInBackground(Integer... params) {
        FormBody.Builder mBuilder=new FormBody.Builder();
        if(null!=map){
            Iterator cancelable = map.entrySet().iterator();
            while (cancelable.hasNext()) {
                Map.Entry entry = (Map.Entry) cancelable.next();
                mBuilder.add(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }
        }

        Request request;
        if(state==0){
             request = new Request.Builder()
                    .url(url)
                    .post(mBuilder.build())
                    .build();
        }else {
             request = new Request.Builder()
                     .method("GET",null)
                    .url(url)
                    .build();
        }




        Call call = client.newCall(request);
        try {
            Response response = call.execute();

            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 这里的String参数对应AsyncTask中的第三个参数（也就是接收doInBackground的返回值）
     * 在doInBackground方法执行结束之后在运行，并且运行在UI线程当中 可以对UI空间进行设置
     */
    @Override
    protected void onPostExecute(String result) {

        if(null!=result){
            if(null!=mNetWorkInterface)
                mNetWorkInterface.success(result);
        }else{
//            这里判断是否连上了服务器
            if(null!=mNetWorkInterface)
                mNetWorkInterface.failed();
        }

    }
}
