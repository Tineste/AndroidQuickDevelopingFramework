package frame.xuchao.orz.frame.base.base;

import android.support.v4.app.Fragment;

import frame.xuchao.orz.frame.base.util.FragmentOperateUtil;


/**
 * Created by Administrator on 2017/5/12 0012.
 */

public abstract class BaseFragmentActivity extends BaseActivity {
    protected int mRootViewRes;

    @Override
    protected void setView() {
        setRootViewRes();
    }

    protected abstract void setRootViewRes();

    public Fragment goFragment(Class<? extends Fragment> clazz, String tag) {
        if (FragmentOperateUtil.isExistFragment(getSupportFragmentManager(),
                tag)) {
            FragmentOperateUtil.popFragmentBackStack(
                    getSupportFragmentManager(), tag, 0);

        } else {
            return FragmentOperateUtil.replaceFragment(
                    getSupportFragmentManager(), clazz, mRootViewRes, tag,
                    null, true);
        }
        return null;
    }


}
