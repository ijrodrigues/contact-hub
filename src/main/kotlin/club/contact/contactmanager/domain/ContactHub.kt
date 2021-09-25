package club.contact.contactmanager.domain

import java.util.UUID.randomUUID
import javax.persistence.CascadeType.ALL
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class ContactHub(
    val title: String,
    val description: String,
    val profilePhotoUrl: String,
    @OneToMany(mappedBy = "contactHub", orphanRemoval = true, cascade = [ALL])
    val contacts: MutableList<Contact> = ArrayList(),
    @Id
    val id: String = randomUUID().toString()
) {
    override fun toString(): String {
        return "ContactHub(title='$title', " +
                "description='$description'," +
                " profilePhotoUrl='$profilePhotoUrl', " +
                " id='$id')"
    }
}
