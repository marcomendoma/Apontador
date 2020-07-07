import http from "../http-common";

class LocalidadeService {

    listar = () => {
        return http.get("/");
    };

    consultar = id => {
        return http.get(`/consultar/${id}`);
    };

    consultarPeloEndereco = endereco => {
        return http.post(`/consultar/${endereco}`);
    };

    salvar = data => {
        return http.post("/salvar", data);
    };
}

export default new LocalidadeService();
