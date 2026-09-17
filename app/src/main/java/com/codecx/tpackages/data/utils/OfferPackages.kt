package com.codecx.tpackages.data.utils
import com.codecx.tpackages.data.model.DeviceOffersModel
import com.codecx.tpackages.data.model.OffersPackage

object OfferPackages {

    fun deviceOffers(): List<DeviceOffersModel> {
        return listOf(
            DeviceOffersModel(1, "Helpline", "111"),
            DeviceOffersModel(27, "Check Minutes", "*110#"),
            DeviceOffersModel(9, "Check SMS", "*110#"),
            DeviceOffersModel(10, "Check MBs", "*114*1*2#"),
            DeviceOffersModel(8, "My Offer/OffersPackage Info", "*444#"),
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


    fun callOffers() : List<OffersPackage>{
        val productList = mutableListOf<OffersPackage>()
        productList.add(
            OffersPackage(
                1,
                "Full Day Offer: Unlimited on-net calls with 50 MB Internet and 100 MB WhatsApp",
                "Telenor Full Day Offer",
                "Unlimited",
                "_",
                "_",
                "150 MB",
                1,
                "15",
                "*5*250#",
                "*123#",
                "*5*250#"
            )
        )

        productList.add(
            OffersPackage(
                2,
                "Good Time Offer: Unlimited on-net calls with 250 MB Facebook Internet",
                "Telenor Good Time Offer",
                "Unlimited",
                "_",
                "_",
                "250 MB",
                1,
                "7",
                "*345*20#",
                "*123#",
                "*345*20#"
            )
        )

        productList.add(
            OffersPackage(
                3,
                "Daily Call Offer: 1000 on-net minutes, 50 off-net minutes and 100 SMS",
                "Telenor Daily Call Offer",
                "1000",
                "50",
                "100",
                "_",
                1,
                "20",
                "*345*101#",
                "*123#",
                "*345*101#"
            )
        )

        productList.add(
            OffersPackage(
                4,
                "Weekly Voice Lite: 140 Telenor minutes for 7 days",
                "Telenor Weekly Voice Lite",
                "140",
                "_",
                "_",
                "_",
                7,
                "25",
                "*345*54#",
                "*123#",
                "*345*54#"
            )
        )

        productList.add(
            OffersPackage(
                5,
                "7 Day Hybrid: 1500 on-net minutes, 80 off-net minutes, 1500 SMS and 3GB Internet",
                "Telenor 7 Day Hybrid",
                "1500",
                "80",
                "1500",
                "3 GB",
                7,
                "87",
                "*345*79#",
                "*123#",
                "*345*79#"
            )
        )

        productList.add(
            OffersPackage(
                6,
                "Weekly EasyCard: 1500 on-net minutes, 50 off-net minutes and 2000 SMS",
                "Telenor Weekly EasyCard",
                "1500",
                "50",
                "2000",
                "_",
                7,
                "200",
                "*123#",
                "*123#",
                "*123#"
            )
        )

        productList.add(
            OffersPackage(
                7,
                "Weekly EasyCard Max: 2500 on-net minutes, 125 off-net minutes and 2500 SMS with 3GB Internet",
                "Telenor Weekly EasyCard Max",
                "2500",
                "125",
                "2500",
                "3 GB",
                7,
                "287",
                "*345*106#",
                "*123#",
                "*345*106#"
            )
        )

        productList.add(
            OffersPackage(
                8,
                "Haftawar Sahulat: 1000 on-net minutes, 70 off-net minutes, 700 SMS and Internet",
                "Telenor Haftawar Sahulat",
                "1000",
                "70",
                "700",
                "100 MB",
                7,
                "120",
                "*5*7#",
                "*123#",
                "*5*7#"
            )
        )



        productList.add(
            OffersPackage(
                12,
                "Monthly EasyCard: 5000 on-net minutes, 400 off-net minutes, 2500 SMS and 5GB Internet",
                "Telenor Monthly EasyCard",
                "5000",
                "400",
                "2500",
                "5 GB",
                30,
                "1217",
                "*80#",
                "*123#",
                "*80#"
            )
        )

        return productList
    }
    fun smsOffers(): List<OffersPackage> {
        val productList = mutableListOf<OffersPackage>()

        productList.add(OffersPackage(1, "Telenor Weekly SMS Bundle", "0", "0", "2000", "0", 7, "17", "*345*75#", "*345*75*4#", "*111#", "2000 SMS for 7 days"))
        productList.add(OffersPackage(2, "Telenor Monthly SMS Bundle", "0", "0", "10000", "300 MB", 30, "60", "*345*363#", "*345*363*4#", "*111#", "10,000 SMS + 300 MB WhatsApp for 30 days"))
        productList.add(OffersPackage(3, "Telenor Weekly EasyCard", "1500", "50", "2000", "500 MB", 7, "200", "*123#", "*123#", "*123#", "1500 on-net minutes, 50 off-net minutes and 2000 SMS"))
        productList.add(OffersPackage(4, "Telenor Weekly EasyCard Max", "2500", "125", "2500", "3 GB", 7, "287", "*345*106#", "*345*106*4#", "*123#", "2500 on-net minutes, 125 off-net minutes, 2500 SMS and 3 GB"))
        productList.add(OffersPackage(5, "Telenor Weekly AIO", "3000", "180", "3000", "8 GB", 7, "409", "*345*7#", "*345*7*4#", "*123#", "3000 on-net minutes, 180 off-net minutes, 3000 SMS and 8 GB"))
        productList.add(OffersPackage(6, "Telenor Weekly AIO Plus", "5000", "250", "5000", "15 GB", 7, "461", "*345*88#", "*345*88*4#", "*123#", "5000 on-net minutes, 250 off-net minutes, 5000 SMS and 15 GB"))
        productList.add(OffersPackage(7, "Telenor Monthly EasyCard", "5000", "400", "2500", "5 GB", 30, "1217", "*80#", "*123#", "*123#", "5000 on-net minutes, 400 off-net minutes, 2500 SMS and 5 GB"))
        productList.add(OffersPackage(8, "Telenor Monthly Extreme Offer", "7500", "600", "5000", "15 GB", 30, "1391", "*708#", "-", "*123#", "7500 on-net minutes, 600 off-net minutes, 5000 SMS and 15 GB"))
        productList.add(OffersPackage(9, "Telenor Monthly Extreme Pro Max", "Unlimited", "800", "10000", "100 GB", 30, "1739", "*345*26#", "-", "*123#", "Unlimited on-net minutes, 800 off-net minutes, 10000 SMS and 100 GB"))

        return productList
    }
    fun internetOffers(): List<OffersPackage> {
        val productList = mutableListOf<OffersPackage>()

        productList.add(OffersPackage(1, "Telenor Daily Social Pack", "0", "0", "0", "70 MB", 1, "3", "*311#", "*311*4#", "*999#", "70 MB for Facebook and WhatsApp"))
        productList.add(OffersPackage(2, "Telenor Daily YouTube Pack", "0", "0", "0", "500 MB", 1, "8", "*60#", "*60*4#", "*999#", "500 MB for YouTube"))
        productList.add(OffersPackage(3, "Telenor Daily 4G OffersPackage", "0", "0", "0", "250 MB", 1, "15", "*13#", "*13*4#", "*999#", "250 MB for 24 hours"))
        productList.add(OffersPackage(4, "Telenor Daily Offpeak Offer", "0", "0", "0", "1.5 GB", 1, "15", "*10#", "*10*4#", "*999#", "1.5 GB from 6 AM to 6 PM"))
        productList.add(OffersPackage(5, "Telenor Raat Din Offer", "0", "0", "0", "1.5 GB", 1, "18", "*150#", "*150*4#", "*999#", "1.5 GB for the stated 24-hour offer period"))
        productList.add(OffersPackage(6, "Telenor 3-Day Internet", "0", "0", "0", "1.5 GB", 3, "50", "*345*050#", "*345*050*4#", "*999#", "1.5 GB for 3 days"))
        productList.add(OffersPackage(7, "Telenor 4G Weekly Super", "0", "0", "0", "4 GB", 7, "217", "*288#", "*288*4#", "*999#", "4 GB including 2 GB for 1 AM to 11 AM"))
        productList.add(OffersPackage(8, "Telenor 4G Weekly Internet Max", "0", "0", "0", "30 GB", 7, "130", "*19#", "*19*4#", "*999#", "30 GB valid during 12 AM to 9 AM"))
        productList.add(OffersPackage(9, "Telenor Weekly 6 to 6 Offer", "0", "0", "0", "5 GB", 7, "149", "*71#", "*71*4#", "*999#", "5 GB from 6 AM to 6 PM"))
        productList.add(OffersPackage(10, "Telenor 4G Weekly Ultra Plus", "0", "0", "0", "10 GB", 7, "330", "*225#", "*225*4#", "*999#", "10 GB including 10 GB for 1 AM to 11 AM"))
        productList.add(OffersPackage(11, "Telenor Monthly IMO OffersPackage", "0", "0", "0", "490 MB", 30, "50", "*466#", "*466*4#", "*999#", "490 MB for IMO"))
        productList.add(OffersPackage(12, "Telenor Monthly WhatsApp", "0", "0", "0", "4 GB", 30, "86", "*247#", "*247*4#", "*999#", "4 GB for WhatsApp"))
        productList.add(OffersPackage(13, "Telenor Monthly TikTok Offer", "0", "0", "0", "3 GB", 30, "113", "*345*14#", "*345*14*4#", "*999#", "3 GB for TikTok"))
        productList.add(OffersPackage(14, "Telenor Monthly Social Extreme", "0", "0", "0", "5 GB", 30, "234", "*345*41#", "*345*41*4#", "*999#", "5 GB social data"))
        productList.add(OffersPackage(15, "Telenor Monthly Social Extreme Plus", "0", "0", "0", "10 GB", 30, "286", "*660#", "*660*4#", "*999#", "10 GB social data"))
        productList.add(OffersPackage(16, "Telenor Monthly Starter", "0", "0", "0", "15 GB", 30, "750", "*345*2002#", "-", "*999#", "15 GB for 30 days"))
        productList.add(OffersPackage(17, "Telenor Monthly Super Plus", "500", "100", "0", "30 GB", 30, "1304", "*979#", "-", "*123#", "30 GB including 15 GB for 1 AM to 9 AM"))

        return productList
    }
    fun allTopOffers(): List<OffersPackage> {
        val productList = mutableListOf<OffersPackage>()

        productList.add(OffersPackage(1, "Telenor Weekly EasyCard", "1500", "50", "2000", "500 MB", 7, "200", "*123#", "*123#", "*123#", "Weekly hybrid OffersPackage"))
        productList.add(OffersPackage(2, "Telenor Weekly EasyCard Max", "2500", "125", "2500", "3 GB", 7, "287", "*345*106#", "*345*106*4#", "*123#", "Weekly hybrid OffersPackage"))
        productList.add(OffersPackage(3, "Telenor Weekly AIO", "3000", "180", "3000", "8 GB", 7, "409", "*345*7#", "*345*7*4#", "*123#", "Weekly all-in-one OffersPackage"))
        productList.add(OffersPackage(4, "Telenor Weekly AIO Plus", "5000", "250", "5000", "15 GB", 7, "461", "*345*88#", "*345*88*4#", "*123#", "Weekly all-in-one OffersPackage"))
        productList.add(OffersPackage(5, "Telenor Weekly Ultimate Offer", "Unlimited", "500", "0", "50 GB", 7, "522", "*345*144#", "*345*144*4#", "*123#", "50 GB with unlimited on-net minutes"))
        productList.add(OffersPackage(6, "Telenor Weekly Prime Offer", "Unlimited", "600", "15000", "100 GB", 7, "539", "*345*145#", "*345*145*4#", "*123#", "100 GB with unlimited on-net minutes"))
        productList.add(OffersPackage(7, "Telenor Monthly EasyCard", "5000", "400", "2500", "5 GB", 30, "1217", "*80#", "*123#", "*123#", "Monthly hybrid OffersPackage"))
        productList.add(OffersPackage(8, "Telenor Monthly Super Plus", "500", "100", "0", "30 GB", 30, "1304", "*979#", "*979*4#", "*123#", "30 GB including off-peak data"))
        productList.add(OffersPackage(9, "Telenor Monthly Extreme Offer", "7500", "600", "5000", "15 GB", 30, "1391", "*708#", "*708*4#", "*123#", "Monthly all-in-one OffersPackage"))
        productList.add(OffersPackage(10, "Telenor Monthly Extreme Plus", "10000", "700", "0", "30 GB", 30, "1478", "*345*111#", "*345*111*4#", "*123#", "Monthly hybrid OffersPackage"))
        productList.add(OffersPackage(11, "Telenor Monthly Extreme Pro Max", "Unlimited", "800", "10000", "100 GB", 30, "1739", "*345*26#", "*345*26*4#", "*123#", "Monthly high-usage OffersPackage"))
        productList.add(OffersPackage(12, "Telenor Monthly Ultimate Offer", "Unlimited", "1200", "0", "100 GB", 30, "1739", "*345*98#", "*345*98*4#", "*123#", "100 GB with unlimited on-net minutes"))
        productList.add(OffersPackage(13, "Telenor Monthly Prime Offer", "10000", "1500", "0", "300 GB", 30, "2087", "*345*130#", "*345*130*4#", "*123#", "300 GB monthly OffersPackage"))

        return productList
    }
    fun easyCardOffers(): List<OffersPackage> {
        val productList = mutableListOf<OffersPackage>()

        productList.add(OffersPackage(1, "Telenor Weekly EasyCard", "1500", "50", "2000", "500 MB", 7, "200", "*123#", "-", "*123#", "1500 on-net minutes, 50 off-net minutes and 2000 SMS"))
        productList.add(OffersPackage(2, "Telenor Weekly EasyCard Max", "2500", "125", "2500", "3 GB", 7, "287", "*345*106#", "-", "*123#", "2500 on-net minutes, 125 off-net minutes, 2500 SMS and 3 GB"))
        productList.add(OffersPackage(3, "Telenor Monthly EasyCard", "5000", "400", "2500", "5 GB", 30, "1217", "*80#", "-", "*123#", "5000 on-net minutes, 400 off-net minutes, 2500 SMS and 5 GB"))
        productList.add(OffersPackage(4, "Telenor 4G Weekly Super", "0", "0", "0", "4 GB", 7, "217", "*288#", "-", "*999#", "4 GB internet OffersPackage"))

        return productList
    }
    fun allInOneOffers(): List<OffersPackage> {
        val productList = mutableListOf<OffersPackage>()

        productList.add(OffersPackage(1, "Telenor Weekly AIO", "3000", "180", "3000", "8 GB", 7, "409", "*345*7#", "*345*7*4#", "*123#", "3000 on-net minutes, 180 off-net minutes, 3000 SMS and 8 GB"))
        productList.add(OffersPackage(2, "Telenor Weekly AIO Plus", "5000", "250", "5000", "15 GB", 7, "461", "*345*88#", "*345*88*4#", "*123#", "5000 on-net minutes, 250 off-net minutes, 5000 SMS and 15 GB"))
        productList.add(OffersPackage(3, "Telenor Weekly Prime Offer", "Unlimited", "600", "15000", "100 GB", 7, "539", "*345*145#", "*345*145*4#", "*123#", "Unlimited on-net minutes, 600 off-net minutes, 15000 SMS and 100 GB"))
        productList.add(OffersPackage(4, "Telenor Monthly EasyCard", "5000", "400", "2500", "5 GB", 30, "1217", "*80#", "*123#", "*123#", "5000 on-net minutes, 400 off-net minutes, 2500 SMS and 5 GB"))
        productList.add(OffersPackage(5, "Telenor Monthly Extreme Offer", "7500", "600", "5000", "15 GB", 30, "1391", "*708#", "*708*4#", "*123#", "7500 on-net minutes, 600 off-net minutes, 5000 SMS and 15 GB"))
        productList.add(OffersPackage(6, "Telenor Monthly Extreme Pro Max", "Unlimited", "800", "10000", "100 GB", 30, "1739", "*345*26#", "*345*26*4#", "*123#", "Unlimited on-net minutes, 800 off-net minutes, 10000 SMS and 100 GB"))
        productList.add(OffersPackage(7, "Telenor Monthly Prime Offer", "10000", "1500", "0", "300 GB", 30, "2087", "*345*130#", "*345*130*4#", "*123#", "10000 on-net minutes, 1500 off-net minutes and 300 GB"))

        return productList
    }

    fun globalOffers() : List<OffersPackage>{
        val productList = mutableListOf<OffersPackage>()

        productList!!.add(
            OffersPackage(
                2,
                "Saudia Arabia Bundle 1",
                "0",
                "15",
                "0",
                "0",
                7,
                "300 ",
                "6966",
                "-",
                "-",
                "(Prepaid)OffersPackages are Available for Saudia Arabia Mobily Network Only"
            )
        )
        productList!!.add(
            OffersPackage(
                3,
                "Saudia Arabia Bundle 2",
                "0",
                "40",
                "0",
                "0",
                7,
                "700 ",
                "6966",
                "-",
                "-",
                "(Prepaid)OffersPackages are Available for Saudia Arabia Mobily Network Only"
            )
        )
        productList!!.add(
            OffersPackage(
                4,
                "Saudia Arabia Bundle 3",
                "0",
                "90",
                "0",
                "0",
                30,
                "1200 ",
                "*6911#",
                "-",
                "-",
                "(Prepaid)OffersPackages are Available for Saudia Arabia Mobily Network Only"
            )
        )
        productList!!.add(
            OffersPackage(
                52,
                "Saudia Arabia Bundle 4",
                "0",
                "200",
                "0",
                "0",
                30,
                "2400 ",
                " 6966",
                "-",
                "-",
                "(Prepaid)OffersPackages are Available for Saudia Arabia Mobily Network Only"
            )
        )
        productList!!.add(
            OffersPackage(
                53,
                "Saudia Arabia Bundle 5 Postpaid",
                "0",
                "90",
                "0",
                "0",
                30,
                "1200 ",
                "6966",
                "-",
                "-",
                "(Postpaid)OffersPackages are Available for Saudia Arabia Mobily Network Only"
            )
        )
        productList!!.add(
            OffersPackage(
                54,
                "Saudia Arabia Bundle 6 Postpaid",
                "0",
                "200",
                "0",
                "0",
                30,
                "2400 ",
                "6966",
                "-",
                "-",
                "(Postpaid)OffersPackages are Available for Saudia Arabia Mobily Network Only"
            )
        )
        productList!!.add(
            OffersPackage(
                1,
                "UAE Data Roaming Bundle 1",
                "0",
                "0",
                "0",
                "2 GB",
                7,
                " Rs 999",
                "*4255#",
                "-",
                "-",
                "2GB - 7 Day Only Data Roaming Bundle"
            )
        )
        productList!!.add(
            OffersPackage(
                2,
                "UAE Data Roaming Bundle 2",
                "0",
                "0",
                "0",
                "4 GB",
                15,
                " Rs 1999",
                "*4255#",
                "-",
                "-",
                "4GB - 15 Day Only Data Roaming Bundle"
            )
        )
        productList!!.add(
            OffersPackage(
                1,
                "Turkey Data Roaming Bundle",
                "0",
                "0",
                "0",
                "2 GB",
                15,
                " Rs 2499",
                "*4255#",
                "-",
                "-",
                "2GB - 15 Day Only Data Roaming Bundle"
            )
        )
        productList.add(
            OffersPackage(
                1,
                "China Weekly IDD Bundle",
                "0",
                "525",
                "0",
                "0",
                7,
                " Rs 250",
                "4083",
                " 4083",
                "-",
                "FUP of 75 Minutes per day will be applicable"
            )
        )
        productList.add(
            OffersPackage(
                2,
                "China Monthly IDD Bundle",
                "0",
                "2250",
                "0",
                "0",
                30,
                " Rs 750",
                "4083",
                " 4083",
                "-",
                "FUP of 75 Minutes per day will be applicable"
            )
        )
        productList.add(
            OffersPackage(
                3,
                "China Monthly IDD Postpaid",
                "0",
                "2250",
                "0",
                "0",
                30,
                " Rs 750",
                "4083",
                "4083",
                "-",
                "(Postpaid)FUP of 75 Minutes per day will be applicable"
            )
        )
        return productList
    }

    fun advanceBalance() : List<DeviceOffersModel>{
        val productList = mutableListOf<DeviceOffersModel>()
        productList.add(DeviceOffersModel(1, "Advance Balance", "*0#"))
        return productList
    }
    fun balanceCheck() : List<DeviceOffersModel>{
        val productList = mutableListOf<DeviceOffersModel>()
        productList.add(DeviceOffersModel(1, "Balance Check", "*444#"))
        return productList
    }
    fun mbCheck() : List<DeviceOffersModel>{
        val productList = mutableListOf<DeviceOffersModel>()
        productList.add(DeviceOffersModel(1, "Check MBs", "*999#"))
        return productList
    }

    fun freeMBs(): List<DeviceOffersModel> {
        val productList = mutableListOf<DeviceOffersModel>()
        productList.add(DeviceOffersModel(1, "Telenor Free MB Offer", "*888#","","Free Internet 7 days."))
        productList.add(DeviceOffersModel(2,"Telenor Free MB Offer","*5*700#","","Free 500 MB for 10 days"))
        return productList
    }



    fun getOffers(packageType: Int): List<OffersPackage> = when (packageType) {
        1 -> callOffers()
        2 -> smsOffers()
        3 -> internetOffers()
        4 -> allTopOffers()
        5 -> easyCardOffers()
        6 -> allInOneOffers()
        else -> globalOffers()
    }

    fun getQuickTools(toolType : Int) : List<DeviceOffersModel> = when(toolType){
        1 -> balanceCheck()
        2 -> advanceBalance()
        3 -> mbCheck()
        else -> freeMBs()
    }
}