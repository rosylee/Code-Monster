package com.example.dwu.a20180927;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.dwu.management.R;

import java.util.ArrayList;

public class hr_PointAdapter extends RecyclerView.Adapter<hr_PointHolder> {
    public ArrayList<hr_Point> list = new ArrayList<>();
    private double latitude = 37.517400f;
    private double longitude = 127.021924f;

    public hr_PointAdapter() {
        list = getMapPoint();
    }
    @NonNull
    @Override
    public hr_PointHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new hr_PointHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hr_holder_point, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull hr_PointHolder holder, int position) {
        holder.set(latitude, longitude, list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setPoint(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        notifyDataSetChanged();
    }

    private ArrayList<hr_Point> getMapPoint() {
        ArrayList<hr_Point> list = new ArrayList<>();

        list.add(getPoint("맥도날드", 37.5147400f, 127.021924f));
        list.add(getPoint("가로수길", 37.519446f, 127.023126f));
        list.add(getPoint("아오리의 행방불명", 37.519059f, 127.023776f));
        list.add(getPoint("키친랩 가로수길점", 37.521601f, 127.021769f));
        list.add(getPoint("C27 가로수길점", 37.520711f, 127.023231f));

        return list;
    }

    private hr_Point getPoint(String name, double latitude, double longitude){
        hr_Point p = new hr_Point();
        p.name = name;
        p.latitude = latitude;
        p.longtitude = longitude;

        return p;
    }
}
