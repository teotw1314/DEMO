package demo.skyland.com.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import demo.skyland.com.demo.avloading.AvLoadingActivity;
import demo.skyland.com.demo.base.BaseActivity;
import demo.skyland.com.demo.playbill.PlayBillActivity;
import demo.skyland.com.demo.service.ServiceActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_start_service_activity)
    Button mStartServiceActivity;

    @BindView(R.id.main_avloading_activity)
    Button mStartAvLoadingActivity;

    @BindView(R.id.main_playbill_activity)
    Button mStartPlaybillActivity;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        mStartServiceActivity.setOnClickListener(this);
        mStartAvLoadingActivity.setOnClickListener(this);
        mStartPlaybillActivity.setOnClickListener(this);
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

            default:
                break;
        }
    }
}
