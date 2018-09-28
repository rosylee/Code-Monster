package com.example.dwu.a20180927.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.dwu.management.R;

import java.util.ArrayList;


public class CustomerAdapter extends ArrayAdapter<Customer> {
    ArrayList<Customer> customers, tempCustomer, suggestions;

    public CustomerAdapter(Context context, ArrayList<Customer> objects) {
        super(context, R.layout.customer_row, R.id.tvCustomer, objects);
        this.customers = objects;
        this.tempCustomer = new ArrayList<Customer>(objects);
        this.suggestions = new ArrayList<Customer>(objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    private View initView(int position, View convertView, ViewGroup parent) {
        Customer customer = getItem(position);

        if (convertView == null) {
            if (parent == null)
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.customer_row, null);
            else
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.customer_row, parent, false);
        }
        TextView txtCustomer = (TextView) convertView.findViewById(R.id.tvCustomer);


        ImageView ivCustomerImage = (ImageView) convertView.findViewById(R.id.ivCustomerImage);
        if (txtCustomer != null)
            txtCustomer.setText(customer.getTerm() + " ");


        if (ivCustomerImage != null)
            ivCustomerImage.setImageResource(customer.getProfilePic());

        // Now assign alternate color for rows
       // if (position % 2 == 0)
            //convertView.setBackgroundColor(getContext().getColor(R.color.odd));
       // else
            //convertView.setBackgroundColor(getContext().getColor(R.color.even));
        ivCustomerImage.setImageResource(customer.getProfilePic());

        convertView.setTag(customer.getId());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }
    Filter myFilter =new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            Customer customer =(Customer)resultValue ;
            return customer.getTerm() + " " ;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if (constraint != null) {
                suggestions.clear();
                for (Customer cust : tempCustomer) {
                    if (cust.getTerm().toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                        suggestions.add(cust);
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ArrayList<Customer> c =  (ArrayList<Customer> )results.values ;
            if (results != null && results.count > 0) {
                clear();
                for (Customer cust : c) {
                    add(cust);
                    notifyDataSetChanged();
                }
            }
            else{
                clear();
                notifyDataSetChanged();
            }
        }
    };
}
