package frame.xuchao.orz.frame.base.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {

    private int mLayoutId;
    protected ViewGroup rootView;

    protected Context mContext;

    public BaseFragment(int mLayoutId) {
        this.mLayoutId = mLayoutId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {


        rootView = (ViewGroup) inflater.inflate(mLayoutId,
                container, false);

        mContext=getActivity();
        setView();
        setDate();
        setControl();


        return rootView;
    }
    protected abstract void setView();
    protected abstract void setDate();
    protected abstract void setControl();






    public View findViewById(int id){
        return  rootView.findViewById(id);
    }



    /**
     * 从本页面跳转到另外一个页面
     *
     * @param cls 需要跳转到的页面
     */
    protected void startActivity(Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
    }



    public void startActivityForResult(Class<?> cls, int requestCode) {
        Intent intent = new Intent(mContext, cls);
        startActivityForResult(intent, requestCode);
    }




    public interface PullListener {
        void oncomplent();
    }
}
