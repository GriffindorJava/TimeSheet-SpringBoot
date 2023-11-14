package com.example.profileserver.Domain;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Profile {
    @Id
    private String id;

    private String name;

    private Contact contact;

    private Integer remainingFloatingDay;

    private Integer remainingVacationDay;

    private String profileAvatar;

    private List<DailyTimesheet> weeklyTimesheetTemplate;
}