package com.lxsky.hitv.umengshare;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.brightstar.library.umeng.UmengShare;
import com.lxsky.hitv.R;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.lxsky.hitv.base.BaseActivity;

/**
 * Created by skyland on 2017/4/7
 */

public class UmengShareActivity extends BaseActivity {

    @BindView(R.id.umeng_start_share)
    Button mStartShare;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_umengshare);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);

    }

    @Override
    protected void initLogic() {
        mStartShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.umeng_start_share:
                startShare();
                break;

            default:
                break;
        }
    }

    private void startShare(){
        String shareContent = "我正在使用小象嗨TV手机客户端观看"  +
                "，马上下载小象嗨TV手机客户端，把电视装进口袋！一起分享好看的节目，下载地址：" + UmengShare.SHARE_URL;
        new UmengShare(){

            @Override
            public void onSuccess(SHARE_MEDIA platform) {
                Toast.makeText(UmengShareActivity.this, platform + " 分享成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(SHARE_MEDIA platform, Throwable throwable) {
                Toast.makeText(UmengShareActivity.this, platform + " 分享失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(UmengShareActivity.this, platform + " 分享取消", Toast.LENGTH_SHORT).show();
            }
        }.shareWithBitmap(this, shareContent, shareContent, UmengShare.SHARE_URL,
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
