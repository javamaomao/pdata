package com.jifenkeji.pdata.entity

import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable

@TableName("c1")
class C1 :Serializable {

    var cid :Int?=null
    var cname :String? =null

}