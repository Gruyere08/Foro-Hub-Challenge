package com.ChallengeAlura.ForoHub.domain.topico;

import com.ChallengeAlura.ForoHub.domain.status.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record DatosRegistroTopico(
        @NotBlank(message = "Se requiere un titulo (titulo)")
        @Size(min = 5, max = 100, message = "El titulo debe tener entre 5 y 100 caracteres")
        String titulo,

        @NotBlank(message = "Message is required (mensaje)")
        @Size(min = 10, max = 5000,message = "El mensaje debe tener entre 10 y 5000 caracteres")
        String mensaje,

        @NotNull(message = "La fecha de creación es requerida (fechaCreacion)")
        Date fechaCreacion,

        @NotNull(message = "Se requiere el status inicial (status)")
        Status status,

        @NotNull(message = "se requiere la ID del autor (autorID)")
        Long autorId


) {
}
