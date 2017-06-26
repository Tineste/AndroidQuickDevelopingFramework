package frame.xuchao.orz.frame.base.net;


import java.util.HashMap;

/**
 * Created by Administrator on 2017/4/24 0024.
 */

public class HttpProxy {


//    更换三方网络框架的时候这里换下就好了
    HttpProxyInterface mHttpProxyInterface=new OkhttpNetWork();


    private int connectTimeout;//连接超时


    public void makePost(String url , HashMap map, NetWorkCallBack callBack) {
        mHttpProxyInterface.makePost(url,map,callBack);
   }

    public void makeGet(String url , HashMap map, NetWorkCallBack callBack) {
        mHttpProxyInterface.makeGet(url,map,callBack);
    }



    private HttpProxy(){}
    protected HttpProxy(Builder builder) {
        if(null==mHttpProxyInterface)
            mHttpProxyInterface=new OkhttpNetWork();
        if(!builder.isDefault){
            //        设置框架的参数
            mHttpProxyInterface.setHttpSet(builder);
        }



    }




//    一些有特别需求的http请求设置
    public static final class Builder{
        //        网络的相关设置，目前就先用到链接超时，以后有新的需求慢慢扩展功能
//        private int maxCacheSize;//缓存大小
//        private File cachedDir;//缓存目录
        public int connectTimeout;//连接超时
//        private int readTimeout;//读超时
//        private int writeTimeout;//写超时
//        private boolean retryOnConnectionFailure;//失败重新连接
//        private List<Interceptor> networkInterceptors;//网络拦截器
//        private List<Interceptor> interceptors;//应用拦截器
//        private List<ResultInterceptor> resultInterceptors;//请求结果拦截器
//        private List<ExceptionInterceptor> exceptionInterceptors;//请求链路异常拦截器
//        private int cacheSurvivalTime;//缓存存活时间（秒）
//        private int cacheType;//缓存类型
//        private int cacheLevel;//缓存级别
//        private boolean isGlobalConfig;//是否全局配置
//        private boolean showHttpLog;//是否显示Http请求日志
//        private String httpLogTAG;//显示Http请求日志标识
//        private boolean showLifecycleLog;//是否显示ActivityLifecycle日志
//        private String downloadFileDir;//下载文件保存目录
//        private String requestTag;
//        private CookieJar cookieJar;
        private boolean isDefault=false;//是否默认请求

        public Builder() {}



        public Builder setConnectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
            return  this;
        }

        public Builder setDefaultSet(){
            this.connectTimeout=10000;
            isDefault=true;
            return this;
        }


        public HttpProxy builder(){

            return new HttpProxy(this);
        }

}


}
