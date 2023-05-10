package com.bhoomi.Screens

import com.bhoomi.R

data class MainpageData(val name : String, val src:Int = 0)
    fun BoxData():List<MainpageData>{
        return listOf(MainpageData("Members",src= R.drawable.ic_home),
            MainpageData("Socity Bank",src=R.drawable.ic_menu),
            MainpageData("Family", src = R.drawable.ic_scan),
            MainpageData("Achievement", src = R.drawable.ic_percent),
            MainpageData("Historical Place", src = R.drawable.ic_menuclick),
            MainpageData("Staff", src = R.drawable.ic_people),
            MainpageData("Water Tax",src=R.drawable.ic_menu),
            MainpageData("Home Tax",src = R.drawable.ic_scan),
            MainpageData("Inventry", src = R.drawable.ic_percent))
    }


