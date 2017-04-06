package demo.skyland.com.demo.playbill;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import demo.skyland.com.demo.R;

/**
 * Created by skyland on 2017/4/5
 */

public class SectionAdapter extends BaseSectionQuickAdapter<MySection, BaseViewHolder> {

    public SectionAdapter(int layoutResId, int sectionHeadResId, List data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, MySection item) {
        helper.setText(R.id.item_playbill_date_day_text, item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, MySection item) {
        ProgramModel info = (ProgramModel) item.t;
        helper.setText(R.id.item_playbill_program_normal_time_text, info.getDate());
        helper.setText(R.id.item_playbill_date_week_text, info.getDate());
    }
}
