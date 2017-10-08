package com.neuron.ixigo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.neuron.ixigo.R;
import com.neuron.ixigo.utils.NotificationUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Karan.
 */

public class ShowFlightDataActivity extends AppCompatActivity {

    TextView tvProviderName1, tvProviderName2, tvPrice1, tvPrice2, btnBook;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_data);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("DEL" + " - " + "BOM");
        toolbar.setSubtitle(new SimpleDateFormat("MMM dd").format(new Date()) + " | " + "1 Traveller");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvProviderName1 = (TextView) findViewById(R.id.tv_provider_id1);
        tvProviderName2 = (TextView) findViewById(R.id.tv_provider_id2);
        tvPrice1 = (TextView) findViewById(R.id.tv_price1);
        tvPrice2 = (TextView) findViewById(R.id.tv_price2);
        btnBook = (TextView) findViewById(R.id.btn_book2);
        view = findViewById(R.id.view);


        if (getIntent().getExtras() != null) {
            int providerId1 = getIntent().getExtras().getInt("providerId1");
            int price1 = getIntent().getExtras().getInt("price1");
            tvPrice1.setText(String.valueOf(price1));
            tvProviderName1.setText(NotificationUtils.providerNames(providerId1));
            view.setVisibility(View.GONE);

            if (getIntent().getExtras().getInt("providerId2") != 0){
                tvProviderName2.setVisibility(View.VISIBLE);
                tvPrice2.setVisibility(View.VISIBLE);
                btnBook.setVisibility(View.VISIBLE);
                view.setVisibility(View.VISIBLE);
                int providerId2 = getIntent().getExtras().getInt("providerId2");
                int price2 = getIntent().getExtras().getInt("price2");
                tvPrice2.setText(String.valueOf(price2));
                tvProviderName2.setText(NotificationUtils.providerNames(providerId2));
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
