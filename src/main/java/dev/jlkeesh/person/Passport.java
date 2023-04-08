package dev.jlkeesh.person;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passport {
    private String serial;
    private String number;
}
