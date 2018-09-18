package com.example.calendartest_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TaxSelectActivity extends AppCompatActivity {
    final int ADD_CODE = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_select);
    }

    public void onClick(View v){
        Intent intent_taxAdd = new Intent(TaxSelectActivity.this, TaxAddActivity.class);

        switch (v.getId()){
            case R.id.btn_sel_for:
                intent_taxAdd.putExtra("name", "foreign");
                startActivityForResult(intent_taxAdd, ADD_CODE);


                break;

            case R.id.btn_sel_war:
                intent_taxAdd.putExtra("name", "warter");
                startActivityForResult(intent_taxAdd, ADD_CODE);

                break;

            case R.id.btn_sel_gas:
                intent_taxAdd.putExtra("name", "gas");
                startActivityForResult(intent_taxAdd, ADD_CODE);

                break;

            case R.id.btn_sel_ele:
                intent_taxAdd.putExtra("name", "electric");
                startActivityForResult(intent_taxAdd, ADD_CODE);

                break;

            case R.id.btn_sel_can:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ADD_CODE){
            switch (resultCode){
                case RESULT_OK:
                    setResult(RESULT_OK, null);
                    finish();
                    break;
                case RESULT_CANCELED:
                    setResult(RESULT_CANCELED);
                    break;
            }
        }
    }
}
