package com.place.finder;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kakao.util.helper.Utility;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchDialog extends DialogFragment
        implements
            MaterialSearchView.OnQueryTextListener,
            AdapterView.OnItemClickListener{

    private MaterialSearchView searchView;
    private Toolbar toolbar;
    private BankCallbackListener listener;

    public void setBankCallbackListener(BankCallbackListener bankCallbackListener) {
        this.listener = bankCallbackListener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        this.listener = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.item);

        searchView = view.findViewById(R.id.search_view);
        searchView.setSubmitOnClick(true);
        searchView.setOnQueryTextListener(this);
        searchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "onItemClick", Toast.LENGTH_SHORT).show();
            }
        });

        searchView.setSuggestions(
                new String[]{
                  "국민은행 신사중앙지점"
                , "국민은행 런던지점"
                , "국민은행 도쿄점"
                , "우리은행 신사동지점"
                , "우리은행 강남갤러리지점" });


        MenuItem menuItem = toolbar.getMenu().findItem(R.id.action_search);
        searchView.setMenuItem(menuItem);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissDialog();
            }
        });
    }

    private void dismissDialog() {
        this.dismiss();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listener.onStartBank(query, query);
        dismiss();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("onItemClick", "onItemClick");
        Toast.makeText(view.getContext(), "onItemClick", Toast.LENGTH_SHORT).show();
    }
}
