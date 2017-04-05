package demo.skyland.com.demo.playbill;

import android.os.Bundle;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.skyland.com.demo.R;
import demo.skyland.com.demo.base.BaseActivity;


import android.support.v7.widget.RecyclerView;


/**
 * Created by skyland on 2017/4/5
 */

public class PlayBillActivity extends BaseActivity {

    @BindView(R.id.playbill_date_rv)
    RecyclerView mDateRecyclerView;

    @BindView(R.id.playbill_program_rv)
    RecyclerView mProgramRecyclerView;


    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_playbill);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initLogic() {

    }

    @Override
    public void onClick(View v) {

    }
}
