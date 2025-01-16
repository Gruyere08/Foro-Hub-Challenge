package com.ChallengeAlura.ForoHub.Controller;

import com.ChallengeAlura.ForoHub.domain.topico.*;
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

    @Autowired
    private ActualizacionDeTopicos actualizacionDeTopicos;

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


    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornarDatosTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }


    @PutMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@PathVariable Long id, @RequestBody DatosActualizacionTopico datos){
        var topico = actualizacionDeTopicos.actualizarTopico(datos, id);
        return ResponseEntity.ok(topico);
    }



}
