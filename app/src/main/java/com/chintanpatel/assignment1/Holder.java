package com.chintanpatel.assignment1;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.chintanpatel.assignment1.databinding.ListItemBinding;

public class Holder extends RecyclerView.ViewHolder{
    public ListItemBinding binding;

    public Holder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }
}
