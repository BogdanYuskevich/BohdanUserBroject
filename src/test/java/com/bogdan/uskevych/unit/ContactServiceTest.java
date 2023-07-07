package com.bogdan.uskevych.unit;


import com.bogdan.uskevych.DTO.ContactDTO;
import com.bogdan.uskevych.ModelUtils;
import com.bogdan.uskevych.mapper.ContactMapper;
import com.bogdan.uskevych.model.Contact;
import com.bogdan.uskevych.repository.ContactRepository;
import com.bogdan.uskevych.service.ContactService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ContactServiceTest {
    @InjectMocks
    private ContactService contactService;
    @Mock
    private ContactRepository contactRepository;
    @Mock
    private ContactMapper contactMapper;


    @Test
    void testSave() {
        ContactDTO contactDTO = ModelUtils.createContactDTO();
        Contact contact = ModelUtils.createContact();
        when(contactRepository.findById(anyLong())).thenReturn(Optional.of(contact));
        when(contactMapper.toContact(any())).thenReturn(contact);
        when(contactMapper.toContactDTO(any())).thenReturn(contactDTO);

        ContactDTO result = contactService.save(contactDTO);

        assertEquals(contactDTO, result);
    }

    @Test
    void getAll() {
        ContactDTO contactDTO = ModelUtils.createContactDTO();
        Contact contact = ModelUtils.createContact();
        when(contactRepository.findAll()).thenReturn(List.of(contact));
        when(contactMapper.toContactDTOList(List.of(contact))).thenReturn(List.of(contactDTO));

        List<ContactDTO> result = contactService.getAllContacts();

        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getId()).isEqualTo(ModelUtils.CONTACT_ID);
    }

    @Test
    void deleteContact() {
        doNothing().when(contactRepository).deleteById(anyLong());

        contactService.delete(ModelUtils.CONTACT_ID);

        verify(contactRepository).deleteById(ModelUtils.CONTACT_ID);
    }
}
