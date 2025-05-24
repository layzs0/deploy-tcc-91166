package com.example.jogadoresBackend.controller;

import com.example.jogadoresBackend.models.Jogador;
import com.example.jogadoresBackend.services.JogadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/jogador")
public class jogadorController {

    private JogadorService jogadorService;

    public jogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public List<Jogador> listarJogadores(){
       return jogadorService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody Jogador jogador) {
        jogadorService.salvar(jogador);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Jogador Salvo com sucesso"));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@RequestBody Jogador jogador) {
        jogadorService.atualizar(jogador);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Jogador atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        jogadorService.excluir(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem", "Jogador Excluido com sucesso"));
    }

}
