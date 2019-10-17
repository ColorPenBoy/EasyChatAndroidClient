package com.king.easychat.app.chat

import com.king.easychat.app.base.MessageModel
import com.king.easychat.bean.GroupMessageDbo
import com.king.easychat.bean.RecentChat
import com.king.easychat.bean.RecentGroupChat
import com.king.easychat.dao.GroupMessageDao
import com.king.easychat.netty.packet.req.GroupMessageReq
import com.king.easychat.netty.packet.resp.GroupMessageResp
import com.king.frame.mvvmframe.data.IDataRepository
import javax.inject.Inject

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class GroupChatModel @Inject constructor(repository: IDataRepository?) : MessageModel(repository){


    /**
     *保存群聊消息
     */
    fun saveGroupMessage(userId: String,userName: String?, data: GroupMessageReq){
        getGroupMessageDao().insert(data.toGroupMessageResp(userId,userName,true).toGroupMessageDbo(userId))
    }

    /**
     *保存群聊消息
     */
    fun saveGroupMessage(userId : String, data: GroupMessageResp){
        getGroupMessageDao().insert(data.toGroupMessageDbo(userId))
    }

    /**
     * 根据群聊id获取聊天记录
     */
    fun queryMessageByGroupId(userId : String, groupId : String, currentPage : Int, pageSize : Int) : List<GroupMessageDbo> {
        return getGroupMessageDao().getGroupMessageByGroupId(userId, groupId, (currentPage-1) * pageSize, pageSize).sortedBy { it.dateTime }
    }

    fun saveRecentGroupChat(data: RecentGroupChat){
        getRecentGroupChatDao().insert(data)
    }


}