package com.example.onlybags

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onlybags.databinding.WelcomeLayoutBinding
import android.net.Uri


class WelcomeFragment:Fragment() {
    private var _binding: WelcomeLayoutBinding?=null
    private val binding get()=_binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= WelcomeLayoutBinding.inflate(inflater,container,false)

        binding.btnAllItems.setOnClickListener{
            findNavController().navigate(R.id.action_welcomeFragment_to_allItemsFragment)
        }


        binding.btnCart.setOnClickListener{
            findNavController().navigate(R.id.action_welcomeFragment_to_cartFragment)
        }

        binding.btnAbout.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(getString(R.string.app_name))
            builder.setMessage(
                "Designed and Developed with Love by Maayan Swisa. \n" +
                        "Please Check my Instagram for more beautiful bags. "
            )
            builder.setNegativeButton(
                "Dismiss"
            ) { dialog, which -> dialog.dismiss() }

            builder.setPositiveButton(
                "VISIT"
            ) { dialog, which ->
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/onlybags___?igsh=cm82aHZkMnA4d2lw&utm_source=qr"))
                startActivity(intent)
            }

            builder.create().show()
        }



        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}

