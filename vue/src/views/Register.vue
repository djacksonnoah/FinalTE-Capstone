<template>
<div class="account">
  <div class="register">
    <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
    <h3>Create an account to have access to itineraries:</h3>
    <div class="col-register">
      <div class="register-left"></div>
      <div class="register-center">
    <form class="form-register" @submit.prevent="register">      
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input type="text" id="username" class="form-control" placeholder="Username" v-model="user.username" required autofocus />
      <label for="password" class="sr-only">Password</label>
      <input type="password" id="password" class="form-control" placeholder="Password" v-model="user.password" required />
      <input type="password" id="confirmPassword" class="form-control" placeholder="Confirm Password" v-model="user.confirmPassword" required />
      <router-link :to="{ name: 'home' }">Have an account? Login on the home page.</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
      </div>
     
    </div>
  </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/',
                // query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>
.account {
  display: inline-flex;
}
.register {
  width: 100%;
  justify-content: center;
}
.col-register {
  display: inline-flex;
  width: 100%;
  float: center;
  }
.register-left{
  width: 25%;
}
.register-center{
  width: 50%;
  display: flex;
  justify-content: center;
}
.register-right{
  width: 25%;
}
  .form-register {
    display: flex;
     flex-direction: column;
     justify-content: center;
     align-items: center;
     padding: 30px;
     
  }
  
</style>
