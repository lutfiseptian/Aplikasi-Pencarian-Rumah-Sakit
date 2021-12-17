package com.amd.aplikasipencarianrumahsakit.model.provinsi

import com.google.gson.annotations.SerializedName

class ModelProvinsiResult {
    @SerializedName("provinces")
    lateinit var provinces: List<ModelProvinsi>

    inner class ModelProvinsi  {
        @SerializedName("id")
        lateinit var id: String

        @SerializedName("name")
        lateinit var name: String
    }

}