package com.codehangouts.navcomponents


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_item_details.*
import kotlinx.android.synthetic.main.fragment_place_buy_order.*
import java.math.BigDecimal


class PlaceBuyOrderFragment : Fragment(), View.OnClickListener {

    lateinit var buyPrice: String
    lateinit var wallet: Money
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buyPrice = arguments!!.getString("amount")
        wallet = arguments!!.getParcelable("wallet")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place_buy_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<TextView>(R.id.btn_confirm_payment).setOnClickListener(this)
        view.findViewById<TextView>(R.id.btn_cancel).setOnClickListener(this)

        val walletAmount = wallet!!.amount
        val walletMessage = "Wallet balance : \$$walletAmount"
        val amountToBePaidMsg = "Amount to be paid : $buyPrice"
        view.findViewById<TextView>(R.id.tv_buy_amount).text = amountToBePaidMsg
        view.findViewById<TextView>(R.id.tv_wallet_balance).text = walletMessage
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_confirm_payment -> {
                if(!TextUtils.isEmpty(tv_buy_amount.text.toString())){

                    val amount = Money(BigDecimal(buyPrice.removePrefix("$")))
                    val bundle = bundleOf(
                        "amount" to amount
                    )
                    navController!!.navigate(
                        R.id.action_placeBuyOrderFragment_to_confirmationFragment,
                        bundle
                    )
                }
                else{
                    Toast.makeText(activity, "Amount should have some value", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.btn_cancel -> activity!!.onBackPressed()
        }
    }


}
