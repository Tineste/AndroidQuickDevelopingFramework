package frame.xuchao.orz.frame.base.base;

/**
 * Created by Administrator on 2017/4/21 0021.
 */

public abstract class BasePresenter<T extends  BaseViewMode> {

    public String TAG=this.getClass().getSimpleName();



    public T mBaseViewMode;
    public void attach(T baseViewMode){
        mBaseViewMode=baseViewMode;
    }

    public void detach(){
        if(null!=mBaseViewMode)
            mBaseViewMode=null;
    }


}
