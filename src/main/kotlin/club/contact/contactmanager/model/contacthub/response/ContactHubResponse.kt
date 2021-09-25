package club.contact.contactmanager.model.contacthub.response

import club.contact.contactmanager.domain.ContactHub

data class ContactHubResponse(
    val id: String,
    val title: String,
    val description: String,
    val profilePhotoUrl: String,
    val contacts: List<ContactResponse>,

    ) {
    companion object {
        fun from(contactHub: ContactHub): ContactHubResponse {
            return ContactHubResponse(
                contactHub.id,
                contactHub.title,
                contactHub.description,
                contactHub.profilePhotoUrl,
                toContactsResponse(contactHub)
            )
        }

        private fun toContactsResponse(contactHub: ContactHub) =
            contactHub.contacts.map { ContactResponse(it.description, it.icon, it.linkToRedirect) }
    }
}

data class ContactResponse(
    val description: String,
    val icon: String,
    val linkToRedirect: String
)
