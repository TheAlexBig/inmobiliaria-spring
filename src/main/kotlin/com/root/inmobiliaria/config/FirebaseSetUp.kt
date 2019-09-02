package com.root.inmobiliaria.config
/*
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.FirestoreOptions
import com.google.cloud.firestore.WriteResult
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.io.FileInputStream
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport

import com.google.api.client.json.jackson2.JacksonFactory
import com.google.auth.oauth2.GoogleCredentials
import java.io.File


@Component
data class FirebaseSetUp(
    var serviceAccount : FileInputStream ?= null,
    var firestore : Firestore ?=null

){
    @Bean
     fun db(){
        val initialFile = File("firebasekey.json")
        val inputStream = FileInputStream(initialFile)


        val fireStoreOptions = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(inputStream))
                .setTimestampsInSnapshotsEnabled(true).build()

        firestore = fireStoreOptions.service
        }
    }

*/