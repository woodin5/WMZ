package com.wmz.wmz.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.wmz.wmz.R;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);


        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new MyAdapter(this));
    }

    class MyAdapter extends BaseAdapter{
        final int TYPE_1=1;
        final int TYPE_2=2;
        final int TYPE_3=3;
        final int TYPE_COUNT = 3;
        Context context;
        ArrayList<String> list1;
        ArrayList<String> list2;
        ArrayList<Integer> list;
        public MyAdapter(Context context){
            this.context = context;
            list1 = new ArrayList<>();
            list2 = new ArrayList<>();
            list = new ArrayList<>();
            for(int i=0;i<15;i++){
                list.add(i);
            }
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
            return position;
        }

        @Override
        public int getItemViewType(int position) {
            int type = list.get(position);
            if(type>=0 && type<=5){
                return TYPE_1;
            }else if(type>5 && type<=10){
                return TYPE_2;
            }else if(type>10 && type<15){
                return TYPE_3;
            }
            return super.getItemViewType(position);
        }

        @Override
        public int getViewTypeCount() {
            return TYPE_COUNT;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            int type = getItemViewType(position);
            ViewHolder holder = null;
            switch (type){
                case TYPE_1:

                    if(convertView==null){
                        holder = new ViewHolder();
                        convertView = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
                        holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
                        holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
                        holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
                        holder.textView4 = (TextView) convertView.findViewById(R.id.textView4);

                    }else{
                        holder = (ViewHolder) convertView.getTag();
                    }
                    holder.textView1.setText(list.get(position)+"");
                    holder.textView2.setText(list.get(position)+"");
                    holder.textView3.setText(list.get(position)+"");
                    holder.textView4.setText(list.get(position)+"");
                    break;
                case TYPE_2:
                    if(convertView==null){
                        holder = new ViewHolder();
                        convertView = LayoutInflater.from(context).inflate(R.layout.item_grid,parent,false);
                        holder.textView1 = (TextView) convertView.findViewById(R.id.textView5);
                        holder.textView2 = (TextView) convertView.findViewById(R.id.textView6);
                        holder.textView3 = (TextView) convertView.findViewById(R.id.textView7);
                        holder.textView4 = (TextView) convertView.findViewById(R.id.textView8);

                    }else{
                        holder = (ViewHolder) convertView.getTag();
                    }
                    holder.textView1.setText(list.get(position)+"");
                    holder.textView1.setText(list.get(position)+"");
                    holder.textView1.setText(list.get(position)+"");
                    holder.textView1.setText(list.get(position)+"");
                    break;
                case TYPE_3:
                    break;
            }
            return convertView;
        }

        class ViewHolder{
            TextView textView1;
            TextView textView2;
            TextView textView3;
            TextView textView4;
        }
    }
}
