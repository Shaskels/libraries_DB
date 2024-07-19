package main.entity;

import javax.persistence.Entity;

import javax.persistence.Table;
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
@Table(name = "workers")
public class Workers extends User {

    @NotEmpty
    @Size(max=255)
    private String organizationname;

    @NotEmpty
    @Size(max = 255)
    private String specialization;
}
