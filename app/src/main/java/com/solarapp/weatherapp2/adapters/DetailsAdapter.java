package com.solarapp.weatherapp2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.solarapp.weatherapp2.models.Weather;
import com.solarapp.weatherapp2.R;

/**
 * Created by vereskun on 16.09.2017.
 */

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {

    private Weather weather;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item, parent, false);

        // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String date = weather.getDailyForecasts()[position].getDate();
        holder.date.setText(date);
        String min_temp = String.valueOf(weather.getDailyForecasts()[position].getTemperature().getMinimum().getValue());
        String unit = weather.getDailyForecasts()[position].getTemperature().getMinimum().getUnit();
        String max_temp = String.valueOf(weather.getDailyForecasts()[position].getTemperature().getMaximum().getValue());
        holder.temperature.setText(min_temp+" - "+max_temp+" "+unit);
        String day_descript = weather.getDailyForecasts()[position].getDay().getIconPhrase();
        holder.tv_day_description.setText(day_descript);
        String night_descript = weather.getDailyForecasts()[position].getNight().getIconPhrase();
        holder.tv_night_description.setText(night_descript);
        int ico_day = weather.getDailyForecasts()[position].getDay().getIcon();
        int ico_night = weather.getDailyForecasts()[position].getNight().getIcon();
        holder.iv_day_ico.setImageResource(getRes(ico_day));
        holder.iv_night_ico.setImageResource(getRes(ico_night));
    }

    @Override
    public int getItemCount() {
        return weather.getDailyForecasts().length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // наш пункт состоит только из одного TextView
        public TextView date;
        public TextView temperature;
        public ImageView iv_day_ico;
        public ImageView iv_night_ico;
        public TextView tv_day_description;
        public TextView tv_night_description;

        public ViewHolder(View v) {
            super(v);
            date = (TextView) v.findViewById(R.id.tv_recycle_item);
            temperature = (TextView) v.findViewById(R.id.tv_temperature_values);
            iv_day_ico = (ImageView) v.findViewById(R.id.iv_day_ico);
            iv_night_ico = (ImageView) v.findViewById(R.id.iv_night_ico);
            tv_day_description = (TextView)v.findViewById(R.id.tv_day_description);
            tv_night_description = (TextView)v.findViewById(R.id.tv_night_description);
        }
    }

    public DetailsAdapter(Weather weather) {
        this.weather = weather;
    }

    private int getRes(int ico){
        switch (ico){
            case 1:
                return R.drawable.i01;
            case 2:
                return R.drawable.i02;
            case 3:
                return R.drawable.i03;
            case 4:
                return R.drawable.i04;
            case 5:
                return R.drawable.i05;
            case 6:
                return R.drawable.i06;
            case 7:
                return R.drawable.i07;
            case 8:
                return R.drawable.i08;
            case 11:
                return R.drawable.i11;
            case 12:
                return R.drawable.i12;
            case 13:
                return R.drawable.i13;
            case 14:
                return R.drawable.i14;
            case 15:
                return R.drawable.i15;
            case 16:
                return R.drawable.i16;
            case 17:
                return R.drawable.i17;
            case 18:
                return R.drawable.i18;
            case 19:
                return R.drawable.i19;
            case 20:
                return R.drawable.i20;
            case 21:
                return R.drawable.i21;
            case 22:
                return R.drawable.i22;
            case 23:
                return R.drawable.i23;
            case 24:
                return R.drawable.i24;
            case 25:
                return R.drawable.i25;
            case 26:
                return R.drawable.i26;
            case 29:
                return R.drawable.i29;
            case 30:
                return R.drawable.i30;
            case 31:
                return R.drawable.i31;
            case 32:
                return R.drawable.i32;
            case 33:
                return R.drawable.i33;
            case 34:
                return R.drawable.i34;
            case 35:
                return R.drawable.i35;
            case 36:
                return R.drawable.i36;
            case 37:
                return R.drawable.i37;
            case 38:
                return R.drawable.i38;
            case 39:
                return R.drawable.i39;
            case 40:
                return R.drawable.i40;
            case 41:
                return R.drawable.i41;
            case 42:
                return R.drawable.i42;
            case 43:
                return R.drawable.i43;
            case 44:
                return R.drawable.i44;
        }
        return 1;
    }


}
