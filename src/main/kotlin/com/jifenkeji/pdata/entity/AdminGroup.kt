package com.jifenkeji.pdata.entity

import java.io.Serializable

class AdminGroup : Serializable {
    var groupName: String? = null
        set(groupName) {
            field = groupName?.trim { it <= ' ' }
        }

    var groupAuth: String? = null
        set(groupAuth) {
            field = groupAuth?.trim { it <= ' ' }
        }
    var id: Int? = null
    var groupId: Int? = null

    companion object {

        private const val serialVersionUID = 1L
    }
}