import React, { Component } from "react";
import { listarLocalidades } from "../../services/consultas";

import { Card, CardContent, Typography } from "@material-ui/core";

class LocalidadeListarComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      localidades: [],
    };
  }

  componentDidMount() {
    this.listar();
  }

  listar() {
    listarLocalidades((dados) => this.setState({ localidades: dados }));
  }

  render() {
    return (
      <div>
        {this.state.localidades.map((item, indice) => {
          return (
            <Card>
              <CardContent>
                <Typography>
                  <strong>{item.nome}</strong>
                </Typography>
                <Typography>{item.fone}</Typography>
                <Typography>{item.endereco}</Typography>
              </CardContent>
            </Card>
          );
        })}
      </div>
    );
  }
}

export default LocalidadeListarComponent;
