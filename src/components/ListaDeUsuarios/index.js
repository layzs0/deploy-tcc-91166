// src/components/ListaDejogadores/index.js

import { useState, useEffect } from "react";
import axios from "axios";
import './styles.css';

function ListaDejogadores() {
    const [jogadores, setJogadores] = useState([]);

    useEffect(() => {
        const carregarjogadores = async () => {
            try {
                const response = await axios.get('http://localhost:8080/jogador');
                setJogadores(response.data);
            } catch (error) {
                alert('Erro ao buscar usuários');
                setJogadores([]);
            }
        };
        carregarjogadores();
    }, []);

    return (
        <div className="tabela-container">

            {jogadores.length === 0 ? (
                <p className="mensagem">Nenhum jogador encontrado.</p>
            ) : (
                <table className="tabela-jogadores">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Sexo</th>
                            <th>Idade</th>
                            <th>Altura</th>
                            <th>Peso</th>
                            <th>Posição</th>
                            <th>Nº Camisa</th>
                        </tr>
                    </thead>
                    <tbody>
                        {jogadores.map((jogador) => (
                            <tr key={jogador.id}>
                                <td>{jogador.nome}</td>
                                <td>{jogador.sexo}</td>
                                <td>{jogador.idade}</td>
                                <td>{jogador.altura}</td>
                                <td>{jogador.peso}</td>
                                <td>{jogador.posicao}</td>
                                <td>{jogador.numeroDaCamisa}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            )}
        </div>
    );
}

export default ListaDejogadores;
