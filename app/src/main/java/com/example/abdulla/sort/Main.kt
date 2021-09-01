package com.example.abdulla.sort

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val listOfProducts: List<Item> = listOf(
                Item("Яблоко", 3.4f, 4, Date()),
                Item("Груша", 13.4f, 2, Date()),
                Item("Арбуз", 4f, 3, Date()),
                Item("Бана", 122.4f, 1, Date()),
            )
            val cart = Cart(listOfProducts)
            cart.showProducts(SortingByPrice())

            Cart(listOfProducts).showProducts(SortingByProductName())
        }

        class Cart(private val initialList: List<Item>) {
            fun showProducts(sortingType: Sorting) {
                println("Сортируем с помощью ${sortingType.sortName(Localization.RU)}")
                val newList: List<Item> = sortingType.sort(initialList)
                newList.printItems()
            }

            fun List<Item>.printItems() {
                this.forEach {
                    println(it)
                }
            }
        }

        class Item(
            val productName: String,
            val price: Float,
            val popularity: Int,
            val date: Date
        ) {
            val dateFormat = SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSSSSS")//MMMM august mmm aug mm 08
            fun getDate(): String
            {
                    return dateFormat.format(date)
            }



            override fun toString(): String {
                return "Товар: ${productName}, за цену: ${price}, " +
                        "находящийся на $popularity месте популярности выпущенный в ${getDate()}"
            }
        }

        interface Sorting {
            fun sortName(Locale : Localization): String
            fun sort(list: List<Item>): List<Item>
        }

        enum class Localization{
            RU,EN
        }

        class SortingByPrice:Sorting{
            override fun sortName(locale: Localization): String {
                return when(locale)
                {
                    Localization.RU -> "Отсортировать по цене"
                    Localization.EN -> "Sort by Price"
                }
            }
            override fun sort(list: List<Item>): List<Item> {
                return list.sortedByDescending { it.price }
            }
        }

        class SortingByProductName:Sorting{
            override fun sortName(locale: Localization): String {
                return when(locale)
                {
                    Localization.RU -> "Отсортировать по цене"
                    Localization.EN -> "Sort by Price"
                }
            }
            override fun sort(list: List<Item>): List<Item> {
                return list.sortedBy { it.productName }
            }
        }
    }
}