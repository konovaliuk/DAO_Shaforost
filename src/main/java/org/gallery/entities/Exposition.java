package org.gallery.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Exposition {
    Long id;
    String name;
    String description;
    String showroom;


}
