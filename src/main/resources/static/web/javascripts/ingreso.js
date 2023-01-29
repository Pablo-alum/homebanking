
const { createApp } = Vue
  createApp({
    data() {
      return {
				hola:"hola",
				contraseña:[],
				emial:[],

      }

    },
    created(){
      
 
    },

    mounted(){
		},

    methods:{
     
			acceder:function(){

				axios.post('/api/login',"email="+this.emial+"&contraseña="+this.contraseña).then(()=>window.location.href="./cuentas.html")
			},

    }



}).mount('#app')

