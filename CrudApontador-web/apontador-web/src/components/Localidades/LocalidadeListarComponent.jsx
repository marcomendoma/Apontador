import React, { Component } from 'react'
import LocalidadeService from "../../services/LocalidadeService";

class LocalidadeListarComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            localidades: [],
            message: null
        }
        this.adicionar = this.adicionar.bind(this);
        this.listar = this.listar.bind(this);
    }

    componentDidMount() {
        this.listar();
    }

    listar() {
        LocalidadeService.listar()
            .then((res) => {
                this.setState({localidades: res.data.result})
            });
    }

    adicionar() {
        window.localStorage.removeItem("userId");
        this.props.history.push('/add-user');
        LocalidadeService.salvar()
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
                                        this.state.localidades.map(item => {
                                            return (
                                                <tr key={item.id}>
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