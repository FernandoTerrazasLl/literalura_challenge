package Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;
    private String nombreAutor;
    private Integer fechaDeNacimiento;
    private Integer fechaDeFallecimineto;
    @ManyToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;
}
