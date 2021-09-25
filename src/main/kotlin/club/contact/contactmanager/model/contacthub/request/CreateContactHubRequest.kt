package club.contact.contactmanager.model.contacthub.request

import club.contact.contactmanager.domain.Contact
import club.contact.contactmanager.domain.ContactHub

data class CreateContactHubRequest(
    val title: String,
    val description: String,
    val profilePhotoUrl: String,
    val contacts: List<CreateContactRequest>
){
    fun toContactHub(): ContactHub {
        val contactHub = ContactHub(title, description, profilePhotoUrl)
        contactHub.contacts.addAll(this.contacts.map { it.toContact(contactHub) })
        return contactHub
    }
}

data class CreateContactRequest(
    val description: String,
    val icon: String,
    val linkToRedirect: String
){
    fun toContact(contactHub: ContactHub): Contact {
        return Contact(contactHub, description, icon, linkToRedirect)
    }
}
