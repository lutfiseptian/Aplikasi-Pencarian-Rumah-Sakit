package com.amd.aplikasipencarianrumahsakit.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amd.aplikasipencarianrumahsakit.R
import com.amd.aplikasipencarianrumahsakit.model.rs.noncovid.ModelHospitalNCvd
import com.amd.aplikasipencarianrumahsakit.utils.Constant
import com.amd.aplikasipencarianrumahsakit.view.adapter.HospitalsNCAdapter
import com.amd.aplikasipencarianrumahsakit.viewModel.PrimaryViewModel
import kotlinx.android.synthetic.main.fragment_hospitals.*

class HospitalNCFragment : Fragment() {

    lateinit var primaryViewModel: PrimaryViewModel
    lateinit var hospitalsNCAdapter: HospitalsNCAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hospitals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hospitalsNCAdapter = HospitalsNCAdapter(requireContext())
        rvDaftarRs.setLayoutManager(LinearLayoutManager(context))
        rvDaftarRs.setAdapter(hospitalsNCAdapter)
        rvDaftarRs.setHasFixedSize(true)
        linearNoData.setVisibility(View.GONE)

        //viewmodel
        primaryViewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory()
        ).get(PrimaryViewModel::class.java)
        primaryViewModel.setHospitalsNonCovid(Constant.provinsiId, Constant.kotaId)
        progressBar.setVisibility(View.VISIBLE)
        primaryViewModel.getHospitalsNonCovid().observe(viewLifecycleOwner,{ modelHospital: ArrayList<ModelHospitalNCvd.ModelHospitalNCovid> ->
            if (modelHospital.size != 0) {
                hospitalsNCAdapter.setHospitalAdapter(modelHospital)
            } else {
                progressBar.setVisibility(View.GONE)
                linearNoData.setVisibility(View.VISIBLE)
                rvDaftarRs.setVisibility(View.GONE)
            }
            progressBar.setVisibility(View.GONE)
        })
    }

}