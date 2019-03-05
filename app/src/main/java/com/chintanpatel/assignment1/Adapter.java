package com.chintanpatel.assignment1;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Holder> {
    private List<GeneralMotors> vehicles;
    private Context context;

    public Adapter(Context context, List<GeneralMotors> vehicles) {
        this.context = context;
        this.vehicles = vehicles;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.list_item,
                parent,
                false);

        return new Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        GeneralMotors vehicle = vehicles.get(position);
        holder.binding.setVehicles(vehicle);
    }

    @Override
    public int getItemCount() {
        return vehicles.size();
    }
}
