package com.example.profileserver.Domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmergencyContact {
    private String firstName;

    private String lastName;

    private String Phone;
}
