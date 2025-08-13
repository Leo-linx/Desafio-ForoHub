package alura.forohub.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Data // Genera getters, setters, toString, etc. (Lombok)
@NoArgsConstructor // Genera un constructor sin argumentos (requerido por JPA)

public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El mensaje no puede estar vacío")
    @Column(nullable = false)
    private String mensaje;

    @NotBlank(message = "El nombre del curso no puede estar vacío")
    @Column(nullable = false)
    private String nombreCurso;

    @NotBlank(message = "El título no puede estar vacío")
    @Column(nullable = false, unique = true)
    private String titulo;

    @NotBlank(message = "El autor no puede estar vacío")
    @Column(nullable = false)
    private String autor;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    public Topico(String s, HttpStatus httpStatus) {
    }

    @PrePersist
    protected void onCreate() {this.fechaCreacion = LocalDateTime.now();
  }
}



