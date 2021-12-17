package com.amd.aplikasipencarianrumahsakit.model.kota

import com.google.gson.annotations.SerializedName

class ModelKotaResult {
    @SerializedName("cities")
    lateinit var cities: List<ModelKota>

    inner class ModelKota  {
        @SerializedName("id")
        lateinit var id: String

        @SerializedName("name")
        lateinit var name: String
    }

}