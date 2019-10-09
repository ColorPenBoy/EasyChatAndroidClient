package com.king.easychat.netty.packet.resp

import com.king.easychat.netty.MessageType
import com.king.easychat.netty.packet.Packet

/**
 * @author Zed
 * date: 2019/08/19.
 * description:
 */
class RegisterResp : Packet() {
    var success: Boolean = false
    var reason: String? = null

    override fun messageType(): Int {
        return MessageType.REGISTER_RESP
    }



}
