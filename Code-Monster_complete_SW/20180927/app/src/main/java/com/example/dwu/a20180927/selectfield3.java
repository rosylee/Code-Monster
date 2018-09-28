package com.example.dwu.a20180927;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.dwu.a20180927.Account.AccountActivityv;
import com.example.dwu.a20180927.Card.CardActivityv;
import com.example.dwu.a20180927.Certification.CertificationActivityv;
import com.example.dwu.a20180927.Investment.InvestmentActivityv;
import com.example.dwu.a20180927.Loans.LoanActivityv;
import com.example.dwu.a20180927.Search.Search;
import com.example.dwu.a20180927.Tax.TaxActivityv;
import com.example.dwu.management.R;

public class selectfield3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectfield3);
        ImageView search = (ImageView)findViewById(R.id.searchimage);
        //EditText editText = (EditText)findViewById(R.id.editSearch);
        ImageView button = (ImageView) findViewById(R.id.button);
        ImageView button2 = (ImageView) findViewById(R.id.button2);
        ImageView button3 = (ImageView) findViewById(R.id.button3);
        ImageView button5 = (ImageView) findViewById(R.id.button5);
        ImageView button6 = (ImageView) findViewById(R.id.button6);
        ImageView button7 = (ImageView) findViewById(R.id.button7);
        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentToSearch =new Intent(selectfield3.this, Search.class);
                selectfield3.this.startActivity(intentToSearch);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accountIntent = new Intent(selectfield3.this, AccountActivityv.class);
                selectfield3.this.startActivity(accountIntent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loans = new Intent(selectfield3.this, LoanActivityv.class);
                selectfield3.this.startActivity(loans);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent card = new Intent(selectfield3.this, CardActivityv.class);
                selectfield3.this.startActivity(card);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent certification = new Intent(selectfield3.this, CertificationActivityv.class);
                selectfield3.this.startActivity(certification);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent investment = new Intent(selectfield3.this, InvestmentActivityv.class);
                selectfield3.this.startActivity(investment);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tax = new Intent(selectfield3.this, TaxActivityv.class);
                selectfield3.this.startActivity(tax);
            }
        });


    }
}
