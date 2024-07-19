package main.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(max = 30)
    private String surname;

    @NotEmpty
    @Size(max = 30)
    private String name;

    @Size(max = 30)
    private String patronymic;


    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "library")
    private Library library;

    private Integer deleted = 0;
    public void setDeleted(){
        this.deleted = 1;
    }

}
