const { createApp } = Vue

  createApp({
    data() {
      return {
        urlApi:"http://localhost:8080/api/cliente/current",
				id: new URLSearchParams(location.search).get("id"),
				cuentas:[],
				infomacion:[],
				transaciones:[],
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
                this.cuentas = response.data.cuenta
								this.infomacion = this.cuentas.find(
				              cuenta =>  cuenta.id == this.id
				            );
							this.transaciones = this.infomacion.transacion
            })},
    
			salir:function() {
				axios.post('/api/logout').then(()=>window.location.href=".././index.html")
							
			}



		},


}).mount('#app')
