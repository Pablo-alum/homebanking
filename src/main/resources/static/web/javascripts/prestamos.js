

const { createApp } = Vue
  createApp({
    data() {
      return {
				hola:"hola",
        urlApi:"http://localhost:8080/api/clientes/current",
        cliente:[],
        nombre:"",
        cuentas:[],
				prestamos:[],
				urlPretamosDisponibles:"http://localhost:8080/api/prestamos",
				pretamosDisponibles:[],
				pretamoSelecionado:[],
				monto:null,
				cuotaSelecionada:null,
				cuentaDeDestino:"",
				abrirAlerta:false,
				cuotaPorcentaje:null,
				PorcentajeMasMonto:null
			}

    },
    created(){
        this.cargad_Datos(this.urlApi)
        this.cargad_DatosPretamos(this.urlPretamosDisponibles)
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
            })},
			salir:function() {
				axios.post('/api/logout').then(()=>window.location.href="./index.html")
							
			},
			cargad_DatosPretamos(url){
				axios.get(url).then(response=>
                this.pretamosDisponibles = response.data
				)
			},
			PretamoSelecionado:function(event){
				let nombre = event.target.innerHTML;
			this.pretamosDisponibles.forEach(element => {
				if(element.nombre == nombre){
				console.log(element);
				this.pretamoSelecionado = element
				
				}
			});
			},

			solicitar:function(){
						if(this.pretamoSelecionado.id  == 9){
							console.log("Pretamo9")

							let montoNumero = Number(this.monto) 
							    let Porcentaje = Number(this.monto)*0.6
									this.PorcentajeMasMonto = montoNumero+Porcentaje
									this.cuotaPorcentaje = this.PorcentajeMasMonto / this.cuotaSelecionada
									this.abrirAlerta = true
						}
						if(this.pretamoSelecionado.id  == 10){
							console.log("Pretamo10")

							let montoNumero = Number(this.monto) 
							  let Porcentaje = Number(this.monto)*0.1
									this.PorcentajeMasMonto = montoNumero+Porcentaje
									this.cuotaPorcentaje = this.PorcentajeMasMonto / this.cuotaSelecionada
									this.abrirAlerta = true
						}
						if(this.pretamoSelecionado.id  == 11){
							console.log("Pretamo11")
							let montoNumero = Number(this.monto) 
							  let Porcentaje = Number(this.monto)*0.4
										this.PorcentajeMasMonto = montoNumero+Porcentaje
									this.cuotaPorcentaje = this.PorcentajeMasMonto / this.cuotaSelecionada
									this.abrirAlerta = true
						}
									this.abrirAlerta = true
			} ,


			SolicitarPretamo:function(){
				console.log();
				axios.post('/api/prestamos',{ id: this.pretamoSelecionado.id, monto:this.monto ,cuotas:this.cuotaSelecionada, cuentaDeDestino:this.cuentaDeDestino }).then(()=>window.location.href="./cuentas.html").catch(() => console.log('error'));
			}
    }



}).mount('#app')

