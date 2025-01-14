package com.ChallengeAlura.ForoHub.Controller;

import com.ChallengeAlura.ForoHub.domain.topico.DatosRegistroTopico;
import com.ChallengeAlura.ForoHub.domain.topico.RegistroDeTopicos;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private RegistroDeTopicos registro;

    @PostMapping
    @Transactional
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        var detalleTopico = registro.registrarTopico(datosRegistroTopico);
        return ResponseEntity.ok(detalleTopico);
    }

}
