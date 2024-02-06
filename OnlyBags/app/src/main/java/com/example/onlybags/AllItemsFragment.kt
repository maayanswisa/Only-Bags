package com.example.onlybags

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlybags.databinding.AllItemsLayoutBinding

class AllItemsFragment : Fragment() {

    private var _binding: AllItemsLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AllItemsLayoutBinding.inflate(inflater, container, false)

        binding.btnGoToCart.setOnClickListener {
            findNavController().navigate(R.id.action_allItemsFragment_to_cartFragment)
        }




        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter =
            ItemAdapter(ItemManager.items, object : ItemAdapter.ItemListener {

                override fun onItemClicked(index: Int) {
                    // Change the isSelected state
                    val selectedItem = ItemManager.items[index]
                    selectedItem.isSelected = !selectedItem.isSelected

                    // Change the backgroundColor based on the new isSelected state
                    selectedItem.backgroundColor =
                        if (selectedItem.isSelected) Color.YELLOW else Color.WHITE

                    // Add the item to the cart
                    if (selectedItem.isSelected) {
                        Toast.makeText(requireContext(), "Added To Cart", Toast.LENGTH_SHORT).show()
                        CartManager.selectedItems.add(selectedItem)
                    } else {
                        Toast.makeText(requireContext(), "Removed From Cart", Toast.LENGTH_SHORT).show()
                        CartManager.selectedItems.remove(selectedItem)
                    }

                    // Notify the adapter about the change
                    binding.recycler.adapter?.notifyItemChanged(index)


                }

                override fun onItemLongClicked(index: Int) {

                }


            })

        binding.recycler.layoutManager = LinearLayoutManager(requireContext())

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
