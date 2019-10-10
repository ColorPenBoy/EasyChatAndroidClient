package com.king.easychat.netty.packet.resp

import com.king.easychat.netty.MessageType
import com.king.easychat.netty.packet.Packet
import com.king.easychat.util.AES

/**
 * @author Zed
 * date: 2019/08/19.
 * description:
 */
class MessageResp(val sender : String,val senderName : String,val message : String) : Packet() {

//    @Expose val msg = AES.decrypt(message,dateTime + "ab").toString()

    override fun messageType(): Int {
        return MessageType.SEND_MESSAGE_RESP
    }

    fun getMsg(): String?{
        return AES.decrypt(message,dateTime + "ab")
    }

    override fun toString(): String {
        return "MessageResp(sender='$sender', senderName='$senderName', message='$message', msg='${getMsg()}') ${super.toString()}"
    }


}
