package com.ChallengeAlura.ForoHub.domain.respuesta;


import com.ChallengeAlura.ForoHub.domain.topico.Topico;
import com.ChallengeAlura.ForoHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "Respuesta")
@Table(name = "respuestas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    private Boolean solucion = false;

    // Getters and Setters
}

