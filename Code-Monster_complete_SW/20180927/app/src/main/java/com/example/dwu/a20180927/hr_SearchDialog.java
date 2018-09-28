package com.example.dwu.a20180927;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.dwu.management.R;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class hr_SearchDialog extends DialogFragment
        implements
            MaterialSearchView.OnQueryTextListener,
            AdapterView.OnItemClickListener{

    private MaterialSearchView searchView;
    private Toolbar toolbar;
    private hr_BankCallbackListener listener;

    public void setBankCallbackListener(hr_BankCallbackListener hrBankCallbackListener) {
        this.listener = hrBankCallbackListener;
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
        return inflater.inflate(R.layout.hr_fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.hr_item);

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
                        "국민은행 도쿄지점(Tokyo Branch)"
                        , "국민은행 런던지점(London Branch)"
                        , "국민은행 오클랜드지점 (Auckland Branch Branch)"
                        , "국민은행 호치민지점 (Ho Chi Minh City Branch )"
                        , "국민은행 홍콩지점 (Hong Kong Branch )"

                        , "우리은행 상하이지점 (Shanghi Branch)"
                        , "우리은행 시드니지점 (Sydney Branch)"
                        , "우리은행 방글라데시지점 (BANGLADESH - DHAKA Branch)"
                        , "우리은행 바레인지점 (Bahrain Branch)"
                        , "우리은행 오중로지점 (Cambodia Branch)"
                        , "우리은행 홍콩지점 (Hong kong Branch)"
                        , "우리은행 이란지점 (Iran Branch)"
                        , "우리은행 첸나이지점 (CHENNAI Branch,India)"
                        , "우리은행 하노이지점 (Hanoi Branch) "
                        , "우리은행 싱가폴지점 (Singapore Branch) "
                        , "우리은행 두바이지점 (Dubai Branch) "
                        , "우리은행 런던지점 (London Branch) "
                        , "우리은행 도쿄지점 (Tokyo Branch) "
                        , "우리은행 뉴욕지점 (New York Branch) "

                        , "농협은행 뉴욕지점 (New York Branch)  "
                        , "농협은행 바레인지점(BAHRAIN Branch) "

                        , "하나은행 아부다비지점(Abu Dhabi Branch) "
                        , "하나은행 두바이지점(Dubai Branch) "
                        , "하나은행 바레인지점(Bahrain Branch) "
                        , "하나은행 시드니지점(Sydney Branch) "
                        , "하나은행 파리지점(Paris Branch)"
                        , "하나은행 토론토 지점(Toronto Branch)"
                        , "하나은행 암스텔담지점(Toronto Branch)"
                        , "하나은행 독일지점(Germany Branch)"
                        , "하나은행 홍콩지점(Hong Kong Branch)"
                        , "하나은행 첸나이지점(Chennai Branch)"
                        , "하나은행 인도네시아 본점(Indonesia Branch)"
                        , "하나은행 도쿄지점(Tokyo Branch)"
                        , "하나은행 오사카지점(Osaka Branch)"
                        , "하나은행 하노이지점(Hanoi Branch)"
                        , "하나은행 마닐라지점(Osaka Branch)"
                        , "하나은행 호치민지점(Ho Chi Minh City Branch)"
                        , "하나은행 뉴욕지점 (New York Branch)"
                        , "하나은행 런던지점(London Branch)"

                        , "기업은행 마닐라지점(Manila Branch)"
                        , "기업은행 뉴욕지점(New York Branch)"
                        , "기업은행 도쿄지점(Tokyo Branch)"
                        , "기업은행 홍콩지점(Hong Kong Branch)"
                        , "기업은행 런던지점(London Branch)"
                        , "기업은행 호치민지점(Ho Chi Minh City Branch)"
                        , "기업은행 하노이지점(Hanoi Branch)"
                        , "기업은행 뉴델리지점(New Delhi Branch)"
                        , "기업은행 베이징분행(Beijing Branch)"
                        , "기업은행 텐진분행(Tianjin Branch)"
                        , "기업은행 칭다오분행(Qingdao Branch)"
                });


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
