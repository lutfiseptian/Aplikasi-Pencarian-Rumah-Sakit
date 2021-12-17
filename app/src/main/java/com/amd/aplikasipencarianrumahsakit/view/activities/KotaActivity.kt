package com.amd.aplikasipencarianrumahsakit.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amd.aplikasipencarianrumahsakit.R
import com.amd.aplikasipencarianrumahsakit.model.kota.ModelKotaResult
import com.amd.aplikasipencarianrumahsakit.utils.Constant
import com.amd.aplikasipencarianrumahsakit.view.adapter.KotaAdapter
import com.amd.aplikasipencarianrumahsakit.viewModel.PrimaryViewModel
import kotlinx.android.synthetic.main.activity_kota.*

class KotaActivity : AppCompatActivity() {

    lateinit var primaryViewModel: PrimaryViewModel
    lateinit var kotaAdapter: KotaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kota)

        setSupportActionBar(toolbar)
        assert(supportActionBar != null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        tvTitle.setText(Constant.provinsiName)
        linearNoData.setVisibility(View.GONE)

        kotaAdapter = KotaAdapter(this)
        rvDaftarKota.setLayoutManager(LinearLayoutManager(this))
        rvDaftarKota.setAdapter(kotaAdapter)
        rvDaftarKota.setHasFixedSize(true)

        //viewmodel
        primaryViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(PrimaryViewModel::class.java)
        primaryViewModel.setKota(Constant.provinsiId)
        progressBar.setVisibility(View.VISIBLE)
        primaryViewModel.getKota().observe(this, { modelKota: ArrayList<ModelKotaResult.ModelKota> ->
            if (modelKota.size != 0) {
                kotaAdapter.setKotaAdapter(modelKota)
            } else {
                progressBar.setVisibility(View.GONE)
                linearNoData.setVisibility(View.VISIBLE)
                rvDaftarKota.setVisibility(View.GONE)
            }
            progressBar.setVisibility(View.GONE)
        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}