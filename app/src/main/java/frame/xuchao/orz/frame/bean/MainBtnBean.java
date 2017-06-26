package frame.xuchao.orz.frame.bean;

/**
 * Created by Administrator on 2017/3/21 0021.
 */

public class MainBtnBean {
    private  int id;
    private String title;
    private String url;

    public String getRedirecturl() {
        return redirecturl;
    }

    public void setRedirecturl(String redirecturl) {
        this.redirecturl = redirecturl;
    }

    private String redirecturl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
