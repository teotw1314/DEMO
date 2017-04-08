package com.lxsky.hitv.playbill;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by skyland on 2017/4/5
 */

public class ProgramMultiItem implements MultiItemEntity {

    public static final int TYPE_HEADER = 1;
    public static final int TYPE_PROGRAM = 2;
    public static final int TYPE_STICKY_HEAD = 3;


    private int itemType;

    String headerName;
    Video video;

    public ProgramMultiItem(String setHeaderName) {
        itemType = TYPE_HEADER;
        this.headerName = setHeaderName;
    }

    public ProgramMultiItem(Video video) {
        itemType = TYPE_PROGRAM;
        this.video = video;
    }

    public String getHeaderName() {
        return headerName;
    }

    public Video getVideo() {
        return video;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
