package frame.xuchao.orz.frame.base.base;

/**
 * Created by Administrator on 2017/5/18 0018.
 */

public class MyBaseBean<T>{
    protected int statu;//状态
    protected String msg;//信息
    protected T data;

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
