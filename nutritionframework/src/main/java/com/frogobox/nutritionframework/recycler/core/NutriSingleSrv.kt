package com.frogobox.nutritionframework.recycler.core

import android.view.View
import com.frogobox.nutritionframework.log.NLog
import com.frogobox.nutritionframework.recycler.core.NutriRvConstant.NUTRI_RV_TAG

/*
 * Created by Faisal Amir on 04/06/2020
 * FrogoRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */

class NutriSingleSrv : NutriSingleRv<String>() {

    protected lateinit var srvNutriAdapterCallback: INutriViewAdapter<String>
    protected lateinit var srvNutriViewAdapter: NutriViewAdapter<String>

    protected var srvSumListItem: Int = 2
    protected var srvCustomViewInt: Int = 0

    fun addShimmerViewPlaceHolder(customViewInt: Int): NutriSingleSrv {
        srvCustomViewInt = customViewInt
        NLog.d("$NUTRI_RV_TAG - injector-shimmerView : $srvCustomViewInt")
        return this
    }

    fun addShimmerSumOfItemLoading(sumItem: Int): NutriSingleSrv {
        srvSumListItem = sumItem
        NLog.d("$NUTRI_RV_TAG - injector-sumItem : $srvSumListItem")
        return this
    }

    private fun srvListData(): MutableList<String> {
        for (i in 1..srvSumListItem) {
            listData.add("place-holder-shimmer")
        }
        return listData
    }

    override fun createAdapter() {
        optionAdapter = NutriRvConstant.NUTRI_ADAPTER_R_CLASS

        srvNutriAdapterCallback = object : INutriViewAdapter<String> {
            override fun setupInitComponent(view: View, data: String) {}
            override fun onItemClicked(data: String) {}
            override fun onItemLongClicked(data: String) {}
        }

        srvNutriViewAdapter = NutriViewAdapter()
        srvNutriViewAdapter.setCallback(object : INutriViewHolder<String> {
            override fun setupInitComponent(view: View, data: String) {
                srvNutriAdapterCallback.setupInitComponent(view, data)
            }
        })
        srvNutriViewAdapter.setupRequirement(srvCustomViewInt, srvListData(),
            object :
                NutriRecyclerViewListener<String> {
                override fun onItemClicked(data: String) {
                    srvNutriAdapterCallback.onItemClicked(data)
                }

                override fun onItemLongClicked(data: String) {
                    srvNutriAdapterCallback.onItemLongClicked(data)
                }
            })

        srvNutriViewAdapter.setupEmptyView(emptyViewId)
    }

    override fun setupInnerAdapter() {
        NLog.d("$NUTRI_RV_TAG - injector-optionAdapter : $optionAdapter")
        nutriRecycleView.adapter = srvNutriViewAdapter
    }

}