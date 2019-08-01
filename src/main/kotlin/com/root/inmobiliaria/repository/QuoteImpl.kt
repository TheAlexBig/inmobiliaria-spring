package com.root.inmobiliaria.repository

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentSnapshot
import com.root.inmobiliaria.config.FirebaseSetUp
import com.root.inmobiliaria.domain.Quote
import com.root.inmobiliaria.repository.interfaces.QuoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.core.convert.TypeDescriptor.collection



@Repository
class QuoteImpl : QuoteRepository {

    @Autowired
    private lateinit var db : FirebaseSetUp

    override fun searchQuote(): MutableList<Quote>{
        val instance = db.firestore
        val future = instance!!.collection("sampledata").get()

        val found = mutableListOf<Quote>()

        val result = future.get().documents

        result.forEach {
            found.add(it.toObject(Quote::class.java))
        }
        return found
    }
    override fun updateQuote(){
        val instance = db.firestore
        val future = instance!!.collection("sampledata").document("inspiration2")
        val quote : HashMap<String, String> = hashMapOf("quote" to "AlexBig is Big 2", "author" to "AlexBig 2")
        val result = future.update(quote as Map<String, Any>)
        println("Successfully updated at: " + result.get().updateTime)

    }
}