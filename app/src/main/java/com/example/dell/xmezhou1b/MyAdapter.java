package com.example.dell.xmezhou1b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by DELL on 2017/6/11.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Student.StudentsBean.StudentBean> list;

    public MyAdapter(Context context,List<Student.StudentsBean.StudentBean> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = View.inflate(context,R.layout.item,null);

            holder.image_item = (ImageView) convertView.findViewById(R.id.image_item);
            holder.name_item = (TextView) convertView.findViewById(R.id.name_item);

            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name_item.setText(list.get(position).getName());
        ImageLoader.getInstance().displayImage(list.get(position).getImg(),holder.image_item);

        return convertView;
    }

    class ViewHolder {
        ImageView image_item;
        TextView name_item;
    }
}
