package com.amd.aplikasipencarianrumahsakit.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.fragment.app.FragmentStatePagerAdapter
import com.amd.aplikasipencarianrumahsakit.view.fragment.HospitalCFragment
import com.amd.aplikasipencarianrumahsakit.view.fragment.HospitalNCFragment


class HospitalsPagerAdapter(fragmentManager: FragmentManager)
    : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = HospitalCFragment()
            1 -> fragment = HospitalNCFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        var strTitleTabs = ""
        when (position) {
            0 -> strTitleTabs = "Covid-19"
            1 -> strTitleTabs = "Non Covid-19"
        }
        return strTitleTabs
    }
}