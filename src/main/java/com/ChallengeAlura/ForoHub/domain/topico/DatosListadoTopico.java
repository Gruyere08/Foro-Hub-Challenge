package com.ChallengeAlura.ForoHub.domain.topico;

import com.ChallengeAlura.ForoHub.domain.status.Status;

import java.util.Date;

public record DatosListadoTopico(
        String titulo,
        String mensaje,
        Date fechaCreacion,
        Status status,
        Long autorId
) {
    // Constructor that accepts a Topico object
    public DatosListadoTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getId()
        );
    }
}

