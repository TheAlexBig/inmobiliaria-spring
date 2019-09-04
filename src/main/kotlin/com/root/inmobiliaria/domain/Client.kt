package com.root.inmobiliaria.domain

import com.root.inmobiliaria.domain.auth.User
import com.vladmihalcea.hibernate.type.array.IntArrayType
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import java.util.*
import javax.persistence.*


@Entity(name = "client")
@Table(name = "client" , schema = "public")
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

        @Column(name = "u_code")
        var account : User?= null,

        @Column(name = "e_code")
        var enterprise : Enterprise?= null,

        //TODO Not as intended just filled
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

        )
{
    fun delegateEnterprise (): Boolean{
        if(enterprise!=null){
            return true
        }
        return false
    }
}