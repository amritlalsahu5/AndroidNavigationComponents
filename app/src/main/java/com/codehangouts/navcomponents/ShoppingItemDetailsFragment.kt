package com.codehangouts.navcomponents

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_item_details.*
import java.math.BigDecimal


class ShoppingItemDetailsFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btn_buy).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_cancel).setOnClickListener(this)
        //val message = "Sending money to $recipient"
        //view.findViewById<TextView>(R.id.recipient).text = message
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_buy -> {
                if(!TextUtils.isEmpty(tv_price.text.toString())){

                    val amount = tv_price.text.toString()
                    val wallet = Money(BigDecimal("250.00"))
                    val bundle = bundleOf(
                        "wallet" to wallet,
                        "amount" to amount
                    )
                    navController!!.navigate(
                        R.id.action_itemDetails_to_placeBuyOrderFragment,
                        bundle
                    )
                }
                else{
                    Toast.makeText(activity, "Enter an amount", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.btn_cancel -> activity!!.onBackPressed()
        }
    }
}
