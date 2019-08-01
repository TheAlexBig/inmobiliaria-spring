package com.root.inmobiliaria.service

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentSnapshot
import com.root.inmobiliaria.domain.Quote
import com.root.inmobiliaria.repository.QuoteImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class QuoteService {
    @Autowired
    lateinit var quoteImpl: QuoteImpl

    fun searchQuote() : MutableList<Quote> {
        return quoteImpl.searchQuote()
    }
    fun updateQuote(){
        quoteImpl.updateQuote()
    }
}