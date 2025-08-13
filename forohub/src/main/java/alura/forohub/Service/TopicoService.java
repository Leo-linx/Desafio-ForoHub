package alura.forohub.Service;

import alura.forohub.Model.Topico;
import alura.forohub.Repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    // Inyección por constructor (recomendada)
    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    // Eliminar Topico
    public void eliminar(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new IllegalArgumentException("No se encontró el tópico con ID: " + id);
        }
        topicoRepository.deleteById(id);
    }

    public List<Topico> listarTodos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> obtenerPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public Topico guardar(Topico topico) {
        return topicoRepository.save(topico);
    }

    public Topico actualizar(Long id, Topico datos) {
        return topicoRepository.findById(id)
                .map(existing -> {
                    existing.setTitulo(datos.getTitulo());
                    existing.setMensaje(datos.getMensaje());
                    // actualiza otros campos según tu entidad
                    return topicoRepository.save(existing);
                })
                .orElseGet(() -> {
                    // Si prefieres lanzar excepción en vez de crear, cámbialo
                    datos.setId(id);
                    return topicoRepository.save(datos);
                });

}
}