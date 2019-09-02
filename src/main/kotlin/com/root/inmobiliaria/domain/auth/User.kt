package com.root.inmobiliaria.domain.auth

import com.root.inmobiliaria.domain.Position
import com.root.inmobiliaria.form.UserForm
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
@Table(name="user", schema = "public")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_u_code_seq")
    @SequenceGenerator(sequenceName = "user_u_code_seq",  name = "user_u_code_seq")
    @Column(name = "u_code")
    var code: Int = 0,

        @Column(name = "u_email")
    var email: String = "",

        @Column(name = "u_username")
    var username: String = "",

        @Column(name = "u_password")
    var password: String = "",

        @Column(name = "u_account_type")
    var accountType : Int = 1,

        @Column(name = "u_profile_photo")
    var profilePic : String = "",

        @Column(name = "u_token_verification")
    var tokenVerify : String = "",

        @Column(name = "u_token_reset")
    var tokenReset : String = "",

        @Column(name = "u_favorites", columnDefinition = "int[]")
    var favorites : IntArray= intArrayOf(),

        @Column(name = "u_unliked", columnDefinition = "int[]")
    var unliked : IntArray= intArrayOf(),

        @Column(name = "u_active")
    var active : Boolean = true,

        @Column(name = "u_date_created",  insertable=false)
    var dateCreated : String = "",

        @Column(name = "u_last_updated")
    var lastUpdated : Int = 1
)
{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (!favorites.contentEquals(other.favorites)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = favorites.hashCode()
        result = 31 * result + favorites.contentHashCode()
        return result
    }
}