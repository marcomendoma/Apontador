import React, { Component } from "react";
import { Link } from "react-router-dom";

//import logotipo from "../Apontador_logo.png";

class MenuSuperior extends Component {
  render() {
    return (
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <Link to="/" className="navbar-brand">
          Apontador
          {/* <img src={logotipo} /> */}
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarNav"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to="/" className="nav-link">
                Pesquisar
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/salvar" className="nav-link">
                Cadastro
              </Link>
            </li>
          </ul>
        </div>
      </nav>
    );
  }
}

export default MenuSuperior;
