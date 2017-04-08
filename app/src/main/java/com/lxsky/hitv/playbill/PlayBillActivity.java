package com.lxsky.hitv.playbill;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.Log;
import android.view.View;

import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.lxsky.hitv.R;
import com.lxsky.hitv.base.BaseActivity;
import com.orhanobut.logger.Logger;

import com.oubowu.stickyitemdecoration.StickyHeadContainer;
import com.oubowu.stickyitemdecoration.StickyItemDecoration;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by skyland on 2017/4/5
 */

public class PlayBillActivity extends BaseActivity {

    @BindView(R.id.playbill_date_rv)
    RecyclerView mDateRecyclerView;

    @BindView(R.id.playbill_program_rv)
    RecyclerView mProgramRecyclerView;

    @BindView(R.id.playbill_stickyhead)
    StickyHeadContainer mStickyHead;


    private List<ProgramMultiItem> programListData = new ArrayList<>();
    private ProgramRvAdapter mProgramAdapter;
    private SnappingLinearLayoutManager mProgramLayoutManager;
    private boolean isMove = false;
    private int mIndex = 0;

    private List<Date> mDateList = new ArrayList<>();
    private DateRvAdapter mDateAdapter;


    private int programSelectPos = 0;


    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_playbill);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);

        programListData = DataServer.getMultipleItemData();

        Logger.d(programListData.size());

        /**
         * date_list data
         */
        int programPos = 0;
        int size = programListData.size();
        for (int i = 0; i < size; i++) {
            ProgramMultiItem item = programListData.get(i);
            if (item.getHeaderName() != null) {
                mDateList.add(new Date(i, programPos, item.getHeaderName(), false));
                programPos++;
            } else {
                programPos++;
            }
        }

        /**
         * 粘性标签
         */
        final TextView tvDate = (TextView) mStickyHead.findViewById(R.id.item_playbill_date_day_text);
        mStickyHead.setDataCallback(new StickyHeadContainer.DataCallback() {
            @Override
            public void onDataChange(int pos) {
                tvDate.setText(programListData.get(pos).getHeaderName());
            }
        });

        /**
         * program list view
         */
        mProgramLayoutManager = new SnappingLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mProgramRecyclerView.setLayoutManager(mProgramLayoutManager);
        mProgramRecyclerView.addItemDecoration(new StickyItemDecoration(mStickyHead, ProgramMultiItem.TYPE_HEADER));
        mProgramAdapter = new ProgramRvAdapter(programListData);
        mProgramRecyclerView.setAdapter(mProgramAdapter);
        mProgramRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (adapter.getItemViewType(position) == ProgramMultiItem.TYPE_PROGRAM) {
                    Video video = programListData.get(position).getVideo();
//                    Logger.d(programListData.get(position).getVideo().getName() + "  pos:" + position);

                    //设置点击后的高亮选项
                    if (video.isPlaying()) {
                        return;
                    } else {
                        Logger.d("programSelectPos:" + programSelectPos);
                        if (programSelectPos != 0) {
                            programListData.get(programSelectPos).getVideo().setPlaying(false);
                        }
                        video.setPlaying(true);
                        programSelectPos = position;
                        mProgramAdapter.notifyDataSetChanged();
                    }
                }
            }
        });

        mProgramRecyclerView.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Logger.d(newState);
                if(isMove && newState == RecyclerView.SCROLL_STATE_IDLE){
                    isMove = false;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int first = mProgramLayoutManager.findFirstVisibleItemPosition();
                Logger.d(first);
                if(isMove){
                    return;
                }
                if(mProgramAdapter.getItemViewType(first) == ProgramMultiItem.TYPE_HEADER){
                    ///设置日期高亮
                    for (Date item : mDateList) {
                        if (item.getProgramPos() == first) {
                            item.setSelected(true);
                        } else {
                            item.setSelected(false);
                        }
                    }
                    mDateAdapter.notifyDataSetChanged();
                }

            }
        });



        /**
         * date list view
         */
        mDateRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mDateAdapter = new DateRvAdapter(mDateList);
        mDateRecyclerView.setAdapter(mDateAdapter);
        mDateRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Logger.d(mDateList.get(position).getDate() + "  pos:" + mDateList.get(position).getProgramPos());
                ///点击左边日期后右边跳转到相应日期的节目//
                int programPos = mDateList.get(position).getProgramPos();
//                mProgramRecyclerView.scrollToPosition(programPos);
                isMove = true;
                mProgramRecyclerView.smoothScrollToPosition(programPos);
                ///设置日期高亮
                for (Date item : mDateList) {
                    if (item.getProgramPos() == programPos) {
                        item.setSelected(true);
                    } else {
                        item.setSelected(false);
                    }
                }
                mDateAdapter.notifyDataSetChanged();


            }
        });
    }

    @Override
    protected void initLogic() {

    }

    @Override
    public void onClick(View v) {

    }

}
