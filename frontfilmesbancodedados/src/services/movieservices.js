import { http } from './api'

export default {

    findAll:() => {
      return http.get('filmes');
    },

    store:(movie) => {
      return http.post('filmes', movie)
    },

    update:(movie) => {
      return http.put(`filmes/${movie.id}`, movie)
    },

    delete:(movie) => {
      return http.delete(`filmes/${movie.id}`, { data: movie })
    }
}
