package demo.skyland.com.demo.playbill;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by skyland on 2017/4/5
 */

public class ProgramSection implements MultiItemEntity {

    public static final int TYPE_HEADER = 1;
    public static final int TYPE_PROGRAM = 2;



    @Override
    public int getItemType() {
        return 0;
    }
}
