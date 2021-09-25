package club.contact.contactmanager.controller

import club.contact.contactmanager.model.contacthub.request.CreateContactHubRequest
import club.contact.contactmanager.model.contacthub.response.ContactHubResponse
import club.contact.contactmanager.model.contacthub.response.ContactHubResponse.Companion.from
import club.contact.contactmanager.model.contacthub.response.IdResponse
import club.contact.contactmanager.repository.ContactHubRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.notFound
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/hubs")
class ContactHubController(
    private val contactHubRepository: ContactHubRepository
    ) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun create(@RequestBody @Valid request: CreateContactHubRequest): IdResponse {
        val contactHub = contactHubRepository.save(request.toContactHub())
        return IdResponse(contactHub.id)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: String): ResponseEntity<ContactHubResponse> {
        val contactHub = contactHubRepository.findByIdOrNull(id) ?: return notFound().build()
        return ResponseEntity.ok().body(from(contactHub))
    }
}
