const { createApp } = Vue;
createApp({
  data() {
    return {
      error: "",
      contraseña: [],
      emial: [],
    };
  },
  created() {},

  mounted() {},

  methods: {
    acceder: function () {
      axios
        .post(
          "/api/login",
          "email=" + this.emial + "&contraseña=" + this.contraseña
        )
        .then(() => (window.location.href = "./cuentas.html"))
        .catch(() => (this.error = "La contraseña o el correo son incorrecta"));
    },
  },
}).mount("#app");
