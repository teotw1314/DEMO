package com.lxsky.hitv;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import com.lxsky.hitv.avloading.AvLoadingActivity;
import com.lxsky.hitv.base.BaseActivity;
import com.lxsky.hitv.playbill.PlayBillActivity;
import com.lxsky.hitv.service.ServiceActivity;
import com.lxsky.hitv.umengshare.UmengShareActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_start_service_activity)
    Button mStartServiceActivity;

    @BindView(R.id.main_avloading_activity)
    Button mStartAvLoadingActivity;

    @BindView(R.id.main_playbill_activity)
    Button mStartPlaybillActivity;

    @BindView(R.id.mian_umeng_activity)
    Button mStartUmengActivity;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        mStartServiceActivity.setOnClickListener(this);
        mStartAvLoadingActivity.setOnClickListener(this);
        mStartPlaybillActivity.setOnClickListener(this);
        mStartUmengActivity.setOnClickListener(this);
    }

    @Override
    protected void initLogic() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_start_service_activity:
                startActivity(ServiceActivity.class);
                break;

            case R.id.main_avloading_activity:
                startActivity(AvLoadingActivity.class);
                break;

            case R.id.main_playbill_activity:
                startActivity(PlayBillActivity.class);
                break;

            case R.id.mian_umeng_activity:
                startActivity(UmengShareActivity.class);
                break;

            default:
                break;
        }
    }
}
