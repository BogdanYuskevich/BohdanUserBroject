package com.bogdan.uskevych.service;

import com.bogdan.uskevych.DTO.ContactDTO;
import com.bogdan.uskevych.mapper.ContactMapper;
import com.bogdan.uskevych.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public List<ContactDTO> getAllContacts() {
        var contacts = contactRepository.findAll();
        return contactMapper.toContactDTOList(contacts);
    }

    public ContactDTO save(ContactDTO contactDTO) {
        if (contactDTO.getId() != null) {
            var contact = contactRepository.findById(contactDTO.getId());
            contact.ifPresent( c -> {
                c.getEmails().clear();
                c.getPhones().clear();
                contactRepository.save(c);
            });
        }
        var contact = contactMapper.toContact(contactDTO);
        contact.getEmails().stream().forEach( e -> e.setContact(contact));
        contact.getPhones().stream().forEach( p -> p.setContact(contact));
        var saved = contactRepository.save(contact);
        return contactMapper.toContactDTO(saved);
    }

    public void delete(Long contactId) {
        contactRepository.deleteById(contactId);
    }
}
