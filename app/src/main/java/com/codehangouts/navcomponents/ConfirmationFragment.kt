package com.codehangouts.navcomponents


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation


class ConfirmationFragment : Fragment(), OnClickListener {

    //lateinit var priceAmount: String
    lateinit var money: Money
    lateinit var navController :NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //priceAmount = arguments!!.getString("amount")
        money = arguments!!.getParcelable("amount")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btn_done).setOnClickListener(this)
        val amount = money!!.amount
        val confirmationMessage = "Your payment of \$$amount \n was successfully completed"
        view.findViewById<TextView>(R.id.tv_success_message).text = confirmationMessage
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_done -> {
                navController!!.navigate(
                    R.id.action_confirmationFragment_to_mainFragment)

            }

        }
    }


}
