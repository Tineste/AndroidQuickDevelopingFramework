package frame.xuchao.orz.frame.base.net;


import java.util.HashMap;

/**
 * Created by Administrator on 2017/4/24 0024.
 */

public interface HttpProxyInterface {


    void setHttpSet(HttpProxy.Builder builder);
    void makePost(String url, HashMap map, NetWorkCallBack callBack);
    void makeGet(String url, HashMap map, NetWorkCallBack callBack);
}
