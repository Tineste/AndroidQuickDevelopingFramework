package frame.xuchao.orz.frame.Demo.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import frame.xuchao.orz.frame.R;
import frame.xuchao.orz.frame.base.base.BaseActivity;
import frame.xuchao.orz.frame.base.base.BaseFragmentActivity;

/**
 * Created by Administrator on 2017/6/13 0013.
 */

public class SecondActivity extends BaseActivity {

    private String[] mTitles_2 = {"首页", "消息", "联系人"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private SegmentTabLayout tabLayout_4;
    private ViewPager vp_3;

    @Override
    protected void setView() {
        setContentView(R.layout.activity_second);
        tabLayout_4 = (SegmentTabLayout) findViewById(R.id.tl_4);
        vp_3 = (ViewPager) findViewById(R.id.vp_2);

    }
    @Override
    protected void setDate() {
        mFragments.add(new MyFragment1());
        mFragments.add(new MyFragment2());
        mFragments.add(new MyFragment1());
        tabLayout_4.setTabData(mTitles_2);
        vp_3.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        vp_3.setCurrentItem(1);

    }

    @Override
    protected void setControl() {
        tabLayout_4.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp_3.setCurrentItem(position);
            }
            @Override
            public void onTabReselect(int position) {
            }
        });
        vp_3.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout_4.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles_2[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

}
