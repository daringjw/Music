package com.jkkc.music.ui.guide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jkkc.music.R;
import com.jkkc.music.ui.cnmusic.BaseActivity;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class GuideActivity extends BaseActivity {

    @InjectView(R.id.vp)
    ViewPager vp;
    @InjectView(R.id.iv1)
    ImageView iv1;
    @InjectView(R.id.iv2)
    ImageView iv2;
    @InjectView(R.id.iv3)
    ImageView iv3;
    @InjectView(R.id.bt_start)
    Button btStart;
    private ArrayList<Fragment> fragments;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.inject(this);
        initData();
        initView();


    }

    private void initView() {

        vp.setOffscreenPageLimit(3);
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        vp.addOnPageChangeListener(new MyPagerListener());

    }

    /***
     * 初始化数据，添加三个fragment
     */
    private void initData() {

        fragments = new ArrayList<>();
        GuideFragment fragment1 = new GuideFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("index", 1);
        fragment1.setArguments(bundle1);
        fragments.add(fragment1);

        GuideFragment fragment2 = new GuideFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("index", 2);
        fragment2.setArguments(bundle2);
        fragments.add(fragment2);

        GuideFragment fragment3 = new GuideFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putInt("index", 3);
        fragment3.setArguments(bundle3);
        fragments.add(fragment3);


    }


    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {

            super(fm);

        }

        @Override
        public Fragment getItem(int position) {

            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    public class MyPagerListener implements ViewPager.OnPageChangeListener {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            btStart.setVisibility(View.GONE);
            iv1.setImageResource(R.mipmap.dot_normal);
            iv2.setImageResource(R.mipmap.dot_normal);
            iv3.setImageResource(R.mipmap.dot_normal);
            if (position == 0) {
                iv1.setImageResource(R.mipmap.dot_focus);
            } else if (position == 1) {
                iv2.setImageResource(R.mipmap.dot_focus);
            } else if (position == 2) {
                iv3.setImageResource(R.mipmap.dot_focus);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
