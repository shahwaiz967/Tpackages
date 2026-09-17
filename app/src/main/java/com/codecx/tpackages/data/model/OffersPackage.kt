package com.codecx.tpackages.data.model

data class OffersPackage(
    val id: Int,
    val description: String? = null,
    val title: String? = null,
    val onNet: String? = null,
    val offNet: String? = null,
    val sms: String? = null,
    val internet: String? = null,
    val validity: Int? = null,
    val price: String? = null,
    val activate: String? = null,
    val deactivate: String? = null,
    val status: String? = null,
    val desc: String? = null
) {
    constructor(
        id: Int,
        title: String,
        onNet: String,
        offNet: String,
        sms: String,
        internet: String,
        idity: Int,
        price: String,
        activate: String,
        deactivate: String,
        status: String,
        desc: String
    ) : this(
        id = id,
        description = null,
        title = title,
        onNet = onNet,
        offNet = offNet,
        sms = sms,
        internet = internet,
        validity = idity,
        price = price,
        activate = activate,
        deactivate = deactivate,
        status = status,
        desc = desc
    )
}

