package main.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "literaryworks")
public class LiteraryWorks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Please enter name of Literary work")
    @Size(max=255)
    private String name;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "authors")
    private Author authors;

    private Integer deleted = 0;
    public void setDeleted(){
        this.deleted = 1;
    }

}
