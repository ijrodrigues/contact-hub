package club.contact.contactmanager.domain

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Contact(
    @ManyToOne
    @JoinColumn(name="contact_hub_id")
    val contactHub: ContactHub,
    val description: String,
    val icon: String,
    val linkToRedirect: String,
    @Id
    val id: String = UUID.randomUUID().toString()
)
