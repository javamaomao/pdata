package com.jifenkeji.pdata.entity

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.io.Serializable
/**
 * <p>
 * 商品库
 * </p>
 *
 * @author yangguo
 * @since 2019-07-22
 */
@TableName("tb_library_of_goods")
class LibraryOfGoods : Serializable {


    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    /**
     * 商品名
     */
    var tradeName: String? = null

    /**
     * 商品一级分类
     */
    var firstClassClassification: String? = null

    /**
     * 商品二级分类
     */
    var secondaryClassificationOfGoods: String? = null

    /**
     * 商品三级分类
     */
    var threeLevelCommodityClassification: String? = null


    override fun toString(): String {
        return "LibraryOfGoods{" +
        "id=" + id +
        ", tradeName=" + tradeName +
        ", firstClassClassification=" + firstClassClassification +
        ", secondaryClassificationOfGoods=" + secondaryClassificationOfGoods +
        ", threeLevelCommodityClassification=" + threeLevelCommodityClassification +
        "}"
    }
}
