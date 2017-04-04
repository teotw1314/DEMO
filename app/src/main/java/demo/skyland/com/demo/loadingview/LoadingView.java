package demo.skyland.com.demo.loadingview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.skyland.com.demo.R;

/**
 * Created by skyland on 2017/3/29
 */

public class LoadingView extends FrameLayout {

    @BindView(R.id.view_loading_progress_framge)
    FrameLayout mFrameProgress;

    @BindView(R.id.view_loading_progress_text)
    TextView mProgressText;

    @BindView(R.id.view_loading_error_frame)
    FrameLayout mFrameError;

    @BindView(R.id.view_loading_error_title)
    TextView mTitleText;

    @BindView(R.id.view_loading_error_info)
    TextView mInfoText;

    @BindView(R.id.view_loading_error_image)
    ImageView mErrorImage;

    public LoadingView(Context context) {
        super(context);
        initView(context);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_loading_layout, this);
        LoadingView.this.setVisibility(VISIBLE);
        LoadingView.this.setEnabled(false);
        ButterKnife.bind(this);
    }

    public void showLoading(@Nullable String progressText){
        this.setVisibility(VISIBLE);
        if(progressText == null){
            mProgressText.setText(getResources().getString(R.string.view_loading_loadingtext));
        }else{
            mProgressText.setText(progressText);
        }
        mFrameError.setVisibility(GONE);
        mFrameProgress.setVisibility(VISIBLE);
    }

    public void dismiss(){
        this.setVisibility(GONE);
    }

    public void showError(){

    }




}
