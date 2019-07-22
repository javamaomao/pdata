package com.jifenkeji.pdata.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime
import java.io.Serializable
/**
 * <p>
 * 日志
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@TableName("tb_log")
class Log : Serializable {


    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    /**
     * 活动id
     */
    var activityId: String? = null

    /**
     * 操作账户
     */
    var operatingAccount: String? = null

    /**
     * 手机号码
     */
    var mobilePhoneNumber: String? = null

    /**
     * 操作时间
     */
    var operatingTime: LocalDateTime? = null


    override fun toString(): String {
        return "Log{" +
        "id=" + id +
        ", activityId=" + activityId +
        ", operatingAccount=" + operatingAccount +
        ", mobilePhoneNumber=" + mobilePhoneNumber +
        ", operatingTime=" + operatingTime +
        "}"
    }
}
