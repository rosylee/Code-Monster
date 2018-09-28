package com.example.dwu.a20180927;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dwu.management.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FullBottomSheetDialogFragment extends BottomSheetDialogFragment implements OnMapReadyCallback {

    private BottomSheetBehavior mBehavior;
    private final String MAP_VIEW_BUNDLE_KEY = "AIzaSyDsnkDV1m_rOxepb30GhSwk-MHOHYbz49g";
    private RecyclerView recyclerView;
    private View view;
    private hr_PointAdapter adapter;
    private Bank bank;
    private MapView mapView;



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle b = getArguments();
        if(b != null) {
            bank = (Bank) b.getSerializable("Bank");
        }

        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        view = View.inflate(getContext(), R.layout.hr_sheet, null);
        dialog.setContentView(view);


        mBehavior = BottomSheetBehavior.from((View) view.getParent());

        TextView title = view.findViewById(R.id.place_title);
        TextView subTitle = view.findViewById(R.id.place_sub_title);
        TextView address = view.findViewById(R.id.place_address);
        TextView oldAddress = view.findViewById(R.id.place_time);
        TextView phone = view.findViewById(R.id.place_phone);
        TextView site = view.findViewById(R.id.place_site);
        ImageView image = view.findViewById(R.id.logo_image);
        ImageView main = view.findViewById(R.id.main_image);

        switch (bank.bankName) {
            case "국민은행":
                main.setImageDrawable(getResources().getDrawable(R.drawable.kb_main));
                image.setImageDrawable(getResources().getDrawable(R.drawable.kb));
                break;
            case "우리은행":
                main.setImageDrawable(getResources().getDrawable(R.drawable.woori_main));
                image.setImageDrawable(getResources().getDrawable(R.drawable.woori));
                break;
            case "하나은행":
                main.setImageDrawable(getResources().getDrawable(R.drawable.hana_main));
                image.setImageDrawable(getResources().getDrawable(R.drawable.hana));
            case "농협은행":
                main.setImageDrawable(getResources().getDrawable(R.drawable.nh_main));
                image.setImageDrawable(getResources().getDrawable(R.drawable.nh));
            case "기업은행":
                main.setImageDrawable(getResources().getDrawable(R.drawable.ibk_main));
                image.setImageDrawable(getResources().getDrawable(R.drawable.ibk));
                break;
        }

        title.setText(bank.name);
        subTitle.setText(bank.bankName);
        address.setText(bank.Address);
        oldAddress.setText(bank.Businesshours);
        phone.setText(bank.phone);
        site.setText(bank.site);

        mapView = view.findViewById(R.id.google_map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        MapsInitializer.initialize(view.getContext());

        return dialog;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapViewBundle);
        }

        mapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    public void setLocation(double latitude, double longitude) {
        adapter.setPoint(latitude, longitude);
    }

    @Override
    public void onStart() {
        super.onStart();
        view.post(new Runnable() {
            @Override
            public void run() {
                //LinearLayout l = view.findViewById(R.id.station_preview_info);
                mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                //mBehavior.setPeekHeight(100);
            }
        });
    }

    private LatLng getLatLng(String title, double latitude, double longitude) {
        LatLng l = new LatLng(latitude, longitude);

        MarkerOptions m = new MarkerOptions();
        m.position(l);
        m.title(title);

        return l;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d("맵레디", "맵레디");

        LatLng POSITION = new LatLng(bank.gX, bank.gY);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(POSITION);
        markerOptions.title(bank.name);

        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(POSITION, 17f));

    }

    }


