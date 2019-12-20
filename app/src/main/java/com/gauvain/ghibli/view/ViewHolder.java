package com.gauvain.ghibli.view;


import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bastou.ghibli.R;


public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView text_field;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        text_field = itemView.findViewById(R.id.text_item);
    }

    public void setOnClickListener(View.OnClickListener clickListener){
        this.itemView.setOnClickListener(clickListener);
    }

}
