import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import React from "react";
import LocalidadeCadastroComponent from "../components/Localidades/LocalidadeCadastroComponent";
import LocalidadeListarComponent from "../components/Localidades/LocalidadeListarComponent";

const AppRouter = () => {
  return (
    <div style={style}>
      <Router>
        <Switch>
          <Route path="/" exact component={ LocalidadeListarComponent } />
          <Route path="/salvar" component={ LocalidadeCadastroComponent } />
        </Switch>
      </Router>
    </div>
  );
};

const style = {
  marginTop: "20px",
};

export default AppRouter;
