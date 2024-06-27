package com.example.myticketsystem.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Admin extends User {
    @OneToMany(mappedBy = "admin")
    @JsonIgnore
    private Set< Apprenant> apprenant;
    @OneToMany(mappedBy ="admin" )
    @JsonIgnore
    private Set<Formateur> formateurs;
}
