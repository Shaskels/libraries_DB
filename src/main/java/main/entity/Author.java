package main.entity;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Please enter author surname")
    @Size(max = 30)
    private String surname;

    @NotEmpty(message = "Please enter author name")
    @Size(max = 30)
    private String name;

    @Size(max = 30)
    private String patronymic;

    private Integer deleted = 0;

    public void setDeleted(){
        this.deleted = 1;
    }

}
