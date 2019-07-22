package com.jifenkeji.pdata.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.io.Serializable
/**
 * <p>
 * 
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@TableName("tb_goods")
class Goods : Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    var goodsName: String? = null

    var goodsCategory1: String? = null

    var goodsCategory2: String? = null

    var goodsCategory3: String? = null


    override fun toString(): String {
        return "Goods{" +
        "id=" + id +
        ", goodsName=" + goodsName +
        ", goodsCategory1=" + goodsCategory1 +
        ", goodsCategory2=" + goodsCategory2 +
        ", goodsCategory3=" + goodsCategory3 +
        "}"
    }
}
