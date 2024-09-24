package com.example.projetaslagi.data.datasource

import android.util.Log
import com.example.projetaslagi.data.entity.CRUDCevap
import com.example.projetaslagi.data.entity.Sepet
import com.example.projetaslagi.data.entity.Yemekler
import com.example.projetaslagi.retrofit.YemeklerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.security.auth.login.LoginException

class YemeklerDataSource(var ydao: YemeklerDao) {




    suspend fun yemekleriYukle() : List<Yemekler> = withContext(Dispatchers.IO){
        return@withContext ydao.yemekleriYukle().yemekler
    }


    suspend fun ekle(yemek_adi:String, yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
        ydao.ekle(yemek_adi, yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
    }



    suspend fun ara(aramaKelimesi:String) : List<Sepet> = withContext(Dispatchers.IO){

       val degis= ydao.ara(aramaKelimesi)
        return@withContext degis?.sepet_yemekler?: emptyList()


    }

    suspend fun sil(sepet_yemek_id:Int,kullanici_adi: String) {
        try {
            ydao.sil(sepet_yemek_id, kullanici_adi)
        }catch (e: Exception){
            Log.e("yemek silme hatasi",e.toString())

        }
    }




}