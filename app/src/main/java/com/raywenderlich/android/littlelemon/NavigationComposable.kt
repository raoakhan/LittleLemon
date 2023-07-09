package com.raywenderlich.android.littlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
//import android.provider.ContactsContract
//import androidx.navigation.NavHost
//import com.raywenderlich.android.littlelemon.Profile.route


@Composable
fun NavigationComposable(context: Context,navController: NavHostController) {

    val sharedPreferences = context.getSharedPreferences("Little Lemon", Context.MODE_PRIVATE)
    var startDestination = Onboarding.route

    if (sharedPreferences.getBoolean("userRegistered", false)) {
        startDestination = Home.route
    }

    NavHost(navController = navController, startDestination = startDestination){

        composable(Onboarding.route){
            Onboarding(context, navController)
        }
        composable(Home.route){
            Home(navController)
        }

        composable(Profile.route){
            Profile(context, navController)
        }
//        composable(Profile.route){
//            ContactsContract.Profile(context, navController)
//        }
    }
}