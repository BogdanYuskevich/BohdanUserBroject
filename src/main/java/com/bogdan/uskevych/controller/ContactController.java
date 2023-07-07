package com.bogdan.uskevych.controller;

import com.bogdan.uskevych.DTO.ContactDTO;
import com.bogdan.uskevych.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @GetMapping
    List<ContactDTO> getAll() {
        return contactService.getAllContacts();
    }

    @PostMapping
    ContactDTO createContact(@Valid @RequestBody ContactDTO contactDTO) {
        return contactService.save(contactDTO);
    }

    @PutMapping
    ContactDTO updateContact(@Valid @RequestBody ContactDTO contactDTO) {
        return contactService.save(contactDTO);
    }

    @DeleteMapping("/{id}")
    void deleteContact(@PathVariable Long id) {
        contactService.delete(id);
    }
}
