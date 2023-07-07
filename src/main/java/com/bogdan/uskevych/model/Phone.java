package com.bogdan.uskevych.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "phone")
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    @Pattern(regexp = "(\\+380)[0-9]{9}")
    private String phone;

    @ManyToOne(optional = false)
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
