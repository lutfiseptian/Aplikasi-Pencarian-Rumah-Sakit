package com.amd.aplikasipencarianrumahsakit.model.rs.noncovid

import com.google.gson.annotations.SerializedName

class ModelHospitalNCvd {
    @SerializedName("hospitals")
    lateinit var hospitals: List<ModelHospitalNCovid>

    inner class ModelHospitalNCovid  {
        @SerializedName("id")
        lateinit var id: String

        @SerializedName("name")
        lateinit var name: String

        @SerializedName("address")
        lateinit var address: String

        @SerializedName("phone")
        lateinit var phone: String

        @SerializedName("info")
        lateinit var info: String
    }
}