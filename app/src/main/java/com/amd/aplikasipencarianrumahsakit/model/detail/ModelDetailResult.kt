package com.amd.aplikasipencarianrumahsakit.model.detail

import com.google.gson.annotations.SerializedName

class ModelDetailResult {
    @SerializedName("data")
    lateinit var data: ModelData

    inner class ModelData  {
        @SerializedName("id")
        lateinit var id: String

        @SerializedName("name")
        lateinit var name: String

        @SerializedName("address")
        lateinit var address: String

        @SerializedName("phone")
        lateinit var phone: String

        @SerializedName("bedDetail")
        lateinit var bedDetail: List<BedDetail>

        inner class BedDetail {
            @SerializedName("time")
            lateinit var time: String

            @SerializedName("stats")
            lateinit var stats: ModelStats

            inner class ModelStats {
                @SerializedName("title")
                lateinit var title: String

                @SerializedName("bed_available")
                lateinit var bedAvailable: String

                @SerializedName("bed_empty")
                lateinit var bedEmpty: String

                @SerializedName("queue")
                lateinit var queue: String
            }
        }

    }

}