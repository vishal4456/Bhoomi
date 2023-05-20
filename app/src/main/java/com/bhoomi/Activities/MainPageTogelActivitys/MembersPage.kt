package com.bhoomi.Activities.MainPageTogelActivitys

import android.annotation.SuppressLint
import androidx.compose.animation.Animatable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhoomi.ui.theme.BG
import com.bhoomi.ui.theme.BGLite
import com.bhoomi.ui.theme.Denim
import com.bhoomi.ui.theme.Melibu
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MembersPage(name:String) {

}
@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun Member(paddingValues: PaddingValues) {
    val tabItem= listOf("movie","web")
    val pagerState= com.google.accompanist.pager.rememberPagerState(tabItem.size)
    val coroutineScope= rememberCoroutineScope()
    Column(Modifier.padding(paddingValues)) {
        androidx.compose.material.TabRow(selectedTabIndex = pagerState.currentPage,
            backgroundColor = Melibu,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .background(color = Color.Transparent)
                .clip(shape = RoundedCornerShape(30.dp)),

            indicator = { tabPositions ->
                androidx.compose.material.TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions = tabPositions),
                    color = Color.Transparent
                )
            }
        )
        {
            tabItem.forEachIndexed { index, title ->
                val color = remember {
                    Animatable(Denim)
                }
                LaunchedEffect(pagerState.currentPage == index) {
                    color.animateTo(if (pagerState.currentPage == index) Color.White else Melibu)
                }
                Tab(
                    text = {
                        Text(
                            text = title, style = if (pagerState.currentPage == index)
                                androidx.compose.ui.text.TextStyle(color = Denim, fontSize = 18.sp)
                            else
                                androidx.compose.ui.text.TextStyle(color = Denim, fontSize = 18.sp)
                        )
                    },
                    selected = pagerState.currentPage == index,
                    modifier = Modifier.background(
                        color = color.value,
                        shape = RoundedCornerShape(30.dp)

                    ),
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    })
            }
        }

        Card(
            elevation = CardDefaults.cardElevation(pressedElevation = 20.dp),
            shape = CardDefaults.elevatedShape,
            colors = CardDefaults.cardColors(BGLite),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 20.dp, start = 5.dp, end = 5.dp)
        ) {
            com.google.accompanist.pager.HorizontalPager(
                count = tabItem.size, state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Transparent)
            ) {
                // Text(text = tabItem[it], Modifier.padding(50.dp), color = Color.White)
                LazyColumn(modifier = Modifier.padding(top = 5.dp)) {
                    items((users)) { User ->
                        Members()


                    }
                }
            }
        }
    }
}



