package com.root.inmobiliaria.repository.interfaces

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentSnapshot
import com.root.inmobiliaria.domain.Quote

interface QuoteRepository {
    fun searchQuote() : MutableList<Quote>
}