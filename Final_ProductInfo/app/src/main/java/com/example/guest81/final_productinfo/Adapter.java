package com.example.guest81.final_productinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter implements Filterable {
    private Context context;
    private int layout;
    private ArrayList<Product> ProductList;
    private LayoutInflater layoutInflater;

    ArrayList<Product> list = new ArrayList<Product>();//기존의 상품 데이터
    ArrayList<Product> filtered = list;//필터링된 리스트뷰의 상품 데이터
    Filter listFilter;

    public Adapter(Context context, int layout, ArrayList<Product> ProductList){
        this.context = context;
        this.layout = layout;
        this.ProductList = ProductList;
        this.list = ProductList;
        this.filtered = ProductList;

        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return filtered.size();
    }

    @Override
    public Object getItem(int pos) {
        return filtered.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return filtered.get(pos).get_id();
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        final int position = pos;
        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layout, viewGroup, false);

            holder = new ViewHolder();
            holder.tvBank = (TextView)convertView.findViewById(R.id.tvBank);
            holder.tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
            holder.tvRate = (TextView)convertView.findViewById(R.id.tvRate);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvBank.setText(filtered.get(position).getBank());
        holder.tvTitle.setText(filtered.get(position).getTitle());
        holder.tvRate.setText(Double.valueOf(filtered.get(position).getRate()).toString());

        return convertView;
    }

    static class ViewHolder {
        TextView tvBank;
        TextView tvTitle;
        TextView tvRate;
    }

    @Override
    public Filter getFilter() {
        if(listFilter == null)
            listFilter = new ListFilter();
        return listFilter;
    }

    private class ListFilter extends Filter {
        @Override
        protected FilterResults performFiltering (CharSequence constraint){
            FilterResults results = new FilterResults();

            if(constraint == null || constraint.length() == 0) {
                results.values = list;
                results.count = list.size();
            }
            else{
                ArrayList<Product> itemList = new ArrayList<Product>();
                for(Product item : list){
                    if(item.getBank().contains((constraint.toString())))
                        itemList.add(item);
                }
                results.values = itemList;
                results.count = itemList.size();
            }
            return results;
        }

        @Override
        protected void publishResults (CharSequence constrain, FilterResults results){
            filtered = (ArrayList<Product>)results.values;

            if(results.count >= 0)
                notifyDataSetChanged();
            else
                notifyDataSetInvalidated();
        }
    }

}

