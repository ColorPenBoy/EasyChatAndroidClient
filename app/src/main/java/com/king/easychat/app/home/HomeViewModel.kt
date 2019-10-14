package com.king.easychat.app.home

import android.app.Application
import com.king.easychat.app.Constants
import com.king.easychat.app.base.MessageViewModel
import com.king.frame.mvvmframe.base.BaseModel
import com.king.frame.mvvmframe.base.BaseViewModel
import com.king.frame.mvvmframe.base.DataViewModel
import javax.inject.Inject

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class HomeViewModel @Inject constructor(application: Application, model: HomeModel?) : MessageViewModel(application, model){


    override fun onCreate() {
        super.onCreate()
    }



    fun retry(){
        queryMessageList(getApp().getUserId(),1,Constants.PAGE_SIZE)
    }
}