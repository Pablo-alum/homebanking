const { createApp } = Vue

createApp({
  data() {
    return {
      message: 'Hello Vue!',
     urlApi: "http://localhost:8080/api/cliente",
     cliente:[],
     nombre:"",
     apellido:"",
     gmail:"",
     clientes:[],
    }

    
  },
  created(){

  this.cargad_Datos(this.urlApi)
  },
  mounted(){



  },
  methods:{
   cargad_Datos(url){ axios
    .get(url)
    .then(response => {
      this.cliente = response.data
      this.clientes = response.data
    })},

    add_Cliente(){
      axios.post(this.urlApi,{nombre:this.nombre,apellido:this.apellido,email:this.gmail}).then(() =>this.cargad_Datos(this.urlApi))
    },
    delet_client(clienteId){
      axios.delete(clienteId).then(()=> this.cargad_Datos(this.urlApi))

    }
    
  }
}).mount('#app')
