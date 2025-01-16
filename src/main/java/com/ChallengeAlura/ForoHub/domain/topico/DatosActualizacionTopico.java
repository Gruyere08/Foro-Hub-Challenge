package com.ChallengeAlura.ForoHub.domain.topico;

import com.ChallengeAlura.ForoHub.domain.status.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record DatosActualizacionTopico(
        @Size(min = 5, max = 100, message = "El titulo debe tener entre 5 y 100 caracteres")
        String titulo,

        @Size(min = 10, max = 5000,message = "El mensaje debe tener entre 10 y 5000 caracteres")
        String mensaje,

        Date fechaCreacion,

        Status status,

        Long autorId


) {
}
