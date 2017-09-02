package com.jkkc.music.ui.guide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * fragment 预加载问题的处理
 * <p>
 * 1，可以懒加载的fragment
 * 2,
 */
public abstract class LoadFragment extends Fragment {

    /**
     * 判断视图是否已经初始化
     */
    protected boolean isInitView = false;

    //是否可以加载数据
    protected boolean isLoadData = false;

    private View view;

    public LoadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(setContentView(), container, false);

        /**
         * 视图是否已经初始化
         */
        isInitView = true;
        isCanLoadData();

        return view;
    }

    protected void isCanLoadData() {

        if (!isInitView) {
            return;
        }

        /**
         * 视图用户可见
         */
        if (getUserVisibleHint()) {

            lazyLoadData();
            isLoadData = true;

        } else {
            if (isLoadData) {
                stopLoad();
            }
        }
    }

    /**
     * 系统方法 ，告诉系统UI可见
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }

    protected void stopLoad() {


    }

    protected abstract void lazyLoadData();


    /***
     * 设置视图
     * @return
     */
    protected abstract int setContentView();


    protected View getContentView() {

        return view;

    }

    protected <T extends View> T findViewById(int id) {

        return (T) getContentView().findViewById(id);
    }

}
