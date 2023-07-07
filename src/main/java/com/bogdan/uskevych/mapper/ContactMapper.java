package com.bogdan.uskevych.mapper;

import com.bogdan.uskevych.DTO.ContactDTO;
import com.bogdan.uskevych.model.Contact;
import com.bogdan.uskevych.model.Email;
import com.bogdan.uskevych.model.Phone;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact toContact(ContactDTO contactDTO);
    ContactDTO toContactDTO(Contact contact);
    List<Contact> toContactList(List<ContactDTO> contactDTOS);
    List<ContactDTO> toContactDTOList(List<Contact> contacts);

    List<Email> toEmailList(List<String> value);
    List<String> fromEmailList(List<Email> value);

    default Email toEmail(String value) {
        return Email.builder().email(value).build();
    }

    default String fromEmail(Email email) {
        return email.getEmail();
    }

    List<Phone> toPhoneList(List<String> value);
    List<String> fromPhoneList(List<Phone> value);

    default Phone toPhone(String value) {
        return Phone.builder().phone(value).build();
    }

    default String fromPhone(Phone phone) {
        return phone.getPhone();
    }
}

