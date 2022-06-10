package org.gallery.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tickets {

    long id;
    long userId;
    long expositionId;
    long price;


}
