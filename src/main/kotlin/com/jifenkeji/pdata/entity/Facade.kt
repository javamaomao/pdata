package com.jifenkeji.pdata.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.io.Serializable
/**
 * <p>
 * 门面
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@TableName("tb_facade")
class Facade : Serializable {


    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    /**
     * 门店代码
     */
    var storeCode: String? = null

    /**
     * 门店名称
     */
    var nameOfStore: String? = null


    override fun toString(): String {
        return "Facade{" +
        "id=" + id +
        ", storeCode=" + storeCode +
        ", nameOfStore=" + nameOfStore +
        "}"
    }
}
