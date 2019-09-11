package com.root.inmobiliaria.domain.auth

import com.root.inmobiliaria.domain.Profile
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import javax.persistence.*
import com.vladmihalcea.hibernate.type.array.IntArrayType
import org.hibernate.annotations.Type
import java.io.Serializable
import java.util.*


@Entity
@Table(name="user", schema = "public")
@TypeDefs(
        TypeDef(name = "int-array", typeClass = IntArrayType::class),
        TypeDef(name="jsonb", typeClass = JsonBinaryType::class)
    )
data class User (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Type(type = "pg-uuid")
        @Column(name = "u_code", insertable = false)
        var code: UUID? = null,

        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_u_id_seq")
        @SequenceGenerator(sequenceName = "user_u_id_seq", name = "user_u_id_seq", initialValue = 1, allocationSize = 1)
        @Column(name = "u_id", insertable = false)
        var localId: Int? = null,

        @Column(name = "u_email")
        var email: String = "",

        @Column(name = "u_username")
        var username: String = "",

        @Column(name = "u_password")
        var password: String = "",

        @Column(name = "u_account_type")
        var accountType: Int = 1,


        @Column(name = "u_token_verification")
        var tokenVerify: String = "",

        @Column(name = "u_token_reset")
        var tokenReset: String = "",

        @Type(type = "int-array")
        @Column(name = "u_favorites", columnDefinition = "integer[]")
        var favorites: IntArray = intArrayOf(),

        @Type(type = "int-array")
        @Column(name = "u_not_liked", columnDefinition = "integer[]")
        var unliked: IntArray = intArrayOf(),

        @Column(name = "u_active")
        var active: Boolean = true,

        @Column(name = "u_date_created", insertable = false)
        var dateCreated: String = "",

        @Column(name = "u_last_updated")
        var lastUpdated: String? = null,

        @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "user")
        var profile : Profile ?=null
) : Serializable
{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (favorites.contentEquals(other.favorites)) return true
        if (unliked.contentEquals(other.unliked)) return true

        return false
    }

    override fun hashCode(): Int {
        var result = favorites.hashCode()
        result = 31 * result + favorites.contentHashCode()
        return result
    }
}