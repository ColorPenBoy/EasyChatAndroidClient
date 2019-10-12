package com.king.easychat.app.account

import android.app.Application
import androidx.core.content.ContextCompat.startActivity
import com.king.anetty.Netty
import com.king.easychat.app.Constants
import com.king.easychat.netty.NettyClient
import com.king.easychat.netty.packet.req.LoginReq
import com.king.frame.mvvmframe.base.BaseModel
import com.king.frame.mvvmframe.base.DataViewModel
import io.netty.channel.ChannelFuture
import io.netty.util.concurrent.Future
import io.netty.util.concurrent.GenericFutureListener
import javax.inject.Inject

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class LoginViewModel @Inject constructor(application: Application, model: BaseModel?) : DataViewModel(application, model){

    var loginReq: LoginReq? = null

    val genericFutureListener by lazy {
        GenericFutureListener<ChannelFuture> {
            if(it.isSuccess){
                sendSingleLiveEvent(Constants.EVENT_SUCCESS)
            }
            hideLoading()
        }
    }

    override fun onCreate() {
        super.onCreate()

        NettyClient.INSTANCE.setOnConnectListener(object: Netty.OnConnectListener{
            override fun onSuccess() {
                NettyClient.INSTANCE.addListener(genericFutureListener)
            }

            override fun onFailed() {

            }

            override fun onError(e: Exception?) {

            }

        })

        NettyClient.INSTANCE.connect()
    }

    override fun onDestroy() {
        NettyClient.INSTANCE.removeListener(genericFutureListener)
        super.onDestroy()
    }

    fun login(username: String,password: String){
        showLoading()
        loginReq = LoginReq(username,password)
        NettyClient.INSTANCE.sendMessage(loginReq!!)
    }
}