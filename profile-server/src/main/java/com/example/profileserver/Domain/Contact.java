package com.example.profileserver.Domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Contact {
    private String phone;

    private String email;

    private String address;

    private List<EmergencyContact> emergencyContacts;
}
