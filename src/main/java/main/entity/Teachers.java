package main.entity;

import javax.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "teachers")
public class Teachers extends User{

    @NotEmpty
    @Size(max=255)
    private String nameoftheeducationalintitution;

    @NotEmpty
    @Size(max=255)
    private String subject;

    @Size(max = 255)
    private String post;

}