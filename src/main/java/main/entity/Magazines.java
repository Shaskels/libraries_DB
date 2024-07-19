package main.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "magazines")
public class Magazines extends LibraryFund{

    @NotEmpty
    @Size(max = 30)
    private String frequency;

    @NotEmpty
    @Size(max = 30)
    private String format;

    @NotEmpty
    @Size(max = 30)
    private String thematics;
}
