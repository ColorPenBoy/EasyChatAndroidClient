package com.king.easychat.netty.packet.req

import com.king.easychat.netty.MessageType
import com.king.easychat.netty.packet.Packet

/**
 * @author Zed
 * date: 2019/10/09.
 * description:
 */
class InviteGroupReq(val groupId : String, val users : List<String>) : Packet(){
    override fun messageType(): Int {
        return MessageType.INVITE_GROUP_REQ
    }

}