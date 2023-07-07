package com.bogdan.uskevych.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "name")
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> emails = new ArrayList<>();

    public void addEmail(Email email) {
        email.setContact(this);
        emails.add(email);
    }

    public void removeEmail(Email email) {
        email.setContact(null);
        emails.remove(email);
    }

    @ToString.Exclude
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();

    public void addPhoneNumber(Phone phone) {
        phone.setContact(this);
        phones.add(phone);
    }

    public void removePhoneNumber(Phone phone) {
        phone.setContact(null);
        phones.remove(phone);
    }
}
