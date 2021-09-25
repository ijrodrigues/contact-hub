package club.contact.contactmanager.repository

import club.contact.contactmanager.domain.ContactHub
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactHubRepository : JpaRepository<ContactHub, String>
