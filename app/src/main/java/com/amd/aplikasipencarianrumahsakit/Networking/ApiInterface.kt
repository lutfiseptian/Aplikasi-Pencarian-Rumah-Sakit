package com.amd.aplikasipencarianrumahsakit.Networking

import com.amd.aplikasipencarianrumahsakit.model.detail.ModelDetailResult
import com.amd.aplikasipencarianrumahsakit.model.detail.ModelLocationResult
import com.amd.aplikasipencarianrumahsakit.model.kota.ModelKotaResult
import com.amd.aplikasipencarianrumahsakit.model.provinsi.ModelProvinsiResult
import com.amd.aplikasipencarianrumahsakit.model.rs.covid.ModelHospitalCvd
import com.amd.aplikasipencarianrumahsakit.model.rs.noncovid.ModelHospitalNCvd
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("get-provinces")
    fun getListProvinces() : Call<ModelProvinsiResult>

    @GET("get-cities?")
    fun getListCity(@Query("provinceid") provinceid: String
    ): Call<ModelKotaResult>

    @GET("get-hospitals?")
    fun getListHospitalsCovid(
        @Query("provinceid") provinceid: String,
        @Query("cityid") cityid: String,
        @Query("type") type: String
    ): Call<ModelHospitalCvd>

    @GET("get-hospitals?")
    fun getListHospitalsNonCovid(
        @Query("provinceid") provinceid: String,
        @Query("cityid") cityid: String,
        @Query("type") type: String
    ): Call<ModelHospitalNCvd>

    @GET("get-bed-detail?")
    fun getListDetails(
        @Query("hospitalid") hospitalid: String,
        @Query("type") type: String
    ): Call<ModelDetailResult>

    @GET("get-hospital-map?")
    fun getMapLocation(
        @Query("hospitalid") hospitalid: String
    ): Call<ModelLocationResult>

}