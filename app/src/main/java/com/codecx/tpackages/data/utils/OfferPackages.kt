package com.codecx.tpackages.data.utils
import com.codecx.tpackages.data.model.DeviceOffersModel
import com.codecx.tpackages.data.model.Package

object OfferPackages {

    fun deviceOffers(): List<DeviceOffersModel> {
        return listOf(
            DeviceOffersModel(1, "Helpline", "111"),
            DeviceOffersModel(27, "Check Minutes", "*110#"),
            DeviceOffersModel(9, "Check SMS", "*110#"),
            DeviceOffersModel(10, "Check MBs", "*114*1*2#"),
            DeviceOffersModel(8, "My Offer/Package Info", "*444#"),
            DeviceOffersModel(2, "Check Sim Number", "*99#"),
            DeviceOffersModel(3, "Card Recharge", "*123*14 "),
            DeviceOffersModel(4, "Balance Check", "*111#"),
            DeviceOffersModel(5, "Advance Balance", "*112#"),
            DeviceOffersModel(28, "Unsubscribe Advance Balance", "*112*4#"),
            DeviceOffersModel(26, "Super Card Info", "*610#"),
            DeviceOffersModel(12, "Balance Share", "*100*"),
            DeviceOffersModel(11, "Sim Lagao Offer", "*551#"),
            DeviceOffersModel(29, "Check MBs, Call, SMS of Sim Lagao Offer", "*553*2#"),
            DeviceOffersModel(30, "New Sim Offer", "*191#"),
            DeviceOffersModel(25, "OwnerShip Confirmation", "*668#"),
            DeviceOffersModel(13, "SMS Blocking", "*420#"),
            DeviceOffersModel(14, "Check OwnerShip of Number", "*300#"),
            DeviceOffersModel(15, "Details about Data Bundles (Prepaid)", "*443#"),
            DeviceOffersModel(16, "Details about Data Bundles (Postpaid)", "*446#"),
            DeviceOffersModel(17, "Check Active Services on Number", "*6611#"),
            DeviceOffersModel(18, "Call waiting", "*43#"),
            DeviceOffersModel(19, "Deactivate Mobitunes", "*230#"),
            DeviceOffersModel(20, "Mobilink Chat", "*636#"),
            DeviceOffersModel(21, "Zero Balance Call", "*600#"),
            DeviceOffersModel(22, "Sim Unlock PUK Code", "99999999"),
            DeviceOffersModel(23, "Sim Unlock PUK2 Code", "56789123"),
            DeviceOffersModel(24, "Sim Unlock PIN2 Code", "1234")
        )
    }
    fun callOffers() : List<Package>{
        val productList = mutableListOf<Package>()
        productList.add(Package(1,"The Full Day Offer (Rs. 13–15, dial *5*250#) provides unlimited on-net calls ","Telenor Facebook","3000","50","_","1000",1,"15","*311#","*311#","*311#"))
        productList.add(Package(2,"The Full Day Offer (Rs. 13–15, dial *5*250#) provides unlimited on-net calls ","Telenor IR Voice","3000","_","_","1000",1,"15","*311#","*311#","*311#"))
        productList.add(Package(3,"Weekly Call Package: 1500 Telenor minutes, 50 off-net minutes, 1000 SMS, 2GB Internet for 7 days","Telenor Weekly Call","1500","50","1000","2000",7,"200","*123#","*123#","*123#"))
        productList.add(Package(4,"Monthly Call Package: 5000 Telenor minutes, 200 off-net minutes, 2000 SMS, 5GB Internet for 30 days","Telenor Monthly Call","5000","200","2000","5000",30,"600","*664#","*664#","*664#"))
        return productList
    }
    fun smsOffers() : List<Package>{
        val productList = mutableListOf<Package>()
        productList.add(Package(1,"The Monthly Offer provides unlimited on-net calls ","Telenor Monthly","_","_","50","100",30,"1000","*664#","*664#","*664#"))
        productList.add(Package(2,"The Full Day Offer (Rs. 13–15, dial *5*250#) provides unlimited on-net calls ","Telenor SMS","_","_","240","_",1,"4.78","*345*116#","*345*116#","*345*116#"))
        productList.add(Package(3,"The Weekly Offer (Rs. 13–15, dial *5*250#) provides unlimited on-net calls ","Telenor 7 Days","1500","50","2000","_",7,"200","*123#","*123#","*123#"))

        return productList
    }

    fun getOffers(packageType: Int): List<Package> = when (packageType) {
        1 -> callOffers()
        else -> smsOffers()
    }
}