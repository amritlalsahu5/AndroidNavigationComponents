package com.codehangouts.navcomponents


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation


class ShoppingItemListFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btn_shop_now).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_view_balance).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_view_balance).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_shop_now -> navController!!.navigate(R.id.action_mainFragment_to_shoppingItemDetails)
            R.id.btn_view_balance -> navController!!.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
            R.id.btn_view_balance -> navController!!.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }
    }



}
