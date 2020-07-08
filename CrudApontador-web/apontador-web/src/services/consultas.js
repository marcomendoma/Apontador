import { URL_API } from "./base";

export function listarLocalidades(callback){
    fetch(`${URL_API}/`)
    .then(resultado => resultado.json()
    .then(callback));
};
