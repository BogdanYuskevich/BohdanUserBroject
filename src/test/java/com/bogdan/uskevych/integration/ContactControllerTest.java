package com.bogdan.uskevych.integration;

import com.bogdan.uskevych.DTO.ContactDTO;
import com.bogdan.uskevych.ModelUtils;
import com.bogdan.uskevych.mapper.ContactMapper;
import com.bogdan.uskevych.model.Contact;
import com.bogdan.uskevych.repository.ContactRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "User", roles = {"ADMIN"})
class ContactControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @AfterEach
    public void resetDb() {
        contactRepository.deleteAll();
    }

    @Test
    void getAll() throws Exception {
        Contact contact = contactRepository.save(ModelUtils.createContact());

        mockMvc
                .perform(get("/contacts"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(contact.getId()))
                .andExpect(jsonPath("$[0].name").value(contact.getName()));
    }


    @Test
    void createContact() throws Exception {
        ContactDTO contactDTO = ModelUtils.createContactDTO();

        mockMvc.perform(
                        post("/contacts")
                                .content(objectMapper.writeValueAsString(contactDTO))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(contactDTO.getName()));
    }

    @Test
    void removeContact() throws Exception {
        Contact contact = contactRepository.save(ModelUtils.createContact());

        mockMvc.perform(
                        delete("/contacts/{id}", contact.getId()))
                .andExpect(status().isOk());
    }
}