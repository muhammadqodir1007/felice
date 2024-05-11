package uz.fazo.felice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fazo.felice.payload.ContactDto;
import uz.fazo.felice.service.ContactService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;


    @GetMapping
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        List<ContactDto> contacts = contactService.findAll();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable Long id) {
        ContactDto contactDto = contactService.findById(id);
        return ResponseEntity.ok(contactDto);
    }

    @PostMapping
    public ResponseEntity<ContactDto> addContact(@RequestBody ContactDto contactDto) {
        ContactDto savedContact = contactService.save(contactDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDto> updateContact(@PathVariable Long id, @RequestBody ContactDto contactDto) {
        ContactDto updatedContact = contactService.update(id, contactDto);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
