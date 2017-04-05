package demo.skyland.com.demo.playbill;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.security.PublicKey;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by skyland on 2017/4/5
 */

public class HeaderLvAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private Context context;

    public HeaderLvAdapter (Context context){
        this.context = context;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public long getHeaderId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
