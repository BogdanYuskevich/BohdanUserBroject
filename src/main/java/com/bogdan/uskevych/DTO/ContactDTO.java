package com.bogdan.uskevych.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactDTO {
    Long id;
    String name;
    List<String> emails;
    List<String> phones;
}
