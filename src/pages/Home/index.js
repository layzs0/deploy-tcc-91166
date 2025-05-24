import React from 'react'
import logo from '../../assets/images/logo.png'
import { useNavigate } from 'react-router-dom'
import './style.css'

function Home() {
  const navigate = useNavigate()

  return (
    <div className="home-container">
      <div className="home-box">
        <h1 className="home-title">Bem-vindo</h1>
        <img src={logo} alt='Logo do Time' width={200}></img>
        <button className="home-button blue" onClick={() => navigate('/cadastro')}>
          Tela de Cadastro
        </button>
        <button className="home-button green" onClick={() => navigate('/usuarios')}>
          Ver Usuários Cadastrados
        </button>
      </div>
    </div>
  )
}

export default Home
