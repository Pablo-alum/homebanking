
const { createApp } = Vue
  createApp({
    data() {
      return {
				hola:"hola",
        urlApi:"http://localhost:8080/api/clientes/current",
        cliente:[],
        nombre:"",
        cuentas:[],
				id: new URLSearchParams(location.search).get("id"),
				infomacion:{},
				prestamos:[],
				tarjetas:[],
				tarjetas_debito:[],
				tarjetas_credito:[],
				mostar:true,
				transaccion:true,
				cuentaOrigen:"",
				cuentaDeDestino:"",
				descripción:"",
				monto:null,
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
                this.nombre = response.data.nombre
                this.cuentas = response.data.cuenta
								this.prestamos = response.data.clientePrestamo
								this.tarjetas = response.data.tarjeta
							this.tarjetas_debito = this.tarjetas.filter(tarjeta=> tarjeta.type.includes("DEBITO"))
							this.tarjetas_credito = this.tarjetas.filter(tarjeta=> tarjeta.type.includes("CREDITO"))
            })},
			salir:function() {
				axios.post('/api/logout').then(()=>window.location.href="./index.html")
							
			},
			Crear_Cuenta:function(){
				axios.post('/api/cliente/current/cuenta').then(response => alert("CuentaCreada"))
					alert(cuentas.length)
			},
			transferir:function() {
				let cuentaDeOrigen = document.querySelector(".cuentaNumero").innerHTML;
				axios.post("/api/transaciones","monto="+this.monto+"&descripción="+this.descripción+"&numeroDeOrigen="+this.cuentaOrigen+"&numeroDeDeDestino="+this.cuentaDeDestino).then(response => alert("Transacion Finalisada Con exito"))
			
			}
    }



}).mount('#app')

