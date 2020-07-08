import React, { Component } from 'react'
import LocalidadeService from "../../services/LocalidadeService";
import { listarLocalidades } from "../../services/consultas";

class LocalidadeListarComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            localidades: []
        }
    }
    
    componentDidMount() {
        this.listar();
    }

    listar() {
        listarLocalidades(dados => this.setState({localidades: dados}));
    }

    render(){
        return (
            <div>
                <button className="btn btn-danger" onClick={() => this.adicionar()}> Cadastre um local</button>
                <div className="row">
                    <div className="col">
                        <div className="card mt-2">
                            <table className="table">
                                <tbody>
                                    { 
                                        this.state.localidades.map((item, indice) => {
                                            return (
                                                <tr key={indice}>
                                                    <td>{item.nome}</td>
                                                    <td>{item.fone}</td>
                                                    <td>{item.endereco}</td>
                                                </tr>
                                            )
                                        })
                                    }
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default LocalidadeListarComponent;