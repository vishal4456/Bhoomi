package com.bhoomi.Screens

import androidx.annotation.DrawableRes
import com.bhoomi.R

sealed class DashbordIcons(val id:Int,
                           val title:String,
                           @DrawableRes val selectedIconId:Int){
    object Home:DashbordIcons(id=0,"Home", R.drawable.ic_home)
    object Contact:DashbordIcons(id = 1,"Contact",R.drawable.ic_peopleclick)
    object Menu:DashbordIcons(id = 2,"Menu",R.drawable.ic_menuclick)
    object Scan:DashbordIcons(id = 3,"Scan",R.drawable.ic_scanclick)
    object Per:DashbordIcons(id = 4,"Percentage",R.drawable.ic_perclick)

}
