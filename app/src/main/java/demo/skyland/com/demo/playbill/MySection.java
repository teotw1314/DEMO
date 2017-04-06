package demo.skyland.com.demo.playbill;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by skyland on 2017/4/5
 */

public class MySection extends SectionEntity<ProgramModel> {

//    private boolean isMore;

    public MySection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public MySection(ProgramModel programModel) {
        super(programModel);
    }
}
