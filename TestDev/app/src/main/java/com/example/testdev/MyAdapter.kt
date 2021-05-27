package com.example.testdev

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.view.*

class MyAdapter(private val massageModelList: MutableList<MassageModel>) :
    RecyclerView.Adapter<MyAdapter.MassageViewHolder>() {

    class MassageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): MassageViewHolder {
        return MassageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        )

    }

    override fun onBindViewHolder(holder: MassageViewHolder, position: Int) {
        val tempCount = massageModelList[position]
        holder.itemView.apply {
            im_service_icon.setImageResource(tempCount.image)
            tv_service_name.text = tempCount.appName
            tv_setvice_msg.text = tempCount.userName
            tv_time_massage.text=tempCount.timeMassage
            tv_data_massage.text=tempCount.dateMassage

        }


    }

    override fun getItemCount() = massageModelList.size

}


