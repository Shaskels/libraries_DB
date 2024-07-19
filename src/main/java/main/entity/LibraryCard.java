package main.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "librarycard")
@Inheritance(strategy = InheritanceType.JOINED)
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private Date dateofissue;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "libraryfund")
    private LibraryFund libraryfund;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name="librarian")
    private Librarians librarian;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name="users")
    private User users;

    private Integer deleted = 0;
    public void setDeleted(){
        this.deleted = 1;
    }
}
