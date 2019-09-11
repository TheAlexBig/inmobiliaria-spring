package com.root.inmobiliaria.domain

import com.root.inmobiliaria.domain.auth.User
import com.vladmihalcea.hibernate.type.array.IntArrayType
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name="profile", schema = "public")
@TypeDefs(
        TypeDef(name = "int-array", typeClass = IntArrayType::class),
        TypeDef(name="jsonb", typeClass = JsonBinaryType::class)
)
data class Profile (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Type(type="pg-uuid")
        @Column(name = "p_code",  insertable=false)
        var code: UUID? = null,

        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_p_id_seq")
        @SequenceGenerator(sequenceName = "profile_p_id_seq",  name = "profile_p_id_seq", initialValue = 1, allocationSize = 1)
        @Column(name= "p_id")
        var localId : Int? = null,

        @Column(name = "p_profile_photo")
        var profilePhoto: String = "",

        @Column(name = "p_address")
        @Type(type = "jsonb")
        var address : JsonBinaryType ?= null,

        @Column(name = "p_document")
        @Type(type = "jsonb")
        var document : JsonBinaryType ?= null,

        @Column(name = "p_phone")
        @Type(type = "jsonb")
        var phone : JsonBinaryType ?= null,

        @Column(name = "p_names")
        var names : String ? = null,

        @Column (name = "p_lastanmes")
        var lastNames : String ?= null,

        @Column(name = "p_sex")
        var sex  : Boolean = false,

        @Column(name = "p_currently_hired")
        var hired  : Boolean = false,

        @Column(name = "u_last_updated")
        var lastUpdated : String ?= null,

        @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        @JoinColumn(name = "u_code")
        var user : User ?=null

) : Serializable
{

}