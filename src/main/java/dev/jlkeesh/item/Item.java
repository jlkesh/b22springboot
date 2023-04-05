package dev.jlkeesh.item;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    private Integer id;
    private String name;
    private String description;
    private double price;
}
