package com.amd.aplikasipencarianrumahsakit.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amd.aplikasipencarianrumahsakit.R
import com.amd.aplikasipencarianrumahsakit.model.detail.ModelDetailResult
import com.amd.aplikasipencarianrumahsakit.utils.Constant
import com.amd.aplikasipencarianrumahsakit.view.adapter.DetailAdapter
import com.amd.aplikasipencarianrumahsakit.viewModel.PrimaryViewModel
import kotlinx.android.synthetic.main.fragment_hospitals.*
import java.util.Observer


class DetailNCFragment : Fragment() {

    lateinit var primaryViewModel: PrimaryViewModel
    lateinit var detailAdapter: DetailAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hospitals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailAdapter = DetailAdapter()
        rvDaftarRs.setLayoutManager(LinearLayoutManager(context))
        rvDaftarRs.setAdapter(detailAdapter)
        rvDaftarRs.setHasFixedSize(true)
        linearNoData.setVisibility(View.GONE)

        //viewmodel
        primaryViewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory()
        ).get(PrimaryViewModel::class.java)
        primaryViewModel.setDetailsCovid(Constant.hospitalId)
        progressBar.setVisibility(View.VISIBLE)
        primaryViewModel.getDetailsCovid().observe(viewLifecycleOwner,{ modelHospital: ArrayList<ModelDetailResult.ModelData.BedDetail> ->
            if (modelHospital.size != 0) {
                detailAdapter.setDetailAdapter(modelHospital)
            } else {
                progressBar.setVisibility(View.GONE)
                linearNoData.setVisibility(View.VISIBLE)
                rvDaftarRs.setVisibility(View.GONE)
            }
            progressBar.setVisibility(View.GONE)
        })
    }

}