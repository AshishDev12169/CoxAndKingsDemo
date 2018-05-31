package com.example.ashish14060.coxandkingsdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashish14060.coxandkingsdemo.R;
import com.example.ashish14060.coxandkingsdemo.binding_model.MainActivityUiModel;

import java.util.List;

/**
 * Created by Ashish14060 on 5/30/2018.
 */


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

        private List<MainActivityUiModel> countryList;

        /**
         * View holder class
         * */
        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView countryText;
            public ImageView popText;

            public MyViewHolder(View view) {
                super(view);
                countryText = (TextView) view.findViewById(R.id.textView);
                popText = (ImageView) view.findViewById(R.id.imageView);
            }
        }

        public Adapter(List<MainActivityUiModel> countryList) {
            this.countryList = countryList;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            MainActivityUiModel c = countryList.get(position);
            holder.countryText.setText(c.getFeatureName());
            holder.popText.setImageResource(c.getIcon());
        }

        @Override
        public int getItemCount() {
            return countryList.size();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.grid_layout,parent, false);
            return new MyViewHolder(v);
        }
}
