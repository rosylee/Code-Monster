package com.example.guest81.final_productinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter implements Filterable {
    private Context context;
    private int layout;
    private ArrayList<Product> ProductList;
    private LayoutInflater layoutInflater;
    private ImageView ivImage;

    ArrayList<Product> list = new ArrayList<Product>();
    ArrayList<Product> filtered = list;
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
            holder.ivImage = (ImageView)convertView.findViewById(R.id.ivImage);
            holder.tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
            holder.tvRate = (TextView)convertView.findViewById(R.id.tvRate);
            holder.tvAmount = (TextView)convertView.findViewById(R.id.tvAmount);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvTitle.setText(filtered.get(position).getTitle());
        holder.tvRate.setText(Double.valueOf(filtered.get(position).getRate()).toString());
        holder.tvAmount.setText(filtered.get(position).getAmount());

        String bank = filtered.get(position).getBank();

        switch (bank){
            case "신한":
                holder.ivImage.setImageResource(R.drawable.shinha_logo);
                break;

            case "국민":
                holder.ivImage.setImageResource(R.drawable.kb_logo);
                break;

            case "우리":
                holder.ivImage.setImageResource(R.drawable.woori_logo);
                break;

            case "하나":
                holder.ivImage.setImageResource(R.drawable.hana_logo);
                break;

            case "농협":
                holder.ivImage.setImageResource(R.drawable.nh_logo);
                break;
        }


        return convertView;
    }

    static class ViewHolder {
        ImageView ivImage;
        TextView tvTitle;
        TextView tvRate;
        TextView tvAmount;

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

