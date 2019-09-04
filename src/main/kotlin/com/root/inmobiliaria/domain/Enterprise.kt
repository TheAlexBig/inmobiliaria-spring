package com.root.inmobiliaria.domain

import com.root.inmobiliaria.domain.auth.User
import com.vladmihalcea.hibernate.type.array.IntArrayType
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import java.util.*
import javax.persistence.*


@Entity(name = "enterprise")
@Table(name = "enterprise" , schema = "public")
@TypeDefs(
        TypeDef(name = "int-array", typeClass = IntArrayType::class),
        TypeDef(name="jsonb", typeClass = JsonBinaryType::class)
)
data class Enterprise(
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Type(type="pg-uuid")
        @Column(name = "c_code")
        var code : UUID?= null,

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enterprise_e_id_seq")
        @SequenceGenerator(sequenceName = "enterprise_e_id_seq",  name = "enterprise_e_id_seq", initialValue = 1, allocationSize = 1)
        @Column(name= "c_id")
        var id : Int ? = null,

        @Column(name = "u_code")
        var account : User?= null,

        @Column(name = "e_address")
        @Type(type = "jsonb")
        var address : JsonBinaryType ?= null,

        @Column(name = "e_document")
        @Type(type = "jsonb")
        var document : JsonBinaryType ? =null,

        @Column(name = "e_name")
        var name : String = "",

        @Column(name ="e_active_enterprise")
        var active : Boolean = true,

        @Column(name ="e_last_updated")
        var lastUpdate : String = "Never"

        ){

}