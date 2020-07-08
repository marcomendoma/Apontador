import React, { Component } from "react";
import LocalidadeService from "../../services/LocalidadeService";

class LocalidadeCadastroComponent extends Component {
  
  constructor(props) {
    super(props);
    this.state = {
      id: "",
      nome: "",
      fone: "",
      endereco: "",
      message: null,
    };
    this.salvar = this.salvar.bind(this);
  }

  salvar = (e) => {
    e.preventDefault();
    let localidade = {
      id: this.state.id,
      nome: this.state.nome,
      fone: this.state.fone,
      endereco: this.state.endereco
    };
    LocalidadeService
      .salvar(localidade)
      .then((res) => {
        this.setState({ message: "Localidade adicionada com sucesso ." });
        this.props.push(localidade);
    });
  };

  onChange = (e) => this.setState({ [e.target.name]: e.target.value });

  render() {
    return (
      <div className="App">
        <form>
          <div className="form-group ">
            <input
              type="text"
              placeholder="Nome do local"
              name="nomelocal"
              className="form-control"
              value={this.state.nome}
              onChange={this.onChange}
            />
          </div>

          <div className="form-group">
            <input
              type="text"
              placeholder="Telefone"
              name="telefone"
              className="form-control"
              value={this.state.fone}
              onChange={this.onChange}
            />
          </div>

          <div className="form-group">
            <input
              placeholder="Endereço"
              name="endereco"
              className="form-control"
              value={this.state.endereco}
              onChange={this.onChange}
            />
          </div>

          <button className="btn btn-success" onClick={this.salvar}>
            Cadastrar
          </button>
        </form>
      </div>
    );
  }
}

export default LocalidadeCadastroComponent;
