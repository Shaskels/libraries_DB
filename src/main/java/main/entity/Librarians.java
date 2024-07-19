package main.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "librarians")
public class Librarians {

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
    @JoinColumn(name = "readingrooms")
    private ReadingRoom readingrooms;

    @Size(max = 30)
    private String login;

    @Size(max = 30)
    private String password;

    private Integer deleted = 0;
    public void setDeleted(){
        this.deleted = 1;
    }

}
