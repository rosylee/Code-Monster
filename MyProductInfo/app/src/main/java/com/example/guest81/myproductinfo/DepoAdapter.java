package com.example.guest81.myproductinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class DepoAdapter  extends BaseAdapter implements Filterable {
    private Context context;
    private int layout;
    private ArrayList<Product> movieList;
    private LayoutInflater layoutInflater;

    TextView tvTitle;
    TextView tvDirector;
    TextView tvDate;
    TextView tvMark;

    ArrayList<Product> list = new ArrayList<Product>();
    ArrayList<Product> filtered = list;
    Filter listFilter;

    public MyAdapter(Context context, int layout, ArrayList<Product> movieList) {
        this.context = context;
        this.layout = layout;
        this.movieList = movieList;
        this.list = movieList;
        this.filtered = movieList;

        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return filtered.size();
    }

    @Override
    public Object getItem(int position) {
        return filtered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return filtered.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final int pos = position;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layout, viewGroup, false);
        }

        tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
        tvDirector = (TextView)convertView.findViewById(R.id.tvDirector);
        tvDate = (TextView)convertView.findViewById(R.id.tvDate);
        tvMark = (TextView)convertView.findViewById(R.id.tvMark);

        tvTitle.setText(filtered.get(pos).getTitle());
        tvDirector.setText(filtered.get(pos).getDirector());
        tvDate.setText(filtered.get(pos).getDate());
        tvMark.setText(filtered.get(pos).getMark());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if(listFilter == null)
            listFilter = new ListFilter();
        return listFilter;
    }

    public class ListFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if(constraint == null || constraint.length() == 0) {
                results.values = list;
                results.count = list.size();
            }
            else {
                ArrayList<Product> itemList = new ArrayList<Product>();

                for(Product item : list) {
                    if(constraint.equals(item.getDate()))
                        itemList.add(item);
                }

                results.values = itemList;
                results.count = itemList.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filtered = (ArrayList<Product>) results.values;
            if(results.count >= 0)
                notifyDataSetChanged();
            else
                notifyDataSetInvalidated();
        }
    }
}

