package co.s4n.example.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private Integer id;
    private String name;
    private LocalDate birthdate;
}
