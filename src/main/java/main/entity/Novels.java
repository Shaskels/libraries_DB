package main.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "novels")
public class Novels extends LibraryFund {


    @NotEmpty
    @Column(columnDefinition = "smallint", name = "type")
    private Short typeOfNovel;
}
