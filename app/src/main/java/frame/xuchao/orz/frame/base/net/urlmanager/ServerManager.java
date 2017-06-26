package frame.xuchao.orz.frame.base.net.urlmanager;

import android.hardware.camera2.CameraCaptureSession;

import frame.xuchao.orz.frame.base.configure.Configure;

/**
 * Created by Administrator on 2017/6/8 0008.
 */

public class ServerManager {
//    测试环境ip
    public static final String testServer="http://appcs.hi66.com/app/";
    public static final String productionServer="正式环境ip";

    public static final String server= Configure.isDebug?testServer:productionServer;

    public static String getUrl(String url){
        return server+url;
    }
}
