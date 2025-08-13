package alura.forohub.Controller;
import alura.forohub.Model.Topico;
import alura.forohub.Service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<Topico> listarTopicos() {
        return topicoService.listarTodos();
    }

    // ✅ CORREGIDO: Removido /{id} para crear nuevo tópico
    @PostMapping
    public ResponseEntity<?> registrarTopico(@Valid @RequestBody Topico topico) {
        try {
            Topico nuevoTopico = topicoService.guardar(topico);
            return new ResponseEntity<>(nuevoTopico, HttpStatus.CREATED);
        } catch (Exception e) {
            // ✅ CORREGIDO: Tipo de retorno consistente
            return new ResponseEntity<>("Error al registrar el tópico: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTopicoPorId(@PathVariable Long id) {
        Optional<Topico> topico = topicoService.obtenerPorId(id);
        if (topico.isPresent()) {
            return new ResponseEntity<>(topico.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Tópico no encontrado con ID: " + id, HttpStatus.NOT_FOUND);
    }

    // ✅ CORREGIDO: Agregado /{id} al mapping
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTopico(@PathVariable Long id, @Valid @RequestBody Topico topicoActualizado) {
        Optional<Topico> topicoExistente = topicoService.obtenerPorId(id);
        if (topicoExistente.isPresent()) {
            Topico topico = topicoExistente.get();
            topico.setMensaje(topicoActualizado.getMensaje());
            topico.setNombreCurso(topicoActualizado.getNombreCurso());
            topico.setTitulo(topicoActualizado.getTitulo());
            topico.setAutor(topicoActualizado.getAutor());
            topico.setFechaCreacion(topicoActualizado.getFechaCreacion());
            topicoService.guardar(topico);
            return new ResponseEntity<>(topico, HttpStatus.OK);
        }
        return new ResponseEntity<>("Tópico no encontrado para actualizar con ID: " + id, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTopico(@PathVariable Long id) {
        try {
            topicoService.eliminar(id);
            return ResponseEntity.ok("Tópico eliminado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo eliminar el tópico con ID: " + id);
        }
    }
}