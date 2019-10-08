package com.king.easychat.app.home

import android.app.Application
import com.king.frame.mvvmframe.base.BaseModel
import com.king.frame.mvvmframe.base.DataViewModel
import javax.inject.Inject

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class HomeViewModel @Inject constructor(application: Application, model: BaseModel?) : DataViewModel(application, model){


    override fun onCreate() {
        super.onCreate()
    }
}