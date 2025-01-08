package Models;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="Libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;
    private String titulo;
    private String idioma;
    private Integer numeroDeDescargas;
    @ManyToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores;
}
