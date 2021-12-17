package com.amd.aplikasipencarianrumahsakit.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.amd.aplikasipencarianrumahsakit.R
import com.amd.aplikasipencarianrumahsakit.utils.Constant
import com.amd.aplikasipencarianrumahsakit.view.adapter.HospitalsPagerAdapter
import kotlinx.android.synthetic.main.activity_hospitals.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.toolbar

class HospitalsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospitals)

        setSupportActionBar(toolbar)
        assert(supportActionBar != null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        tvTitle.setText(Constant.kotaName)

        viewPager.setAdapter(HospitalsPagerAdapter(supportFragmentManager))
        viewPager.setOffscreenPageLimit(2)
        tabsLayout.setupWithViewPager(viewPager)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}