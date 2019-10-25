package com.king.easychat.app.friend

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.king.easychat.R
import com.king.easychat.app.Constants
import com.king.easychat.app.base.BaseActivity
import com.king.easychat.app.me.user.ChangeUserInfoActivity
import com.king.easychat.bean.User
import com.king.easychat.databinding.UserProfileActivityBinding
import com.king.easychat.netty.NettyClient
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.user_profile_activity.*

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class UserProfileActivity : BaseActivity<UserProfileViewModel,UserProfileActivityBinding>(),View.OnClickListener{

    private lateinit var userId : String

    private var user: User? = null

    override fun initData(savedInstanceState: Bundle?) {

        tvTitle.text = intent.getStringExtra(Constants.KEY_TITLE)
        userId = intent.getStringExtra(Constants.KEY_ID)

        btnAdd.setOnClickListener(this)

        mViewModel.userLiveData.observe(this, Observer {
            it?.let {
                mBinding.data = it
                user = it
                getApp().firends?.run {
                    if(contains(it)){
                        btnAdd.visibility = View.GONE
                        tvLabelRemark.visibility = View.VISIBLE
                        tvRemark.visibility = View.VISIBLE
                    }else{
                        btnAdd.visibility = View.VISIBLE
                        tvLabelRemark.visibility = View.GONE
                        tvRemark.visibility = View.GONE
                    }
                }
            }
        })

        mViewModel.getUser(userId)
    }

    override fun getLayoutId(): Int {
        return R.layout.user_profile_activity
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK){
            when(requestCode){
                Constants.REQ_CHANGE_USER_INFO -> {
                    var user = data?.getParcelableExtra<User>(Constants.KEY_BEAN)
                    user?.let {
                        mBinding.data = it
                        this.user = it
                    }

                }
            }
        }
    }

    private fun clickAddFriend(){
        if(NettyClient.INSTANCE.isConnected()){
            mViewModel.addFriend(userId)
            showToast(R.string.success_operator)
            finish()
        }else{
            showToast(R.string.operator_failed)
        }

    }



    private fun clickRemark(){
        val intent = newIntent(getString(R.string.change_remark), ChangeUserInfoActivity::class.java)
        intent.putExtra(Constants.KEY_ID,userId)
        intent.putExtra(Constants.KEY_TYPE, ChangeUserInfoActivity.CHANGE_REMARK)
        intent.putExtra(Constants.KEY_TIPS,getString(R.string.tips_change_remark))
        intent.putExtra(Constants.KEY_CONTENT,user?.remark)
        intent.putExtra(Constants.KEY_MAX,resources.getInteger(R.integer.remark_max_length))
        startActivityForResult(intent,Constants.REQ_CHANGE_USER_INFO)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when(v.id){
            R.id.btnAdd -> clickAddFriend()
            R.id.tvLabelRemark -> clickRemark()
        }
    }
}