const { createApp } = Vue
  createApp({
    data() {
      return {
				nombre:"",
				apellido:"",
				emial:"",
				contraseña:"",
        cuentaExitosa:false,
      }

    },
    created(){
      
 
    },

    mounted(){
		},

    methods:{
			crear:function(){
		axios.post('/api/clientes/current',"nombre="+this.nombre+"&apellido="+this.apellido+"&email="+this.emial+"&contraseña="+this.contraseña).then(()=>(this.cuentaExitosa = true)).catch(()=>(console.log("Error")))
			},		
    }



}).mount('#app')

