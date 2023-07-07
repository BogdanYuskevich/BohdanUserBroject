package com.bogdan.uskevych;

import com.bogdan.uskevych.DTO.ContactDTO;
import com.bogdan.uskevych.model.Contact;
import com.bogdan.uskevych.model.Email;
import com.bogdan.uskevych.model.Phone;

import java.util.ArrayList;
import java.util.List;

public class ModelUtils {
    public static final Long CONTACT_ID = 1L;
    public static final String CONTACT_NAME = "Bohdan";
    public static final Long EMAIL_ID = 1L;
    public static final String EMAIL = "xxx2345x@xxxx.com";
    public static final Long PHONE_ID = 1L;
    public static final String PHONE = "+380979607116";

    public static Contact createContact() {
        var email = Email.builder()
                .id(EMAIL_ID)
                .email(EMAIL)
                .build();
        var phone = Phone.builder()
                .id(PHONE_ID)
                .phone(PHONE)
                .build();
        var contact = Contact.builder()
                .id(CONTACT_ID)
                .name(CONTACT_NAME)
                .build();
        contact.setEmails(new ArrayList<>());
        contact.addEmail(email);
        contact.setPhones(new ArrayList<>());
        contact.addPhoneNumber(phone);
        return contact;
    }

    public static ContactDTO createContactDTO() {
        return ContactDTO.builder()
                .id(CONTACT_ID)
                .name(CONTACT_NAME)
                .emails(List.of(EMAIL))
                .phones(List.of(PHONE))
                .build();
    }
}