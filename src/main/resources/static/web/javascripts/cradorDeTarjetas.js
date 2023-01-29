
const { createApp } = Vue
  createApp({
    data() {
      return {
        urlApi:"http://localhost:8080/api/clientes/current",
        cliente:[],
        nombre:"",
        cuentas:[],
				id: new URLSearchParams(location.search).get("id"),
				tarjetas:[],
				fechaDeVencimiento:"",
				tipoDeTarjeta:"CREDITO",
				ColorTarjeta:"GOLD"
      }

    },
    created(){
        this.cargad_Datos(this.urlApi)
			let year = new Date().getFullYear()+5
			let month = new Date().getMonth()+1
				let day = new Date().getDay()+30
				this.fechaDeVencimiento = `${year}/${month}/${day}`
	
    },

    mounted(){
		},

    methods:{
        cargad_Datos(url){ axios
            .get(url)
            .then(response => {

                this.cliente = response.data
                this.nombre = response.data.nombre
                this.cuentas = response.data.cuenta
								this.tarjetas = response.data.tarjeta
							this.tarjetas_debito = this.tarjetas.filter(tarjeta=> tarjeta.type.includes("DEVITO"))
							this.tarjetas_credito = this.tarjetas.filter(tarjeta=> tarjeta.type.includes("CREDITO"))
            })},

			salir:function() {
				axios.post('/api/logout').then(()=>window.location.href="./index.html")
							
			},
			CrearTarjetas:function(){
				 axios.post('/api/clientes/current/tarjeta',"tipoDeTransacciónTarjetas="+this.tipoDeTarjeta+"&tipoDeColor="+this.ColorTarjeta).then(()=>window.location.href="./tarjetas.html")


			},
    }



}).mount('#app')

