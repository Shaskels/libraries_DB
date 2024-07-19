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
@Table(name = "pupils")
public class Pupils extends User {

    @NotEmpty
    @Size(max=255)
    private String schoolname;

    @NotEmpty
    @Column(name = "class")
    private Integer classNum;

    private Character letter;

}
