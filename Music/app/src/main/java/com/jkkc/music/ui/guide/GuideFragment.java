package com.jkkc.music.ui.guide;


import android.net.Uri;
import android.support.v4.app.Fragment;

import com.jkkc.music.R;
import com.jkkc.music.ui.widget.CustomView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GuideFragment extends LoadFragment {

    private CustomView customView;

    public GuideFragment() {

    }


    @Override
    protected void lazyLoadData() {

        customView = findViewById(R.id.cv);
        int index = getArguments().getInt("index");
        Uri uri;
        if (index == 1) {

            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/"
                    + R.raw.guide_1);
        } else if (index == 2) {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/"
                    + R.raw.guide_2);
        } else {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/"
                    + R.raw.guide_3);
        }

        customView.playVideo(uri);

    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_guide;
    }

    @Override
    protected void stopLoad() {
        super.stopLoad();

        if (customView!=null){
            customView.stopPlayback();
        }
    }


}
