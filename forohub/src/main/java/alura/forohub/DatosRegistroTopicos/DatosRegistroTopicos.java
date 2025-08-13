package alura.forohub.DatosRegistroTopicos;

import jakarta.validation.constraints.NotBlank;

public class DatosRegistroTopicos {
    @NotBlank
    private String titulo;
    @NotBlank
    private String mensaje;
    @NotBlank
    private String nombreCurso;
    @NotBlank
    private String autor; // <-- asegúrate de tenerlo aquí
}


