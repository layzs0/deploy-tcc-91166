package com.example.jogadoresBackend.services;

import com.example.jogadoresBackend.models.Jogador;
import com.example.jogadoresBackend.repository.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    private JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public List<Jogador> listarTodos(){
        return jogadorRepository.findAll();
    }

    public Jogador salvar(Jogador jogador){
        if (jogadorRepository.findById(jogador.getId()).isPresent()){
            throw new RuntimeException("Jogador já Cadastrado");
        }

        return jogadorRepository.save(jogador);
    }

    public Jogador atualizar(Jogador jogador){
        Jogador jogadorAtualizar = jogadorRepository.findById(jogador.getId())
                .orElseThrow(() -> new RuntimeException("Jogador não cadastrado"));

        jogadorAtualizar.setNome(jogador.getNome());
        jogadorAtualizar.setSexo(jogador.getSexo());
        jogadorAtualizar.setIdade(jogador.getIdade());
        jogadorAtualizar.setAltura(jogador.getAltura());
        jogadorAtualizar.setPeso(jogador.getPeso());
        jogadorAtualizar.setPosicao(jogador.getPosicao());
        jogadorAtualizar.setNumeroDaCamisa(jogador.getNumeroDaCamisa());
        return jogadorRepository.save(jogadorAtualizar);
    }

    public void excluir(Long id){
        Jogador jogadorAtualizar = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não cadastrado"));

        jogadorRepository.deleteById(id);
    }
}
