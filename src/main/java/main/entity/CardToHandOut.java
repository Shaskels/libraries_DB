package main.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cardtohandout")
public class CardToHandOut extends LibraryCard{

    @NotEmpty
    private Boolean returned;

    @NotEmpty
    private Date periodforissuing;
}
