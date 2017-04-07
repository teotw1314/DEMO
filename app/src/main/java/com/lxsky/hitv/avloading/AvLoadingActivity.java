package com.lxsky.hitv.avloading;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lxsky.hitv.R;
import com.wang.avi.AVLoadingIndicatorView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lxsky.hitv.base.BaseActivity;


/**
 * Created by skyland on 2017/3/29
 */

public class AvLoadingActivity extends BaseActivity {

    @BindView(R.id.avloading_view)
    AVLoadingIndicatorView mAvLoadingView;

    @BindView(R.id.avloading_btn_show)
    Button mBtnShow;

    @BindView(R.id.avloading_btn_hide)
    Button mBtnHide;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_avloading);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        mBtnShow.setOnClickListener(this);
        mBtnHide.setOnClickListener(this);
    }

    @Override
    protected void initLogic() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.avloading_btn_show:
                mAvLoadingView.show();
                break;

            case R.id.avloading_btn_hide:
                mAvLoadingView.hide();
                break;

            default:
                break;
        }

    }
}
