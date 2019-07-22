package com.jifenkeji.pdata.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime
import java.io.Serializable
/**
 * <p>
 * 测试
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@TableName("tb_test")
class Test : Serializable {


    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    /**
     * 数字
     */
    var digital: Int? = null

    /**
     * 时间
     */
    var time: LocalDateTime? = null

    /**
     * 正文
     */
    var bodyOf: String? = null

    /**
     * 文本
     */
    var text: String? = null


    override fun toString(): String {
        return "Test{" +
        "id=" + id +
        ", digital=" + digital +
        ", time=" + time +
        ", bodyOf=" + bodyOf +
        ", text=" + text +
        "}"
    }
}
