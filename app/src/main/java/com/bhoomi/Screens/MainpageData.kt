package com.bhoomi.Screens

import androidx.compose.material.icons.Icons
import com.bhoomi.R

data class MainpageData(val id :Int,val name : String, val src:Int = 0)

    fun BoxData():List<MainpageData>{
        return listOf(MainpageData(0,"Members",src= R.drawable.ic_home),
            MainpageData(1,"Socity Bank",src=R.drawable.ic_bank),
            MainpageData(8,"Inventry", src = R.drawable.ic_inventory_24),
           // MainpageData(2,"Family", src = R.drawable.ic_scan),
            MainpageData(3,"Achievement", src = R.drawable.ic_achievement),
            MainpageData(4,"Historical Place", src = R.drawable.ic_menuclick),
            //MainpageData(5,"Staff", src = R.drawable.ic_people),
           // MainpageData(6,"Water Tax",src=R.drawable.ic_menu),
           // MainpageData(7,"Home Tax",src = R.drawable.ic_scan),
            MainpageData(8,"Post", src = R.drawable.post_add_24))


    }



