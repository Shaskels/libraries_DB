package main.entity;

import javax.persistence.Entity;

import javax.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pensioners")
public class Pensioners extends User{

    @NotEmpty
    @Size(max=255)
    private String pensioncertificatenumber;

    private Integer age;
}
