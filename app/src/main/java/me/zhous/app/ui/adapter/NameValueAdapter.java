package me.zhous.app.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import me.zhous.app.R;

/**
 * Created by zhous on 2016/10/28.
 */
public class NameValueAdapter extends BaseAdapter {
    private List<String[]> list = null;
    private LayoutInflater mInflater;
    public NameValueAdapter(Context context, List<String[]> list){
        this.list = list;
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String[] getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NameValueHolder holder ;
        if(null == convertView){
            convertView = mInflater.inflate(R.layout.item_name_value,null);
            holder = new NameValueHolder();
            holder.t_name = (TextView) convertView.findViewById(R.id.t_name);
            holder.t_value = (TextView) convertView.findViewById(R.id.t_value);
            convertView.setTag(holder);
        }else{
            holder = (NameValueHolder) convertView.getTag();
        }
        String[]s = getItem(position);
        holder.t_name.setText(s[0]);
        holder.t_value.setText(s[1]);
        return convertView;
    }

    class NameValueHolder{
        TextView t_name;
        TextView t_value;
    }
}
