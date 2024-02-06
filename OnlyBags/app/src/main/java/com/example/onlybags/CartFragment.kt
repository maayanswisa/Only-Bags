package com.example.onlybags

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlybags.databinding.CartLayoutBinding
import com.example.onlybags.databinding.WelcomeLayoutBinding

class CartFragment:Fragment() {

    private var _binding: CartLayoutBinding?=null
    private val binding get()=_binding!!

    private val viewModel1: SumViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= CartLayoutBinding.inflate(inflater,container,false)

        binding.btnItems.setOnClickListener{
            findNavController().navigate(R.id.action_cartFragment_to_allItemsFragment)
        }

        binding.btnBuy.setOnClickListener{
            findNavController().navigate(R.id.action_cartFragment_to_afterBuyFragment2)
            viewModel1.setSum(binding.txtTotal.text.toString())
        }







        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler1.adapter = ItemAdapter(CartManager.selectedItems, object : ItemAdapter.ItemListener {
            override fun onItemClicked(index: Int) {

            }

            override fun onItemLongClicked(index: Int) {
                val item = CartManager.selectedItems[index]

                val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.custom_dialog_layout, null)
                val dialogTitle = dialogView.findViewById<TextView>(R.id.dialogTitle)
                val dialogMessage = dialogView.findViewById<TextView>(R.id.dialogMessage)

                dialogTitle.text = "Remove Item"
                dialogMessage.text = "Are you sure you want to remove this item from the cart?"

                val alertDialog = AlertDialog.Builder(requireContext())
                    .setView(dialogView)
                    .setPositiveButton("Yes") { dialog, _ ->
                        // הסר את הפריט מהסל
                        CartManager.remove(index)
                        binding.recycler1.adapter?.notifyItemRemoved(index)

                        // Update the corresponding TextViews
                        val totalPrice = CartManager.calculateTotalPrice()
                        val calculateItemCount = CartManager.calculateItemCount()

                        binding.txtTotal.text = "     Total: $totalPrice"
                        binding.txtNumberItems.text = "   $calculateItemCount Items"


                        item.backgroundColor = Color.WHITE

                        binding.recycler1.adapter?.notifyItemRemoved(index)
                        binding.recycler1.adapter?.notifyItemChanged(index)

                        // עדכן את הממשק המשתמש
                        // CartManager.updateViewModel()

                        Toast.makeText(requireContext(), "Item removed from cart", Toast.LENGTH_SHORT).show()

                        dialog.dismiss()  // סגור את הדיאלוג לאחר לחיצה על "Yes"

                    }
                    .setNegativeButton("No") { dialog, _ ->
                        dialog.dismiss()  // סגור את הדיאלוג לאחר לחיצה על "Yes"
                    }
                    .create()

                alertDialog.setOnShowListener {
                    val positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
                    val negativeButton = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE)

                    // כאן, תשנה את העיצוב של הכפתורים
                    // לדוגמה, נשנה צבעי רקע וצבע טקסט של הכפתורים
                    positiveButton.setBackgroundColor(Color.parseColor("#FD93B7"))
                    positiveButton.setTextColor(Color.WHITE)

                    negativeButton.setBackgroundColor(Color.parseColor("#FD93B7"))
                    negativeButton.setTextColor(Color.WHITE)
                }

                alertDialog.show()
            }
        })
        val totalPrice = CartManager.calculateTotalPrice()

        val calculateItemCount = CartManager.calculateItemCount()
        // Display total price in txt_total TextView
        binding.txtTotal.text = "     Total: $totalPrice"
        binding.txtNumberItems.text = "   $calculateItemCount Items"

        binding.recycler1.layoutManager = LinearLayoutManager(requireContext())
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}
