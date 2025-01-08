package Models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDato(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Integer anoNacimiento,
        @JsonAlias("death_year") Integer anoMuerte
){}
