package com.example.proyectofragments.dummy

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()


    private val COUNT = 3

    /**
    * Este array pertenece a los elementos(Por ejemplo los contactos del movil
     */
    private val nom = arrayOf("", "angel", "juan", "marta")

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    /**
     * Esto es para mostrar los contactos de forma numerada en el movil
     */
    private fun createDummyItem(position: Int): DummyItem {
        return DummyItem(position.toString(), "Contacto:  " + nom.get(position), makeDetails(position))
    }

    /**
     * Esta funcion es para darle detalles a los contactos
     */

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append(": ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class DummyItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}
