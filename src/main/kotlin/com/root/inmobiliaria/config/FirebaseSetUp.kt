package com.root.inmobiliaria.config

import com.google.api.core.ApiFuture
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.FirestoreOptions
import com.google.cloud.firestore.WriteResult
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.io.FileInputStream

@Component
data class FirebaseSetUp(
    var serviceAccount : FileInputStream ?= null,
    var firestore : Firestore ?=null

){
    @Bean
     fun db(){
        serviceAccount = FileInputStream("./firebasekey.json")

        val fireStoreOptions = FirestoreOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream((serviceAccount)))
                .setTimestampsInSnapshotsEnabled(true).build()

        firestore = fireStoreOptions.service

        val quote : HashMap<String, String> = hashMapOf("quote" to "AlexBig is Big 2", "author" to "AlexBig 2")
        val future : ApiFuture<WriteResult> = fireStoreOptions.service.collection("sampledata")
               .document("inspiration2").set(quote as Map<String, Any>)
        println("Successfully updated at: " + future.get().updateTime)
        }
    }

