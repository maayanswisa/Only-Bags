package com.example.onlybags

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val newItem1 = Item("DNT", "Enchanting Elegance Clutch", 30, 200, R.drawable.pic11)
        ItemManager.add(newItem1)

        val newItem2 = Item("CJD", "Graceful Glamour Bag", 40, 1050, R.drawable.pic2)
        ItemManager.add(newItem2)

        val newItem3 = Item("UBD", "Chic Blossom Handbag", 25, 450, R.drawable.pic3)
        ItemManager.add(newItem3)

        val newItem4 = Item("RBS", "Opulent Orchid Purse", 80, 650, R.drawable.pic4)
        ItemManager.add(newItem4)

        val newItem5 = Item("IDB", "Radiant Rose Clutch", 20, 800, R.drawable.pic5)
        ItemManager.add(newItem5)

        val newItem6 = Item("MSI", "Ethereal Evening Pouch", 20, 150, R.drawable.pic6)
        ItemManager.add(newItem6)

        val newItem7 = Item("ISV", "Serene Silk Handbag", 20, 500, R.drawable.pic7)
        ItemManager.add(newItem7)

        val newItem8 = Item("LSV", "Gilded Petal Purse", 20, 250, R.drawable.pic8)
        ItemManager.add(newItem8)

        val newItem10 = Item("TVJ", "Velvet Twilight Satchel", 20, 250, R.drawable.pic10)
        ItemManager.add(newItem10)

        val newItem11 = Item("MOC", "Sapphire Dream Clutch", 20, 250, R.drawable.pic1)
        ItemManager.add(newItem11)

        val newItem12 = Item("GLI", "Pearle scent Elegance Handbag", 20, 250, R.drawable.pic12)
        ItemManager.add(newItem12)

        val newItem13 = Item("WKG", "Dazzling Moonbeam Purse", 20, 250, R.drawable.pic13)
        ItemManager.add(newItem13)

        val newItem14 = Item("ILP", "Silken Sunset Tote", 20, 250, R.drawable.pic14)
        ItemManager.add(newItem14)

        val newItem15 = Item("BDU", "Everyday hand bag", 20, 250, R.drawable.pic15)
        ItemManager.add(newItem15)

        val newItem16 = Item("MLD", "Whispering Willow Clutch", 20, 250, R.drawable.pic16)
        ItemManager.add(newItem16)

        val newItem17 = Item("EKV", "Harmony Hues Evening Pouch", 20, 250, R.drawable.pic17)
        ItemManager.add(newItem17)

        val newItem18 = Item("TVS", "Mystical Merlot Satchel", 20, 250, R.drawable.pic18)
        ItemManager.add(newItem18)

        val newItem19 = Item("MVP", "Celestial Cascade Bag", 20, 250, R.drawable.pic19)
        ItemManager.add(newItem19)



    }


}

