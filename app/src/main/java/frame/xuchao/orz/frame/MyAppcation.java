package frame.xuchao.orz.frame;

import android.app.Application;

import frame.xuchao.orz.frame.base.util.CrashHandler;

public class MyAppcation extends Application{



	@Override
	public void onCreate() {
		super.onCreate();
		CrashHandler.getInstance().init(this);
	}

}
