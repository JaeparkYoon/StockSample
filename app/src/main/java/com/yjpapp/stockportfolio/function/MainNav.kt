@file:OptIn(ExperimentalMaterialApi::class)

package com.yjpapp.stockportfolio.function

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yjpapp.stockportfolio.R
import com.yjpapp.stockportfolio.function.mystock.MyStockViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.yjpapp.stockportfolio.function.mystock.MyStockScreen

sealed class NavItem(
    val title: Int,
    val icon: Int,
    val screenRoute: String
) {
    object MyStock: NavItem(
        title = R.string.MyStockFragment_Title,
        icon = R.drawable.ic_my_stock,
        screenRoute = "MY_STOCK"
    )
    object IncomeNote: NavItem(
        title = R.string.IncomeNoteFragment_Title,
        icon = R.drawable.ic_income_note,
        screenRoute = "INCOME_NOTE"
    )
    object Memo: NavItem(
        title = R.string.MemoListFragment_Title,
        icon = R.drawable.ic_memo_list,
        screenRoute = "Memo"
    )
    object My: NavItem(
        title = R.string.MyFragment_Title,
        icon = R.drawable.ic_my,
        screenRoute = "My"
    )
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavItem.MyStock.screenRoute) {
        composable(NavItem.MyStock.screenRoute) {
            val myStockViewModel = hiltViewModel<MyStockViewModel>()
            MyStockScreen(viewModel = myStockViewModel)
        }
        composable(NavItem.IncomeNote.screenRoute) {
            //Todo 수익 노트 compose
        }
        composable(NavItem.Memo.screenRoute) {
            //Todo 메모 compose
        }
        composable(NavItem.My.screenRoute) {
            //Todo 마이 compose
        }
    }
}