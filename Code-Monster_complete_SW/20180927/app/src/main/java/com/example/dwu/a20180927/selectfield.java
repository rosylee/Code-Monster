package com.example.dwu.a20180927;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import com.example.dwu.management.R;
import com.example.dwu.a20180927.Account.AccountActivity;
import com.example.dwu.a20180927.Card.CardActivity;
import com.example.dwu.a20180927.Certification.CertificationActivity;
import com.example.dwu.a20180927.Investment.InvestmentActivity;
import com.example.dwu.a20180927.Loans.LoanActivity;

import com.example.dwu.a20180927.Search.Search;
import com.example.dwu.a20180927.Tax.TaxActivity;

public class selectfield extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectfield);
        ImageView search = (ImageView)findViewById(R.id.searchimage);
        ImageView button = (ImageView) findViewById(R.id.button);
        ImageView button2 = (ImageView) findViewById(R.id.button2);
        ImageView button3 = (ImageView) findViewById(R.id.button3);
        ImageView button5 = (ImageView) findViewById(R.id.button5);
        ImageView button6 = (ImageView) findViewById(R.id.button6);
        ImageView button7 = (ImageView) findViewById(R.id.button7);
        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentToSearch =new Intent(selectfield.this, Search.class);
                selectfield.this.startActivity(intentToSearch);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accountIntent = new Intent(selectfield.this, AccountActivity.class);
                selectfield.this.startActivity(accountIntent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loans = new Intent(selectfield.this, LoanActivity.class);
                selectfield.this.startActivity(loans);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent card = new Intent(selectfield.this, CardActivity.class);
                selectfield.this.startActivity(card);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent certification = new Intent(selectfield.this, CertificationActivity.class);
                selectfield.this.startActivity(certification);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent investment = new Intent(selectfield.this, InvestmentActivity.class);
                selectfield.this.startActivity(investment);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tax = new Intent(selectfield.this, TaxActivity.class);
                selectfield.this.startActivity(tax);
            }
        });

    }
}
