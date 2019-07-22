package com.jifenkeji.pdata.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.io.Serializable
/**
 * <p>
 * 渠道库
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@TableName("tb_channel_library")
class ChannelLibrary : Serializable {


    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    /**
     * 渠道名
     */
    var channelName: String? = null

    /**
     * 渠道类型
     */
    var channelType: String? = null


    override fun toString(): String {
        return "ChannelLibrary{" +
        "id=" + id +
        ", channelName=" + channelName +
        ", channelType=" + channelType +
        "}"
    }
}
