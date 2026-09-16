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
    fun smsOffers(): List<Package> {
        val productList = mutableListOf<Package>()
        productList.add(
            Package(
                1,
                "Zong SMS + WhatsApp Bundle",
                "0",
                "0",
                "500",
                "31 MB",
                1,
                "10",
                "*700#",
                "'Unsub' Send to 700",
                "*102*2#",
                "30 MB Only For WhatsApp"
            )
        )
        productList.add(
            Package(
                2,
                "Zong Full Gup Shup Offer",
                "75",
                "0",
                "100",
                "30 MB",
                1,
                "5 Inc. Tax",
                "*118*1#",
                "'Unsub' Send to 1181",
                "-",
                "30 MB Valid between(Whatsapp Only), Offer is renewed daily at mid-night"
            )
        )
        productList.add(
            Package(
                3,
                "Zong Super Sixer Package",
                "Unlimited",
                "0",
                "500",
                "1 MB",
                1,
                "8 Inc. Tax",
                "*666#",
                "'Unsub' Send to 666111",
                "-",
                "Onnet Mins and SMS valid for 6am-6pm"
            )
        )
        productList.add(
            Package(
                6,
                "Zong Shandaar Package",
                "Unlimited",
                "0",
                "800",
                "50 MB",
                1,
                "17 Inc. Tax",
                "*999#",
                "-",
                "-",
                "Subscription is valid for one calendar day. The offer will not be autorecursive and will expire at midnight"
            )
        )
        productList.add(
            Package(
                8,
                "Zong Hello 1 Din Plus",
                "150",
                "0",
                "150",
                "50 MB",
                1,
                "13 Inc. Tax",
                "*2200*1#",
                "'Unsub' Send to 4952",
                "-",
                "The offer will be autorecursive, provided customer has sufficient balance"
            )
        )
        productList.add(
            Package(
                9,
                "Zong Flutter Offer",
                "120",
                "0",
                "120",
                "50 MB",
                1,
                "12 Inc. Tax",
                "*118*2#",
                "'Unsub' Send to 7171",
                "-",
                "Offer will deactivate midnight at same day"
            )
        )

        productList.add(
            Package(
                1,
                "Zong SMS + WhatsApp Bundle",
                "0",
                "0",
                "1300",
                "200 MB",
                7,
                "35",
                "*702#",
                "'Unsub' Send to 700",
                "*102*2#",
                "200 MB Only For WhatsApp"
            )
        )
        productList.add(
            Package(
                13,
                "Zong Weekly HLO Package",
                "Unlimited",
                "100",
                "Unlimited",
                "12 GB",
                7,
                "370",
                "*70#",
                "-",
                "-",
                "Call set up charges of Rs. 0.15 inc. tax will be applicable on every call"
            )
        )
        productList.add(
            Package(
                24,
                "Zong Weekly All in One Package",
                "5000",
                "60",
                "5000",
                "4 GB",
                7,
                "240",
                "*707#",
                "-",
                "-",
                "Dial *707# or *6464# > 4 > 1 > 2"
            )
        )
        productList.add(
            Package(
                32,
                "Zong Weekly Super Plus Package",
                "Unlimited",
                "60",
                "Unlimited",
                "8 GB",
                7,
                "350",
                "*20#",
                "-",
                "-",
                "Enjoy Whole Week!"
            )
        )
        productList.add(
            Package(
                35,
                "Zong Weekly Premium Package",
                "Unlimited",
                "180",
                "Unlimited",
                "30 GB",
                7,
                "440",
                "*225#",
                "-",
                "-",
                "Enjoy Whole Week!"
            )
        )
        productList.add(
            Package(
                46,
                "Zong Weekly Pro Package",
                "5000",
                "250",
                "5000",
                "40 GB",
                7,
                "460",
                "*794#",
                "-",
                "-",
                "Enjoy Whole Week!"
            )
        )
        productList.add(
            Package(
                57,
                "Zong Weekly Shandaar Package",
                "500",
                "40",
                "500",
                "500 MB",
                7,
                "120 Inc. Tax",
                "*7#",
                "-",
                "-",
                "Call set up charges of Rs. 0.15 inc. tax will be applicable on every call"
            )
        )
        productList.add(
            Package(
                4543,
                "Zong Monthly SMS Bundle",
                "0",
                "0",
                "15000",
                "900 MB",
                30,
                "100",
                "*705#",
                "-",
                "-",
                "500 SMS/Day and 30 MB/Day Only For WhatsApp"
            )
        )
        productList.add(
            Package(
                3,
                "Zong Monthly Shandaar Package",
                "1000",
                "100",
                "1000",
                "1 GB",
                30,
                "305 Inc. Tax",
                "*1000#",
                "'Unsub Mahana' Send to 7091",
                "-",
                "Call set up charges of PKR 0.15 will be applicable on every call"
            )
        )
        productList.add(
            Package(
                120,
                "Zong Monthly Super Star Offer",
                "3000",
                "500",
                "3000",
                "8 GB",
                30,
                "575",
                "*7070#",
                "-",
                "-",
                "Enjoy Whole Month"
            )
        )
        productList.add(
            Package(
                131,
                "Zong Super Card",
                "Unlimited",
                "250",
                "Unlimited",
                "12 GB",
                30,
                "900",
                "*50#",
                "-",
                "-",
                "Enjoy Whole Month"
            )
        )
        productList.add(
            Package(
                142,
                "Zong Supreme Offer",
                "5000",
                "350",
                "5000",
                "20 GB",
                30,
                "999",
                "*3030#",
                "'Unsub 750' Send to 6464",
                "-",
                "Youtube 2 GB, WhatsApp Free"
            )
        )
        productList.add(
            Package(
                9,
                "Zong Monthly Super Offer",
                "5000",
                "450",
                "5000",
                "30 GB",
                30,
                "1299",
                "*4567#",
                "-",
                "-",
                "30GB (20GB, 6GB Youtube, 4GB WhatsApp)"
            )
        )
        productList.add(
            Package(
                163,
                "Zong Pro Offer",
                "10000",
                "600",
                "10000",
                "40 GB",
                30,
                "1400",
                "*1500#",
                "-",
                "-",
                "Enjoy Whole Month!"
            )
        )
        productList.add(
            Package(
                173,
                "Zong Pro Plus Offer",
                "10000",
                "600",
                "10000",
                "60 GB",
                30,
                "1400",
                "*7088#",
                "-",
                "-",
                "Enjoy Whole Month!"
            )
        )
        productList.add(
            Package(
                146,
                "Zong Digital Max Offer",
                "10000",
                "1000",
                "10000",
                "100 GB",
                30,
                "1500",
                "*7333#",
                "-",
                "-",
                "Now the streaming, chatting and calling will never stop"
            )
        )
        productList.add(
            Package(
                155,
                "Zong Family Bundle",
                "15000",
                "600",
                "15000",
                "60 GB",
                30,
                "2000",
                "*505#",
                "-",
                "-",
                "40 GB + 10 GB + 10 GB (Free WhatsApp and Free Facebook for 30 Days)"
            )
        )
        productList.add(
            Package(
                15,
                "Zong Postpaid 700 SMS ",
                "0",
                "0",
                "700",
                "0",
                30,
                "50 Inc. Tax",
                "-",
                "-",
                "-",
                "Subscribe this Offer From Franchise"
            )
        )
        productList.add(
            Package(
                16,
                "Zong Postpaid 300 SMS ",
                "0",
                "0",
                "300",
                "0",
                30,
                "25 Inc. Tax",
                "-",
                "-",
                "-",
                "Subscribe this Offer From Franchise"
            )
        )
        productList.add(
            Package(
                17,
                "Zong Postpaid Unlimited SMS",
                "0",
                "0",
                "Unlimited",
                "0",
                30,
                "90 Inc. Tax",
                "-",
                "-",
                "-",
                "Subscribe this Offer From Franchise"
            )
        )
        return productList

    }

    fun internetOffers(): List<Package> {
        val productList = mutableListOf<Package>()

        productList.add(
            Package(
                28,
                "Zong Daily 1 Hour YouTube",
                "0",
                "0",
                "0",
                "Unlimited",
                1,
                "2 Inc. Tax",
                "*1987#",
                "-",
                "-",
                "Only YouTube!"
            )
        )
        productList.add(
            Package(
                2,
                "Zong Daily 4G (Daily Basic)",
                "0",
                "0",
                "0",
                "100 MB",
                1,
                "23",
                "*6464#",
                "-",
                "*102*4#",
                "For Activation Dial: *6464# >1 >1 >1 >1"
            )
        )
        productList.add(
            Package(
                6,
                "Zong Daily Data Max 4G Package",
                "0",
                "0",
                "0",
                "1 GB",
                1,
                "49",
                "*5#",
                "-",
                "*102*4#",
                "1 GB (500 MB YouTube)"
            )
        )
        productList.add(
            Package(
                224,
                "Zong Daily Social ",
                "0",
                "0",
                "0",
                "1.5 GB",
                1,
                "23",
                "*386#",
                "-",
                "-",
                "1.5 GB For One Day"
            )
        )
        productList.add(
            Package(
                22,
                "Zong DTO 1 Day ",
                "0",
                "0",
                "0",
                "1.5 GB",
                1,
                "25",
                "*47#",
                "-",
                "-",
                "1.5 GB Per Day(4 am-7 pm)"
            )
        )
        productList.add(
            Package(
                23,
                "Zong GNO 1 Day ",
                "0",
                "0",
                "0",
                "2.5 GB",
                1,
                "25",
                "GNO at 6464",
                "-",
                "-",
                "2.5 GB Per Day(1 am-9 am)"
            )
        )
        productList.add(
            Package(
                1,
                "Zong 3 Day Bundle",
                "1000",
                "10",
                "0",
                "1 GB",
                3,
                "100",
                "*3433#",
                "-",
                "-",
                "Enjoy Full 3 Days"
            )
        )
        productList.add(
            Package(
                2,
                "Zong 3 Day Super Recharge Offer",
                "300",
                "25",
                "700",
                "1.5 GB",
                3,
                "50",
                "*3454#",
                "-",
                "-",
                "Note: This offer is only available for DG Khan, Rajanpur, Jampur, Taunsa Shareef"
            )
        )
        productList.add(
            Package(
                22,
                "Zong Weekly TikTok Offer",
                "0",
                "0",
                "0",
                "5 GB",
                7,
                "100",
                "*606#",
                "-",
                "*102*4#",
                "MB Valid between: valid for TikTok only."
            )
        )
        productList.add(
            Package(
                283,
                "Zong Weekly TikTok + YouTube Offer",
                "0",
                "0",
                "0",
                "8 GB",
                7,
                "169",
                "*570#",
                "-",
                "*102*4#",
                "MB Valid between: valid for TikTok and YouTube only."
            )
        )
        productList.add(
            Package(
                292,
                "Zong Weekly Social Offer",
                "500",
                "20",
                "200",
                "5 GB",
                7,
                "140",
                "*6688#",
                "-",
                "*102*4#",
                "Enjoy Whole Week!"
            )
        )
        productList.add(
            Package(
                343,
                "Zong Stay From Home Offer",
                "1000",
                "0",
                "0",
                "10 GB",
                7,
                "190",
                "*3434#",
                "-",
                "-",
                "10GB internet (6AM to 6PM) and 1000 Zong Minutes (6AM to 6PM)"
            )
        )
        productList.add(
            Package(
                45,
                "Zong Mega Data Offer",
                "0",
                "0",
                "0",
                "100 GB",
                7,
                "200",
                "*808#",
                "-",
                "*102*4#",
                "100GB internet (1AM to 9AM)"
            )
        )
        productList.add(
            Package(
                46,
                "Zong Super Weekly Offer",
                "0",
                "0",
                "0",
                "4 GB",
                7,
                "250",
                "*6464#",
                "-",
                "*102*4#",
                "This offer is not auto-recursive."
            )
        )
        productList.add(
            Package(
                67,
                "Zong Super Weekly Max",
                "5000",
                "100",
                "5000",
                "20 GB",
                7,
                "420",
                "*220#",
                "-",
                "*102*4#",
                "15 GB Data for YouTube"
            )
        )
        productList.add(
            Package(
                1,
                "Zong Weekly HLO Package",
                "Unlimited",
                "100",
                "Unlimited",
                "12 GB",
                7,
                "370",
                "*70#",
                "-",
                "-",
                "Call set up charges of Rs. 0.15 inc. tax will be applicable on every call"
            )
        )
        productList.add(
            Package(
                2,
                "Zong Weekly All in One Package",
                "5000",
                "60",
                "5000",
                "4 GB",
                7,
                "240",
                "*707#",
                "-",
                "-",
                "Dial *707# or *6464# > 4 > 1 > 2"
            )
        )
        productList.add(
            Package(
                32,
                "Zong Weekly Super Plus Package",
                "Unlimited",
                "60",
                "Unlimited",
                "8 GB",
                7,
                "350",
                "*20#",
                "-",
                "-",
                "Enjoy Whole Week!"
            )
        )
        productList.add(
            Package(
                3,
                "Zong Weekly Premium Package",
                "Unlimited",
                "180",
                "Unlimited",
                "30 GB",
                7,
                "440",
                "*225#",
                "-",
                "-",
                "Enjoy Whole Week!"
            )
        )
        productList.add(
            Package(
                4,
                "Zong Weekly Pro Package",
                "5000",
                "250",
                "5000",
                "40 GB",
                7,
                "460",
                "*794#",
                "-",
                "-",
                "Enjoy Whole Week!"
            )
        )
        productList.add(
            Package(
                5,
                "Zong Weekly Shandaar Package",
                "500",
                "40",
                "500",
                "500 MB",
                7,
                "120 Inc. Tax",
                "*7#",
                "-",
                "-",
                "Call set up charges of Rs. 0.15 inc. tax will be applicable on every call"
            )
        )
        productList.add(
            Package(
                41,
                "Zong Super Weekly Plus Internet Sim",
                "0",
                "0",
                "0",
                "8 GB",
                7,
                "350",
                "*6666#",
                "-",
                "*102*4#",
                "Go to your nearest CSC/Franchise or a Zong retailer and get your internet SIM."
            )
        )
        productList.add(
            Package(
                42,
                "Zong Super Weekly Max Internet Sim",
                "0",
                "0",
                "0",
                "25 GB",
                7,
                "450",
                "*6666#",
                "-",
                "*102*4#",
                "Go to your nearest CSC/Franchise or a Zong retailer and get your internet SIM."
            )
        )


        productList.add(
            Package(
                2,
                "Zong Monthly Social Mini Offer",
                "0",
                "0",
                "0",
                "6 GB",
                30,
                "170",
                "*250#",
                "-",
                "*102*4#",
                "MB Valid between: valid for Facebook and WhatsApp only."
            )
        )
        productList.add(
            Package(
                3,
                "Zong Monthly IMO Offer",
                "0",
                "0",
                "0",
                "2.5 GB",
                30,
                "100",
                "*466#",
                "-",
                "*102*4#",
                "MB Valid between: valid for IMO only."
            )
        )
        productList.add(
            Package(
                4,
                "Zong Monthly WhatsApp and IMO Plus Offer",
                "200",
                "30",
                "0",
                "5 GB",
                30,
                "270",
                "*4000#",
                "-",
                "*102*4#",
                "MB Valid between: valid for WhatsApp and IMO only."
            )
        )
        productList.add(
            Package(
                5,
                "Zong Monthly WhatsApp Offer",
                "0",
                "0",
                "0",
                "5 GB",
                30,
                "120",
                "*247#",
                "-",
                "*102*4#",
                "MB Valid between: valid for WhatsApp only."
            )
        )
        productList.add(
            Package(
                132,
                "Zong Monthly Social Offer",
                "250",
                "50",
                "250",
                "12 GB",
                30,
                "350",
                "*6000#",
                "-",
                "-",
                "12 GB for All Social Media"
            )
        )
        productList.add(
            Package(
                633,
                "Zong Monthly 5 GB Super",
                "0",
                "0",
                "0",
                "5 GB",
                30,
                "400",
                "*3#",
                "-",
                "*102*4#",
                "5 GB Full Enjoy!"
            )
        )
        productList.add(
            Package(
                612,
                "Zong Monthly 20 GB Super Plus",
                "0",
                "0",
                "0",
                "20 GB",
                30,
                "700",
                "*3#",
                "-",
                "*102*4#",
                "20 GB(10GB 1am-9am)"
            )
        )
        productList.add(
            Package(
                712,
                "Zong Monthly 40 GB Super Max",
                "0",
                "0",
                "0",
                "40 GB",
                30,
                "1000",
                "*6#",
                "-",
                "*102*4#",
                "40 GB(20 GB 1am-9am)"
            )
        )
        productList.add(
            Package(
                312,
                "Zong Monthly Shandaar Package",
                "1000",
                "100",
                "1000",
                "1 GB",
                30,
                "305 Inc. Tax",
                "*1000#",
                "'Unsub Mahana' Send to 7091",
                "-",
                "Call set up charges of PKR 0.15 will be applicable on every call"
            )
        )
        productList.add(
            Package(
                120,
                "Zong Monthly Super Star Offer",
                "3000",
                "500",
                "3000",
                "8 GB",
                30,
                "575",
                "*7070#",
                "-",
                "-",
                "Enjoy Whole Month"
            )
        )
        productList.add(
            Package(
                131,
                "Zong Super Card",
                "Unlimited",
                "250",
                "Unlimited",
                "12 GB",
                30,
                "900",
                "*50#",
                "-",
                "-",
                "Enjoy Whole Month"
            )
        )
        productList.add(
            Package(
                142,
                "Zong Supreme Offer",
                "5000",
                "350",
                "5000",
                "20 GB",
                30,
                "999",
                "*3030#",
                "'Unsub 750' Send to 6464",
                "-",
                "Youtube 2 GB, WhatsApp Free"
            )
        )
        productList.add(
            Package(
                912,
                "Zong Monthly Super Offer",
                "5000",
                "450",
                "5000",
                "30 GB",
                30,
                "1299",
                "*4567#",
                "-",
                "-",
                "30GB (20GB, 6GB Youtube, 4GB WhatsApp)"
            )
        )
        productList.add(
            Package(
                163,
                "Zong Pro Offer",
                "10000",
                "600",
                "10000",
                "40 GB",
                30,
                "1400",
                "*1500#",
                "-",
                "-",
                "Enjoy Whole Month!"
            )
        )
        productList.add(
            Package(
                173,
                "Zong Pro Plus Offer",
                "10000",
                "600",
                "10000",
                "60 GB",
                30,
                "1400",
                "*7088#",
                "-",
                "-",
                "Enjoy Whole Month!"
            )
        )
        productList.add(
            Package(
                146,
                "Zong Digital Max Offer",
                "10000",
                "1000",
                "10000",
                "100 GB",
                30,
                "1500",
                "*7333#",
                "-",
                "-",
                "Now the streaming, chatting and calling will never stop"
            )
        )
        productList.add(
            Package(
                155,
                "Zong Family Bundle",
                "15000",
                "600",
                "15000",
                "60 GB",
                30,
                "2000",
                "*505#",
                "-",
                "-",
                "40 GB + 10 GB + 10 GB (Free WhatsApp and Free Facebook for 30 Days)"
            )
        )
        productList.add(
            Package(
                166,
                "Zong Monthly Internet Sim 9 GB",
                "0",
                "0",
                "0",
                "9 GB",
                30,
                "785",
                "*6666#",
                "-",
                "*102*4#",
                "4GB + 5GB(4am-4pm) Go to your nearest CSC/Franchise or a Zong retailer and get your internet SIM."
            )
        )
        productList.add(
            Package(
                17,
                "Zong Internet SIM Monthly 27 GB",
                "0",
                "0",
                "0",
                "27 GB",
                30,
                "1250",
                "*6666#",
                "-",
                "*102*4#",
                "12GB + 15GB(4am-4pm) Go to your nearest CSC/Franchise or a Zong retailer and get your internet SIM."
            )
        )
        productList.add(
            Package(
                18,
                "Zong Internet SIM Monthly 65 GB",
                "0",
                "0",
                "0",
                "65 GB",
                30,
                "2100",
                "*6666#",
                "-",
                "*102*4#",
                "Go to your nearest CSC/Franchise or a Zong retailer and get your internet SIM."
            )
        )
        productList.add(
            Package(
                19,
                "Zong Internet SIM Exclusive Monthly 175 GB",
                "0",
                "0",
                "0",
                "175 GB",
                30,
                "3300",
                "-",
                "-",
                "*102*4#",
                "175GB (Inc. 100 GB from 1AM – 9AM) Go to your nearest CSC/Franchise or a Zong retailer and get your internet SIM."
            )
        )
        productList.add(
            Package(
                20,
                "Zong Internet SIM 3 Months 5 GB",
                "0",
                "0",
                "0",
                "5 GB",
                90,
                "785",
                "*6666#",
                "-",
                "*102*4#",
                "3 GB Per Month Go to your nearest CSC/Franchise or a Zong retailer and get your internet SIM."
            )
        )
        productList.add(
            Package(
                215,
                "Zong Internet SIM 3 Months 15 GB",
                "0",
                "0",
                "0",
                "15 GB",
                90,
                "1300",
                "*6666#",
                "-",
                "*102*4#",
                "12 GB Per Month Go to your nearest CSC/Franchise or a Zong retailer and get your internet SIM."
            )
        )
        productList.add(
            Package(
                214,
                "Zong Internet SIM 3 Months 65 GB",
                "0",
                "0",
                "0",
                "65 GB",
                90,
                "5750",
                "*6666#",
                "-",
                "*102*4#",
                "12 GB Per Month Go to your nearest CSC/Franchise or a Zong retailer and get your internet SIM."
            )
        )
        productList.add(
            Package(
                213,
                "Zong Internet SIM 6 Months 105 GB",
                "0",
                "0",
                "0",
                "105 GB",
                180,
                "12500",
                "*6666#",
                "-",
                "*102*4#",
                "105 GB + 30 GB(4am-4pm) Go to your nearest CSC/Franchise or a Zong retailer and get your internet SIM."
            )
        )
        productList.add(
            Package(
                212,
                "Zong Internet SIM 1 Year 105 GB",
                "0",
                "0",
                "0",
                "105 GB",
                180,
                "23000",
                "*6666#",
                "-",
                "*102*4#",
                "105 GB + 30 GB(4am-4pm) Go to your nearest CSC/Franchise or a Zong retailer and get your internet SIM."
            )
        )
        productList.add(
            Package(
                24,
                "Zong Postpaid ZData 20 GB",
                "0",
                "0",
                "0",
                "20 GB",
                30,
                "1000 Inc. Tax",
                "*567#",
                "-",
                "-",
                "Activation points: *567#, 310 Smart IVR, My Zong APP, *310#, E-Care, Online Shop."
            )
        )
        productList.add(
            Package(
                25,
                "Zong Postpaid ZData 10 GB",
                "0",
                "0",
                "0",
                "10 GB",
                30,
                "600 Inc. Tax",
                "*567#",
                "-",
                "-",
                "Activation points: *567#, 310 Smart IVR, My Zong APP, *310#, E-Care, Online Shop."
            )
        )
        productList.add(
            Package(
                26,
                "Zong Postpaid ZData 3 GB",
                "0",
                "0",
                "0",
                "3 GB",
                30,
                "250 Inc. Tax",
                "*567#",
                "-",
                "-",
                "Activation points: *567#, 310 Smart IVR, My Zong APP, *310#, E-Care, Online Shop."
            )
        )
        productList.add(
            Package(
                27,
                "Zong Postpaid YouTube 25 GB",
                "0",
                "0",
                "0",
                "25 GB",
                30,
                "800 Inc. Tax",
                "*567#",
                "-",
                "-",
                "Activation points: *567#, 310 Smart IVR, My Zong APP, *310#, E-Care, Online Shop."
            )
        )
        productList.add(
            Package(
                28,
                "Zong Postpaid YouTube 12 GB",
                "0",
                "0",
                "0",
                "12 GB",
                30,
                "500 Inc. Tax",
                "*567#",
                "-",
                "-",
                "Activation points: *567#, 310 Smart IVR, My Zong APP, *310#, E-Care, Online Shop."
            )
        )
        return productList
    }

    fun allTopOffers() : List<Package> {
        val productList = mutableListOf<Package>()
        productList.add(
            Package(
                1,
                "Apna Shehar Mandibahauddin Offer",
                "1000",
                "40",
                "1000",
                "5 GB",
                7,
                "140",
                "*4466#",
                "-",
                "-",
                "Eligibility: Apna Shehr Mandibahauddin Offer is expanded to entire city"
            )
        )
        productList.add(
            Package(
                1879,
                "Apna Shehar Mandibahauddin Plus Offer",
                "2000",
                "80",
                "2000",
                "8 GB",
                7,
                "200",
                "*4466#",
                "-",
                "-",
                "Eligibility: Apna Shehr Mandibahauddin Offer is expanded to entire city"
            )
        )
        productList.add(
            Package(
                2,
                "Apna Shehar Punjab Offer",
                "5000",
                "120",
                "5000",
                "8 GB",
                7,
                "250",
                "*2222#",
                "-",
                "-",
                "Eligibility: Apna Shehr Punjab Offer is expanded to entire central Region"
            )
        )
        productList.add(
            Package(
                3,
                "Apna Shehar Chiniot Offer",
                "1000",
                "30",
                "300",
                "5 GB",
                7,
                "150",
                "*5522#",
                "-",
                "-",
                "Eligibility: Apna Shehr Chiniot Offer is expanded to entire central Region"
            )
        )
        productList.add(
            Package(
                4,
                "Apna Shehar Jhang Offer",
                "300",
                "25",
                "300",
                "5 GB",
                7,
                "160",
                "*4499#",
                "-",
                "-",
                "Eligibility: Apna Shehr Jhang Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                433,
                "Apna Shehar Jhang Plus Offer",
                "2000",
                "60",
                "2000",
                "8 GB",
                7,
                "200",
                "My Zong App",
                "-",
                "-",
                "4 GB Only For WhatsApp Eligibility: Apna Shehr Gilgit Baltistan Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                4303,
                "Apna Shehar Gilgit Baltistan Offer",
                "1000",
                "40",
                "1000",
                "4 GB",
                7,
                "110",
                "*4466#",
                "-",
                "-",
                "Eligibility: Apna Shehr Jhang Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                7,
                "Apna Shehar Hafizabad Offer",
                "300",
                "40",
                "300",
                "5 GB",
                7,
                "150",
                "*4488#",
                "-",
                "-",
                "Eligibility: Apna Shehr Hafizabad Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                8,
                "Apna Shehar Kasur Offer",
                "300",
                "40",
                "300",
                "5 GB",
                7,
                "140",
                "*4477#",
                "-",
                "-",
                "Eligibility: Apna Shehr Kasur Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                9,
                "Apna Shehar Shorkot Offer",
                "300",
                "40",
                "300",
                "5 GB",
                7,
                "140",
                "*7722#",
                "-",
                "-",
                "Eligibility: Apna Shehr Shorkot Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                10,
                "Apna Shehar Gojra Offer",
                "300",
                "40",
                "300",
                "5 GB",
                7,
                "150",
                "*4466#",
                "-",
                "-",
                "Eligibility: Apna Shehr Gojra Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                10,
                "Apna Shehar Gojra Plus Offer",
                "2000",
                "60",
                "2000",
                "8 GB",
                7,
                "200",
                "*4466#",
                "-",
                "-",
                "Eligibility: Apna Shehr Gojra Plus Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                11,
                "Apna Shehar Muzafargarh Offer",
                "300",
                "40",
                "300",
                "5 GB",
                7,
                "130",
                "*7744#",
                "-",
                "-",
                "Eligibility: Apna Shehr Muzafargarh Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                12,
                "Apna Shehar Narowal Offer",
                "1000",
                "40",
                "1000",
                "5 GB",
                7,
                "160",
                "*7711#",
                "-",
                "-",
                "Eligibility: Apna Shehr Narowal Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                13,
                "Apna Shehar Shakargarh Offer",
                "1000",
                "40",
                "1000",
                "5 GB",
                7,
                "150",
                "*6299#",
                "-",
                "-",
                "Eligibility: Apna Shehr Shakargarh Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                14,
                "Apna Shehar Faisalabad Offer",
                "1000",
                "40",
                "1000",
                "5 GB",
                7,
                "160",
                "*9988#",
                "-",
                "-",
                "Eligibility: Apna Shehr Faisalabad Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                15,
                "Apna Shehar Ranipur Offer",
                "300",
                "40",
                "300",
                "5 GB",
                7,
                "160",
                "*5959#",
                "-",
                "-",
                "Eligibility: Apna Shehr Ranipur Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                16,
                "Apna Shehar Mehrabpur Offer",
                "300",
                "40",
                "300",
                "5 GB",
                7,
                "170",
                "*4747#",
                "-",
                "-",
                "Eligibility: Apna Shehr Mehrabpur Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                17,
                "Apna Shehar Moro Offer",
                "300",
                "40",
                "300",
                "5 GB",
                7,
                "160",
                "*5757#",
                "-",
                "-",
                "Eligibility: Apna Shehr Moro Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                18,
                "Apna Shehar Khairpur Offer",
                "300",
                "40",
                "300",
                "5 GB",
                7,
                "150",
                "*4646#",
                "-",
                "-",
                "Eligibility: Apna Shehr Khairpur Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                19,
                "Apna Shehar Lodhran Offer",
                "1000",
                "40",
                "1000",
                "5 GB",
                7,
                "160",
                "*6233#",
                "-",
                "-",
                "Eligibility: Apna Shehr Lodhran Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                20,
                "Apna Shehar Pakpattan Offer",
                "1000",
                "40",
                "1000",
                "5 GB",
                7,
                "160",
                "*6255#",
                "-",
                "-",
                "Eligibility: Apna Shehr Pakpattan Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                21,
                "Apna Shehar DI Khan Offer",
                "1000",
                "40",
                "1000",
                "5 GB",
                7,
                "160",
                "*8800#",
                "-",
                "-",
                "Eligibility: Apna Shehr DI Khan Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                22,
                "Apna Shehar Tank Offer",
                "1000",
                "40",
                "1000",
                "5 GB",
                7,
                "160",
                "*8811#",
                "-",
                "-",
                "Eligibility: Apna Shehr Tank Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                23,
                "Apna Shehar Renala Khurd Offer",
                "1000",
                "40",
                "1000",
                "5 GB",
                7,
                "150",
                "*6288#",
                "-",
                "-",
                "Eligibility: Apna Shehr Renala Khurd Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                24,
                "Apna Shehar Khushab Offer",
                "300",
                "25",
                "300",
                "5 GB",
                7,
                "140",
                "*7766#",
                "-",
                "-",
                "Eligibility: Apna Shehr Khushab Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                25,
                "Apna Shehar Kot Addu Offer",
                "1000",
                "30",
                "1000",
                "5 GB",
                7,
                "150",
                "*6111#",
                "-",
                "-",
                "Eligibility: Apna Shehr Kot Addu Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                26,
                "Apna Shehar Mianwali Offer",
                "300",
                "25",
                "300",
                "5 GB",
                7,
                "140",
                "*7755#",
                "-",
                "-",
                "Eligibility: Apna Shehr Mianwali Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                27,
                "Apna Shehar Kamoki Offer",
                "1000",
                "40",
                "1000",
                "5 GB",
                7,
                "160",
                "*7700#",
                "-",
                "-",
                "Eligibility: Apna Shehr Kamoki Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                28,
                "Apna Shehar Layyah Offer",
                "1000",
                "30",
                "1000",
                "5 GB",
                7,
                "150",
                "*6222#",
                "-",
                "-",
                "Eligibility: Apna Shehr Layyah Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                29,
                "Apna Shehar Pattoki Offer",
                "1000",
                "0",
                "1000",
                "5 GB",
                7,
                "150",
                "*6266#",
                "-",
                "-",
                "Eligibility: Apna Shehr Pattoki Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                30,
                "Apna Shehar Bhai Pheru Offer",
                "1000",
                "40",
                "1000",
                "5 GB",
                7,
                "150",
                "*6277#",
                "-",
                "-",
                "Eligibility: Apna Shehr Bhai Pheru Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                31,
                "Apna Shehar Pano Aqil Offer",
                "300",
                "40",
                "300",
                "5 GB",
                7,
                "150",
                "*6255#",
                "-",
                "-",
                "Eligibility: Apna Shehr Pano Aqil Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                32,
                "Apna Shehar Ghotki Offer",
                "300",
                "40",
                "300",
                "5 GB",
                7,
                "150",
                "*4422#",
                "-",
                "-",
                "Eligibility: Apna Shehr Ghotki Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                33,
                "Apna Shehar Daharki Offer",
                "300",
                "40",
                "300",
                "5 GB",
                7,
                "150",
                "*4433#",
                "-",
                "-",
                "Eligibility: Apna Shehr Dharki Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                34,
                "Apna Shehar Sarai Alamghir Offer",
                "1000",
                "30",
                "1000",
                "5 GB",
                7,
                "160",
                "*5599#",
                "-",
                "-",
                "Eligibility: Apna Shehr Sarai Aalamghir Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                35,
                "Apna Shehar Dina Offer",
                "1000",
                "30",
                "1000",
                "5 GB",
                7,
                "170",
                "*5588#",
                "-",
                "-",
                "Eligibility: Apna Shehr Dina Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                36,
                "Apna Shehar Jhelum Offer",
                "1000",
                "30",
                "1000",
                "5 GB",
                7,
                "160",
                "*5577#",
                "-",
                "-",
                "Eligibility: Apna Shehr Jhelum Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                37,
                "Apna Shehar Kallar Kahar Offer",
                "1000",
                "40",
                "1000",
                "5 GB",
                7,
                "160",
                "*5544#",
                "-",
                "-",
                "Eligibility: Apna Shehr Kallar Kahar Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                38,
                "Apna Shehar Talagang Offer",
                "1000",
                "40",
                "1000",
                "5 GB",
                7,
                "150",
                "*5533#",
                "-",
                "-",
                "Eligibility: Apna Shehr Talagang Offer is expanded to entire central City"
            )
        )
        productList.add(
            Package(
                41,
                "Weekly Punjab Bachat Offer",
                "500",
                "30",
                "0",
                "2 GB",
                7,
                "99 Inc. Tax",
                "*4444#",
                "-",
                "-",
                "Eligibility Criteria: Punjab based user"
            )
        )
        productList.add(
            Package(
                4331,
                "Haftawar Punjab Offer",
                "1000",
                "100",
                "1000",
                "3 GB",
                7,
                "180",
                "*476#",
                "-",
                "-",
                "Eligibility Criteria: Punjab based user"
            )
        )
        productList.add(
            Package(
                4441,
                "Monthly Supreme Punjab Offer",
                "5000",
                "400",
                "5000",
                "22 GB",
                30,
                "1000",
                "*4545#",
                "-",
                "-",
                "10 GB + (12 GB For Youtube) Eligibility Criteria: Punjab based user"
            )
        )
        productList.add(
            Package(
                4551,
                "Mahana Punjab Offer",
                "3000",
                "400",
                "3000",
                "4 GB",
                30,
                "590",
                "*676#",
                "-",
                "-",
                "3 GB + (1 GB For Youtube) Eligibility Criteria: Punjab based user"
            )
        )
        productList.add(
            Package(
                43,
                "Daily Mehran Offer",
                "Unlimited",
                "0",
                "500",
                "100 MB",
                1,
                "30",
                "*2345#",
                "-",
                "-",
                "Dial *2345# and choose the offer of your choice. Valid (Till 12:00 night)"
            )
        )
        productList.add(
            Package(
                44,
                "Weekly Mehran Offer",
                "Unlimited",
                "0",
                "7000",
                "1 GB",
                7,
                "180",
                "*2345#",
                "-",
                "-",
                "1000 Sms/day. Dial *2345# and choose the offer of your choice. These offers are available in entire Sindh province except Karachi"
            )
        )
        productList.add(
            Package(
                45,
                "Monthly Mehran Offer",
                "Unlimited",
                "0",
                "30000",
                "2 GB",
                30,
                "540",
                "*2345#",
                "-",
                "-",
                "1000 Sms/day. Dial *2345# and choose the offer of your choice. These offers are available in entire Sindh province except Karachi"
            )
        )
        productList.add(
            Package(
                46,
                "Karachi Offer",
                "5000",
                "100",
                "5000",
                "10 GB",
                7,
                "280",
                "*54#",
                "-",
                "-",
                "5 GB 1am-9am. Eligibility: Customers of Karachi city"
            )
        )
        productList.add(
            Package(
                47,
                "Sindh Offer",
                "5000",
                "100",
                "5000",
                "10 GB",
                7,
                "280",
                "*54#",
                "-",
                "-",
                "5 GB 1am-9am. Eligibility: Customers of Sindh city"
            )
        )
        productList.add(
            Package(
                48,
                "Karachi Daily Offer",
                "Unlimited",
                "0",
                "0",
                "125 MB",
                1,
                "20",
                "*544#",
                "-",
                "-",
                "Valid till midnight same day"
            )
        )
        productList.add(
            Package(
                49,
                "Karachi Weekly Offer",
                "Unlimited",
                "0",
                "1000",
                "0",
                7,
                "76 Inc. Tax",
                "'KHI6' Send to 522",
                "-",
                "-",
                "1000 SMS For Whole Week"
            )
        )
        productList.add(
            Package(
                50,
                "Karachi Monthly Offer",
                "Unlimited",
                "0",
                "1000",
                "0",
                30,
                "238 Inc. Tax",
                "'KHI' Send to 522",
                "-",
                "-",
                "1000 SMS For Whole Month"
            )
        )
        return productList
    }

    fun easyCardOffers() : List<Package>{
        val productList = mutableListOf<Package>()

        productList.add(
            Package(
                2,
                "Zong Daily 4G (Daily Basic)",
                "0",
                "0",
                "0",
                "100 MB",
                1,
                "23",
                "*6464#",
                "-",
                "*102*4#",
                "For Activation Dial: *6464# >1 >1 >1 >1"
            )
        )
        productList.add(
            Package(
                6,
                "Zong Daily Data Max 4G Package",
                "0",
                "0",
                "0",
                "1 GB",
                1,
                "49",
                "*5#",
                "-",
                "*102*4#",
                "1 GB (500 MB YouTube)"
            )
        )
        productList.add(
            Package(
                224,
                "Zong Daily Social ",
                "0",
                "0",
                "0",
                "1.5 GB",
                1,
                "23",
                "*386#",
                "-",
                "-",
                "1.5 GB For One Day"
            )
        )
        productList.add(
            Package(
                22,
                "Zong DTO 1 Day ",
                "0",
                "0",
                "0",
                "1.5 GB",
                1,
                "25",
                "*47#",
                "-",
                "-",
                "1.5 GB Per Day(4 am-7 pm)"
            )
        )
        productList!!.add(
            Package(
                2,
                "Saudia Arabia Bundle 1",
                "0",
                "15",
                "0",
                "0",
                7,
                "300 Inc. Tax ",
                "6966",
                "-",
                "-",
                "(Prepaid)Packages are Available for Saudia Arabia Mobily Network Only"
            )
        )
        productList!!.add(
            Package(
                3,
                "Saudia Arabia Bundle 2",
                "0",
                "40",
                "0",
                "0",
                7,
                "700 Inc. Tax ",
                "6966",
                "-",
                "-",
                "(Prepaid)Packages are Available for Saudia Arabia Mobily Network Only"
            )
        )
        productList!!.add(
            Package(
                4,
                "Saudia Arabia Bundle 3",
                "0",
                "90",
                "0",
                "0",
                30,
                "1200 Inc. Tax ",
                "*6911#",
                "-",
                "-",
                "(Prepaid)Packages are Available for Saudia Arabia Mobily Network Only"
            )
        )
        productList!!.add(
            Package(
                52,
                "Saudia Arabia Bundle 4",
                "0",
                "200",
                "0",
                "0",
                30,
                "2400 Inc. Tax ",
                " 6966",
                "-",
                "-",
                "(Prepaid)Packages are Available for Saudia Arabia Mobily Network Only"
            )
        )
        productList!!.add(
            Package(
                53,
                "Saudia Arabia Bundle 5 Postpaid",
                "0",
                "90",
                "0",
                "0",
                30,
                "1200 Inc. Tax ",
                "6966",
                "-",
                "-",
                "(Postpaid)Packages are Available for Saudia Arabia Mobily Network Only"
            )
        )
        productList!!.add(
            Package(
                54,
                "Saudia Arabia Bundle 6 Postpaid",
                "0",
                "200",
                "0",
                "0",
                30,
                "2400 Inc. Tax ",
                "6966",
                "-",
                "-",
                "(Postpaid)Packages are Available for Saudia Arabia Mobily Network Only"
            )
        )
        productList!!.add(
            Package(
                1,
                "UAE Data Roaming Bundle 1",
                "0",
                "0",
                "0",
                "2 GB",
                7,
                " Rs 999 Inc. Tax",
                "*4255#",
                "-",
                "-",
                "2GB - 7 Day Only Data Roaming Bundle"
            )
        )
        productList!!.add(
            Package(
                2,
                "UAE Data Roaming Bundle 2",
                "0",
                "0",
                "0",
                "4 GB",
                15,
                " Rs 1999 Inc. Tax",
                "*4255#",
                "-",
                "-",
                "4GB - 15 Day Only Data Roaming Bundle"
            )
        )
        productList!!.add(
            Package(
                1,
                "Turkey Data Roaming Bundle",
                "0",
                "0",
                "0",
                "2 GB",
                15,
                " Rs 2499 Inc. Tax",
                "*4255#",
                "-",
                "-",
                "2GB - 15 Day Only Data Roaming Bundle"
            )
        )
        productList.add(
            Package(
                1,
                "China Weekly IDD Bundle",
                "0",
                "525",
                "0",
                "0",
                7,
                " Rs 250 Inc. Tax",
                "4083",
                " 4083",
                "-",
                "FUP of 75 Minutes per day will be applicable"
            )
        )
        productList.add(
            Package(
                2,
                "China Monthly IDD Bundle",
                "0",
                "2250",
                "0",
                "0",
                30,
                " Rs 750 Inc. Tax",
                "4083",
                " 4083",
                "-",
                "FUP of 75 Minutes per day will be applicable"
            )
        )
        productList.add(
            Package(
                3,
                "China Monthly IDD Postpaid",
                "0",
                "2250",
                "0",
                "0",
                30,
                " Rs 750 Inc. Tax",
                "4083",
                "4083",
                "-",
                "(Postpaid)FUP of 75 Minutes per day will be applicable"
            )
        )
        return productList
    }

   /* fun advanceBalance() : List<DevicePackage>{
        val productList = mutableListOf<DevicePackage>()
        productList.add(DevicePackage(1, "Advance Balance", "*911#"))
        return productList
    }
    fun balanceCheck() : List<DevicePackage>{
        val productList = mutableListOf<DevicePackage>()
        productList.add(DevicePackage(1, "Balance Check", "*222#"))
        return productList
    }
    fun mbCheck() : List<DevicePackage>{
        val productList = mutableListOf<DevicePackage>()
        productList.add(DevicePackage(1, "Check MBs", "*102#"))
        return productList
    }

    fun emergencyNumbers(): List<DevicePackage> {
        val productList = mutableListOf<DevicePackage>()
        productList.add(DevicePackage(1, "🚓 Police", "15"))
        productList.add(DevicePackage(2, "🚑 Rescue 1122", "1122"))
        productList.add(DevicePackage(3, "🚒 Fire Brigade", "16"))
        productList.add(DevicePackage(4, "🚑 Edhi Ambulance", "115"))
        productList.add(DevicePackage(5, "🚑 Chhipa Ambulance", "1020"))
        productList.add(DevicePackage(6, "🛣️ Motorway Police", "130"))
        productList.add(DevicePackage(7, "⚡ WAPDA/ بجلی شکایت", "118"))
        productList.add(DevicePackage(8, "📞 PTCL Complaint", "1218"))
        productList.add(DevicePackage(9, "🆘 Disaster Management / NDMA", "1700"))
        productList.add(DevicePackage(10, "👩 Women Helpline", "1099"))
        productList.add(DevicePackage(11, "⚖️ Human Rights Helpline", "1099"))
        productList.add(DevicePackage(12, "👶 Child Protection", "1121"))
        productList.add(DevicePackage(13, "🛡️ FIA Helpline", "1991"))
        productList.add(DevicePackage(14, "💻 Cyber Crime", "1991"))
        productList.add(DevicePackage(15, "🛂 Passport Helpline", "051-111-344-777"))
        productList.add(DevicePackage(16, "🚔 Anti-Narcotics Force", "1415"))
        return productList
    }*/

    fun getOffers(packageType: Int): List<Package> = when (packageType) {
        1 -> callOffers()
        2 -> smsOffers()
        3 -> internetOffers()
        4 -> allTopOffers()
        else -> easyCardOffers()
    }
}