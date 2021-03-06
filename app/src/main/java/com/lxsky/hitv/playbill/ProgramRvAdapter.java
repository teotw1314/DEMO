package com.lxsky.hitv.playbill;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lxsky.hitv.R;
import com.oubowu.stickyitemdecoration.FullSpanUtil;

import java.util.List;


/**
 * Created by skyland on 2017/4/5
 */

public class ProgramRvAdapter extends BaseMultiItemQuickAdapter<ProgramMultiItem, BaseViewHolder> {


    public ProgramRvAdapter(List<ProgramMultiItem> data) {
        super(data);
        addItemType(ProgramMultiItem.TYPE_HEADER, R.layout.item_playbill_date);
        addItemType(ProgramMultiItem.TYPE_PROGRAM, R.layout.item_playbill_program);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProgramMultiItem item) {
        if (item.getItemType() == ProgramMultiItem.TYPE_HEADER) {
            helper.setText(R.id.item_playbill_date_day_text, item.getHeaderName());
        } else {
            helper.setText(R.id.item_playbill_program_normal_name_text, item.getVideo().getName());
            if(item.getVideo().isPlaying()){
                helper.getConvertView().setBackgroundColor(ContextCompat.getColor(mContext, R.color.playbill_item_program_selected_bg));
            }else{
                helper.getConvertView().setBackgroundColor(ContextCompat.getColor(mContext, R.color.playbill_item_program_normal_bg));
            }
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        FullSpanUtil.onAttachedToRecyclerView(recyclerView, this, ProgramMultiItem.TYPE_HEADER);
    }

    @Override
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        FullSpanUtil.onViewAttachedToWindow(holder, this, ProgramMultiItem.TYPE_HEADER);
    }
}
