package com.king.easychat.app.me

import android.os.Bundle
import android.view.View
import com.king.easychat.R
import com.king.easychat.app.base.BaseFragment
import com.king.easychat.databinding.MeFragmentBinding
import kotlinx.android.synthetic.main.home_toolbar.*
import kotlinx.android.synthetic.main.me_fragment.*

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class MeFragment : BaseFragment<MeViewModel,MeFragmentBinding>(),View.OnClickListener{

    companion object{
        fun newInstance(): MeFragment{
            return MeFragment()
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        tvTitle.setText(R.string.menu_me)

        clUser.setOnClickListener(this)
        tvPassword.setOnClickListener(this)
        tvAbout.setOnClickListener(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.me_fragment
    }

    fun clickUser(){

    }

    fun clickPassword(){

    }

    fun clickAbout(){

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.clUser -> clickUser()
            R.id.tvPassword -> clickPassword()
            R.id.tvAbout -> clickAbout()
        }
    }

}