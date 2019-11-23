package nl.fontys.tictactoe.Models;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bericht {
    private int id;
    private Date time;
    private String message;
}
