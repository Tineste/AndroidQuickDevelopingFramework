package frame.xuchao.orz.frame.Demo.viewmodle;

import java.util.ArrayList;

import frame.xuchao.orz.frame.base.base.BaseViewMode;
import frame.xuchao.orz.frame.bean.MainBtnBean;

/**
 * Created by Administrator on 2017/4/26 0026.
 */

public interface GetHomePictureViewMode extends BaseViewMode {

    void getHomePictureSuccess(int status, String msg, ArrayList<MainBtnBean> mMainBtnBeans);
}
