package com.lxsky.hitv.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;

import com.lxsky.hitv.R;
import com.lxsky.hitv.base.BaseActivity;


/**
 * Created by skyland on 2017/3/27
 */

public class ServiceActivity extends BaseActivity {

    @BindView(R.id.service_btn_start)
    Button mStartService;

    @BindView(R.id.service_btn_stop)
    Button mStopService;

    @BindView(R.id.service_bind_service)
    Button mBindService;

    @BindView(R.id.service_unbind_service)
    Button mUnBindService;

    private MyService.MyBinder myBinder;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_service);
    }

    @Override
    protected void initView() {
        mStartService.setOnClickListener(this);
        mStopService.setOnClickListener(this);
        mBindService.setOnClickListener(this);
        mUnBindService.setOnClickListener(this);
    }

    @Override
    protected void initLogic() {

    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyService.MyBinder) service;
            myBinder.startDoSomething();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.service_btn_start:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.service_btn_stop:
                Intent stopIntent  = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
            case R.id.service_bind_service:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.service_unbind_service:
                unbindService(connection);
                break;
            default:
                break;
        }
    }
}
