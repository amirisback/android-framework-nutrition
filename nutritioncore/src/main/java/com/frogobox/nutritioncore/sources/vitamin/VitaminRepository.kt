package com.frogobox.nutritioncore.sources.vitamin

import com.frogobox.nutritioncore.core.NutriApiCallback
import com.frogobox.nutritioncore.core.NutriApiClient
import com.frogobox.nutritioncore.core.NutriResponse
import com.frogobox.nutritioncore.model.vitamin.VitaminResponse
import com.frogobox.nutritioncore.util.vitamin.VitaminUrl
import io.reactivex.schedulers.Schedulers


/*
 * Created by faisalamir on 30/11/21
 * NutritionFramework
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

object VitaminRepository : VitaminDataSource {

    private val TAG = VitaminRepository::class.java.simpleName
    private var vitaminApiService = NutriApiClient.create<VitaminApiService>(VitaminUrl.BASE_URL, true)

    override suspend fun getVitaminA(callback: NutriResponse.DataResponse<VitaminResponse>) {
        vitaminApiService.getVitaminA()
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiCallback<VitaminResponse>() {
                override fun onSuccess(data: VitaminResponse) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override suspend fun getVitaminC(callback: NutriResponse.DataResponse<VitaminResponse>) {
        vitaminApiService.getVitaminC()
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiCallback<VitaminResponse>() {
                override fun onSuccess(data: VitaminResponse) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override suspend fun getVitaminE(callback: NutriResponse.DataResponse<VitaminResponse>) {
        vitaminApiService.getVitaminE()
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(Schedulers.single())
            .subscribe(object : NutriApiCallback<VitaminResponse>() {
                override fun onSuccess(data: VitaminResponse) {
                    callback.onSuccess(data)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

}