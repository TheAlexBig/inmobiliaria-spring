package com.root.inmobiliaria.domain

import com.root.inmobiliaria.domain.auth.User
import com.vladmihalcea.hibernate.type.array.IntArrayType
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import org.hibernate.annotations.*
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Table


@Entity(name = "client")
@Table(name = "visual" , schema = "public")
@TypeDefs(
        TypeDef(name = "int-array", typeClass = IntArrayType::class),
        TypeDef(name="jsonb", typeClass = JsonBinaryType::class)
)
data class Client(
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Type(type="pg-uuid")
        @Column(name = "c_code")
        var code : UUID ?= null,

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_c_id_seq")
        @SequenceGenerator(sequenceName = "client_c_id_seq",  name = "client_c_id_seq", initialValue = 1, allocationSize = 1)
        @Column(name= "c_id")
        var id : Int ? = null,

        @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
         @JoinColumn(name ="u_code")
         var account : User?= null,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name ="e_code")
        var enterprise : Enterprise?= null,

        @Column(name = "c_profile_photo")
        var profilePic : String = "",

        @Column(name = "c_address")
        @Type(type = "jsonb")
        var address : JsonBinaryType ?= null,

        @Column(name = "d_document")
        @Type(type = "jsonb")
        var document : JsonBinaryType ?= null,

        @Column(name = "c_names")
        var names : String ? = null,

        @Column (name = "c_lastanmes")
        var lastNames : String ?= null,

        @Column(name = "c_sex")
        var sex  : Boolean = false,

        @Column(name = "c_last_updated")
        var lastUpdate : String = "Never"

        ) : Serializable
{
    fun delegateEnterprise (): Boolean{
        if(enterprise!=null){
            return true
        }
        return false
    }
}