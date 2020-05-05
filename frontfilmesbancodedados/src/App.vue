<template>
  <div id="app">
      <nav>
        <div class="nav-wrapper #1a237e indigo darken-4">
          <a href="#" class="brand-logo center">Filme banco de dados</a>
        </div>
      </nav>



      <form @submit.prevent="storeAndUpdateMovie">
        <div>
          <input type="text" id="nome" placeholder="Adicione um filme" v-model="movie.nome">
        </div>
        <div>
          <input type="text" id="duracao" placeholder="Tempo do filme em minutos" v-model="movie.duracao">
        </div>
        <div>
          <input type="text" id="nota" placeholder="Digite a nota" v-model="movie.nota">
        </div>
        <div>
          <input type="text" id="genero" placeholder="Genero do filme" v-model="movie.genero">
        </div>
        <div>
          <input type="text" id="diretor" placeholder="Digite o Diretor" v-model="movie.diretor">
        </div>
        <div>
          <button class="waves-effect #3f51b5 indigo btn-small" >Adicionar</button>
        </div>
      </form>

      <h1>filmes cadastrados: {{movies.length}}</h1>

      <h2 v-show="movies.length==0">Não ha filmes cadastrados!</h2>
      <table v-show="movies.length>0">
        <thead>
          <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Duração/min</th>
            <th>Nota</th>
            <th>Genero</th>
            <th>Diretor</th>
            <th>Excluir</th>
            <th>Alterar</th>
          </tr>
        </thead>
        <tfoot>
          <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Duração/min</th>
            <th>Nota</th>
            <th>Genero</th>
            <th>Diretor</th>
            <th>Excluir</th>
            <th>Alterar</th>
          </tr>
        </tfoot>
        <tbody>
          <tr v-for="movie in movies" :key="movie.id">
          <td>{{movie.id}}</td>
          <td>{{movie.nome}}</td>
          <td>{{movie.duracao}}</td>
          <td>{{movie.nota}}</td>
          <td>{{movie.genero}}</td>
          <td>{{movie.diretor}}</td>
          <td>
            <button @click="deleteMovie(movie)" class="waves-effect #3f51b5 indigo btn-small">Excluir</button>
          </td>
          <td>
            <button @click="updateMovie(movie)" class="waves-effect #3f51b5 indigo btn-small">Alterar</button>
          </td>
        </tr>
        </tbody>
      </table>
  </div>
</template>

<script>
import MovieServices from './services/movieservices'

export default {
  data() {
    return {
      movie: {
        id:'',
        nome:'',
        duracao:'',
        nota:'',
        genero:'',
        diretor:''
      },
      movies: []
    }
  },
  mounted() {
    this.listMovies();
  },
  methods: {
    listMovies() {
      MovieServices.findAll().then(response => {
        this.movies = response.data
      })
    },
    storeAndUpdateMovie() {
      if(!this.movie.id) {
      MovieServices.store(this.movie).then(response => {
        alert("Filme Adicionado com sucesso!");
        this.movie = {};
        this.listMovies();
        return response;
      })
    } else {
      MovieServices.update(this.movie).then(response => {
        alert("Filme Alterado com sucesso!");
        this.movie = {};
        this.listMovies();
        return response;
      })
     }
   },
    deleteMovie(movie) {
      if(confirm("Deseja excluir o filme?!")) {
      MovieServices.delete(movie).then(response => {
        alert("Excluido com sucesso!");
        this.listMovies();
        return response;
       })
     }
   },
   updateMovie(movie) {
     this.movie = movie;
   }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 20px;
}
</style>
