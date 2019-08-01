package com.root.inmobiliaria.repository.interfaces

import com.root.inmobiliaria.domain.Quote

interface QuoteRepository {
    fun searchQuote() : MutableList<Quote>
    fun updateQuote()
}