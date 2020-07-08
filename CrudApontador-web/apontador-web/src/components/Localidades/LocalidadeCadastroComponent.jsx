import React, { Component } from "react";
import LocalidadeService from "../../services/LocalidadeService";
import { TextField } from "@material-ui/core";

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
      endereco: this.state.endereco,
    };
    LocalidadeService.salvar(localidade).then((res) => {
      this.setState({ message: "Localidade adicionada com sucesso ." });
      //this.props.push(localidade);
    });
  };

  onChange = (e) => this.setState({ [e.target.name]: e.target.value });

  render() {
    return (
      <div>
        <form style={formContainer} >
          <div>
          <TextField
            id="standard-basic"
            label="Nome do local"
            fullWidth margin="normal"
            onChange={this.onChange}
          />

          </div>

          <TextField
            id="standard-basic"
            label="Telefone"
            fullWidth margin="normal"
            onChange={this.onChange}
          />

          <TextField
            id="standard-basic"
            label="Endereco"
            fullWidth margin="normal"
            //value={this.state.endereco}
            onChange={this.onChange}
          />
        </form>
          <button className="btn btn-success" onClick={this.salvar}>
            Cadastrar
          </button>
      </div>
    );
  }
}

const formContainer = {
  display: 'flex',
  flexFlow: 'row wrap'
};

const style ={
  display: 'flex',
  justifyContent: 'center'

}

export default LocalidadeCadastroComponent;
