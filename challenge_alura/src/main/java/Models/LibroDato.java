package Models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDato (
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AutorDato> autor,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("download_count") Integer numeroDeDescargas
){}
