package com.neuron.ixigo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.VolleyError;
import com.neuron.ixigo.R;
import com.neuron.ixigo.adapters.SearchResultAdapter;
import com.neuron.ixigo.models.FlightSearch;
import com.neuron.ixigo.utils.IxigoSingleton;
import com.neuron.ixigo.volley.RequestCallback;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.neuron.ixigo.utils.Constants.API_FLIGHT_SEARCH;

public class SearchResultsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    SearchResultAdapter adapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("DEL" + " - " + "BOM");
        toolbar.setSubtitle(new SimpleDateFormat("MMM dd").format(new Date()) + " | " + "1 Traveller");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        progressBar = (ProgressBar) findViewById(R.id.progressbar);


        IxigoSingleton.restClient.getFlightSearch(API_FLIGHT_SEARCH, new RequestCallback<FlightSearch>() {
            @Override
            public void onSuccessRestResponse(Exception e, FlightSearch result) {
                adapter = new SearchResultAdapter(SearchResultsActivity.this, result);
                recyclerView.setAdapter(adapter);

                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

            }

            @Override
            public void onErrorRestResponse(VolleyError error) {
            }

            @Override
            public void onResponse(FlightSearch response) {
            }
        }, null);
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
