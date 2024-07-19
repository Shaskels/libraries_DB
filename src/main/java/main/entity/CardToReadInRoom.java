package main.entity;

import javax.persistence.Entity;

import javax.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cardtoreadinroom")
public class CardToReadInRoom extends LibraryCard {

    @NotEmpty
    private Time timeofissue;

    @NotEmpty
    private Time returntime;
}
