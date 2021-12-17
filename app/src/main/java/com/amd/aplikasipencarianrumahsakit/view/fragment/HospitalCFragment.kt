package com.amd.aplikasipencarianrumahsakit.view.fragment

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amd.aplikasipencarianrumahsakit.R
import com.amd.aplikasipencarianrumahsakit.model.rs.covid.ModelHospitalCvd
import com.amd.aplikasipencarianrumahsakit.utils.Constant
import com.amd.aplikasipencarianrumahsakit.view.adapter.HospitalsCAdapter
import com.amd.aplikasipencarianrumahsakit.viewModel.PrimaryViewModel
import kotlinx.android.synthetic.main.fragment_hospitals.*

class HospitalCFragment : Fragment() {

    lateinit var primaryViewModel: PrimaryViewModel
    lateinit var hospitalsCAdapter: HospitalsCAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hospitals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hospitalsCAdapter = HospitalsCAdapter(requireContext())
        rvDaftarRs.setLayoutManager(LinearLayoutManager(context))
        rvDaftarRs.setAdapter(hospitalsCAdapter)
        rvDaftarRs.setHasFixedSize(true)
        linearNoData.setVisibility(View.GONE)

        //viewmodel
        primaryViewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory()
        ).get(PrimaryViewModel::class.java)
        primaryViewModel.setHospitalsCovid(Constant.provinsiId, Constant.kotaId)
        progressBar.setVisibility(View.VISIBLE)
        primaryViewModel.getHospitalsCovid().observe(viewLifecycleOwner,{ modelHospital: ArrayList<ModelHospitalCvd.ModelHospitalC> ->
            if (modelHospital.size != 0) {
                hospitalsCAdapter.setHospitalAdapter(modelHospital)
            } else {
                progressBar.setVisibility(View.GONE)
                linearNoData.setVisibility(View.VISIBLE)
                rvDaftarRs.setVisibility(View.GONE)
            }
            progressBar.setVisibility(View.GONE)
        })
    }

}