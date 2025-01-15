package com.ChallengeAlura.ForoHub.Controller;

import com.ChallengeAlura.ForoHub.domain.topico.DatosListadoTopico;
import com.ChallengeAlura.ForoHub.domain.topico.DatosRegistroTopico;
import com.ChallengeAlura.ForoHub.domain.topico.RegistroDeTopicos;
import com.ChallengeAlura.ForoHub.domain.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private RegistroDeTopicos registro;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        var detalleTopico = registro.registrarTopico(datosRegistroTopico);
        return ResponseEntity.ok(detalleTopico);
    }


    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(topicoRepository.findAll(pageable).map(DatosListadoTopico::new));
    }




}
