package com.codecx.tpackages.data.model

import org.koin.core.scope.ScopeID

data class DeviceOffersModel(
    val id: Int,
    val title: String,
    val code: String,
    val activate: String? = null,
    val description: String? = null
) {
    constructor(
        id: Int,
        title: String,
        code: String
    ) : this(
        id = id,
        title = title,
        code = code,
        activate = null,
        description = null
    )
}
