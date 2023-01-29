const { createApp } = Vue
  createApp({
    data() {
      return {
				nombre:"",
				apellido:"",
				emial:"",
				contraseña:"",
      
      }

    },
    created(){
      
 
    },

    mounted(){
		},

    methods:{
			crear:function(){
		axios.post('api/clientes/current',"nombre="+this.nombre+"&apellido="+this.apellido+"&email="+this.emial+"&contraseña="+this.contraseña).then(()=>window.location.href="./cuentas.html")
			},		
    }



}).mount('#app')

