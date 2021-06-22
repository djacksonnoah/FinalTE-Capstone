<template>
<div class="login">
  <div class="col-login">
        <div class="login-left"></div>
        <div class="login-center">
        <form class="form-signin" @submit.prevent="login">
                    <div class="alert alert-danger" role="alert" v-if="invalidCredentials">Invalid username and password!</div>
          <div class="alert alert-success" role="alert" v-if="this.$route.query.registration">Thank you for registering, please sign in.</div>         
          <input type="text" id="username" class="form-control" placeholder="Username" v-model="user.username" required autofocus/>          
          <input type="password" id="password" class="form-control" placeholder="Password" v-model="user.password" required/>
          <router-link :to="{ name: 'register' }">Need an account? </router-link>
          <button type="submit">Sign in</button>
        </form>
     </div>
    <div class="login-right"></div>
  </div>
 </div> 
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/itinerary");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style>
.col-login{
  display: inline-flex;
  width: 100%;
  float: center;
}
.login-left{
  width: 100%;
}
.login-center{
  width: 0%;
  display: flex;
  justify-content: center;
}
.login-right{
  width: 0%;
}
.form-signin {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  
  
  
  
}
.form-signin label{
  padding: 10px;
}
</style>
