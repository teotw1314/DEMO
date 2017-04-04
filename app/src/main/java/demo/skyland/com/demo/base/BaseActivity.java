package demo.skyland.com.demo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by skyland on 2017/3/27
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initContentView(savedInstanceState);
        initButterKnife();
        initView();
        initLogic();
    }

    /**
     * 设置contentview
     */
    protected abstract void initContentView(Bundle savedInstanceState);

    /**
     * 设置contentview
     */
    private  void initButterKnife(){
        ButterKnife.bind(this);
    }

    /**
     * 初始化布局
     */
    protected abstract void initView();

    /**
     * 逻辑处理
     */
    protected abstract void initLogic();

    ////////////////////////////////////////////////////////////////////////////////
    /////


    /**
     * 页面跳转相关
     */
    //页面跳转
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(BaseActivity.this, clz));
    }

    //携带数据的页面跳转
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    //携带数据带有返回值的页面跳转
    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * toast提示
     */
    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
