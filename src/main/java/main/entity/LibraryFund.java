package main.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "libraryfund")
@Inheritance(strategy = InheritanceType.JOINED)
public class LibraryFund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 30)
    private String name;

    @NotEmpty
    private Integer shelf;

    @NotEmpty
    private Integer rack;

    @NotEmpty
    private Boolean tohandout;

    @NotEmpty
    private Boolean given;

    @NotEmpty
    private Date dateofreceipt;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name="readingrooms")
    private ReadingRoom readingrooms;

    private Integer deleted = 0;
    public void setDeleted(){
        this.deleted = 1;
    }
}
