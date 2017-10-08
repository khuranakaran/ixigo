package com.neuron.ixigo.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.neuron.ixigo.R;
import com.neuron.ixigo.activities.ShowFlightDataActivity;
import com.neuron.ixigo.models.FlightSearch;
import com.neuron.ixigo.utils.NotificationUtils;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;

/**
 * Created by Karan.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.MyViewHolder> {
    private Context ctx;
    private Intent intent;
    private FlightSearch result;
    private Gson gson;

    public SearchResultAdapter(Context ctx, FlightSearch result) {
        Log.e("SIZE", result.getFlights().size()+"Hello");
        this.ctx = ctx;
        this.result = result;
        gson = new Gson();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_show_flights, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tvFlightPrice.setText("₹ " + result.getFlights().get(position).getFares().get(0).getFare());
        holder.tvFlightTime.setText(NotificationUtils.timeStampConversion
                (result.getFlights().get(position).getDepartureTime())
                + " - " + NotificationUtils.timeStampConversion(result.getFlights().get(position).getArrivalTime()));

        holder.tvFlightDuration.setText(NotificationUtils.duration(result.getFlights().get(position).getDepartureTime(), result.getFlights().get(position).getArrivalTime()));

        Picasso.with(ctx).load(NotificationUtils.flightLogos(result.getFlights().get(position).getAirlineCode())).into(holder.ivFlightLogo);
        holder.tvFlightName.setText(result.getFlights().get(position).getAirlineCode());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ListOfFlightModel = gson.toJson(result.getFlights().get(position));
                Log.e("FLightData", ListOfFlightModel);

                intent = new Intent(ctx, ShowFlightDataActivity.class);
                JSONArray array = new JSONArray(result.getFlights().get(position).getFares());

                Log.e("SIZE", ""+result.getFlights().get(position).getFares().size());

                if (result.getFlights().get(position).getFares().size() == 1){
                    intent.putExtra("providerId1", result.getFlights().get(position).getFares().get(0).getProviderId());
                    intent.putExtra("price1", result.getFlights().get(position).getFares().get(0).getFare());
                }

                if (result.getFlights().get(position).getFares().size() == 2){
                    intent.putExtra("providerId1", result.getFlights().get(position).getFares().get(0).getProviderId());
                    intent.putExtra("price1", result.getFlights().get(position).getFares().get(0).getFare());
                    intent.putExtra("providerId2", result.getFlights().get(position).getFares().get(1).getProviderId());

                    intent.putExtra("price2", result.getFlights().get(position).getFares().get(1).getFare());
                }



                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.getFlights().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvFlightName, tvFlightPrice, tvFlightTime, tvFlightDuration;
        ImageView ivFlightLogo;

        MyViewHolder(View itemView) {
            super(itemView);
            tvFlightPrice = (TextView) itemView.findViewById(R.id.tv_flight_price);
            tvFlightTime = (TextView) itemView.findViewById(R.id.tv_flight_time);
            tvFlightDuration = (TextView) itemView.findViewById(R.id.tv_flight_duration);
            tvFlightName = (TextView) itemView.findViewById(R.id.tv_flight_name);
            ivFlightLogo = (ImageView) itemView.findViewById(R.id.iv_flight_logo);
        }
    }
}

