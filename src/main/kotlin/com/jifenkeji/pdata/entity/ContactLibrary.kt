package com.jifenkeji.pdata.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.io.Serializable
/**
 * <p>
 * 触点库
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@TableName("tb_contact_library")
class ContactLibrary : Serializable {


    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    /**
     * offer名
     */
    var offerName: String? = null


    override fun toString(): String {
        return "ContactLibrary{" +
        "id=" + id +
        ", offerName=" + offerName +
        "}"
    }
}
