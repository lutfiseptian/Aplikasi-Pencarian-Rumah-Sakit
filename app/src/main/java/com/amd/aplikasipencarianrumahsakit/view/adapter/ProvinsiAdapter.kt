package com.amd.aplikasipencarianrumahsakit.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.amd.aplikasipencarianrumahsakit.R
import com.amd.aplikasipencarianrumahsakit.model.provinsi.ModelProvinsiResult
import com.amd.aplikasipencarianrumahsakit.utils.Constant
import com.amd.aplikasipencarianrumahsakit.view.activities.KotaActivity
import kotlinx.android.synthetic.main.list_item_provinsi.view.*

class ProvinsiAdapter(private val context: Context) :
    RecyclerView.Adapter<ProvinsiAdapter.ProvinsiViewHolder>() {

    private val modelProvinsiArrayList = ArrayList<ModelProvinsiResult.ModelProvinsi>()

    fun setProvinsiAdapter(items: ArrayList<ModelProvinsiResult.ModelProvinsi>) {
        modelProvinsiArrayList.clear()
        modelProvinsiArrayList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinsiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_provinsi, parent, false)
        return ProvinsiViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinsiViewHolder, position: Int) {

        //set data to share & intent
        holder.tvProvinsi.text = modelProvinsiArrayList[position].name

        holder.cvDaftarProvinsi.setOnClickListener {
            Constant.provinsiId = modelProvinsiArrayList[position].id
            Constant.provinsiName = modelProvinsiArrayList[position].name
            val intent = Intent(context, KotaActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return modelProvinsiArrayList.size
    }

    class ProvinsiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cvDaftarProvinsi: CardView
        var tvProvinsi: TextView

        init {
            cvDaftarProvinsi = itemView.cvDaftarProvinsi
            tvProvinsi = itemView.tvProvinsi
        }
    }

}