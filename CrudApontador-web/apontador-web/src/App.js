import React, { Component } from 'react';
import './App.css';
import MenuSuperior from './components/MenuSuperior/MenuSuperior';
import Cadastro from './components/Localidades/LocalidadeCadastroComponent';
import Consulta from './components/Localidades/LocalidadeListarComponent';

import { Switch, Route } from 'react-router-dom';

class App extends Component {
  render() {
    return (
      <div> 
        <MenuSuperior/>
        <div className="container-fluid">
          <div className="row">
            <div className="col">
              <Switch>
                <Route path="/" exact component={ Consulta } />                              
                <Route path="/salvar" component={ Cadastro } />
              </Switch>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default App;
