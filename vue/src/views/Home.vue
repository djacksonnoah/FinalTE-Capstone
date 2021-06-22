<template>
  <div class="home">
    <div class="header-row">
    <img src="../assets/img/CLEtestbanner.png">
    </div>
  <div class="image">
    <div class="image-1">
      <img src="../assets/img/explore.png">
     </div>
      <div class="image-2">
        <img src="../assets/img/planatrip.png">
      </div>
      <div class="image-3">
        <img src="../assets/img/havefun.png">
      </div>
  </div>
    <div class="col-spe">
      <div class="col-1">
        <ul>
          <p><h2>There's so many fun places to see in Cleveland.</h2></p>
          <div class="search">
          <router-link to="/selection">Start Your Search Here</router-link>
          </div>
        </ul>
      </div>
      <div class="col-2">
        <ul>
        <p><h2> Start planning your stay.</h2></p>
         <div id="register">
          <p>
            <router-link to="/register">Create an Account</router-link>
          </p>
        </div>
        </ul>
        </div>
      <div class="col-3">
        <ul>
        <p><h2>Already have an account? Access your itinerary here.</h2></p>
        <p>
          <div class="login">
          <login />
          </div>
        </p>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import login from "../components/Login.vue"
export default {
  name: "home",
  components: {
    login
  }
};
</script>

<style>
.image {
  display: inline-flex;
  width: 100%;
  float: center;
}
.image-1{
  display: flex;
    padding: 0 15px;
    padding-right: 15px;
    width: 33%;
    justify-content: center;
    
}
.image-2 {
    display: flex;
    padding: 0 15px;
    padding-right: 15px;
    width: 34%;
    justify-content: center;
    
}
.image-3 {
    display: flex;
    padding: 0 15px;
    padding-right: 15px;
    width: 33%;
    justify-content: center;
}
.col-spe {
    display: inline-flex;
    width: 100%;
    float: center;
}
.col-1{
    display: flex;
    padding: 0 15px;
    padding-right: 50px;
    width: 33%;
    justify-content: left;
}
.col-2{
    display: flex;
    padding: 0 15px;
    padding-right: 50px;
    width: 34%;
    justify-content: left;
}
.col-3{
    display: flex;
    padding: 0 15px;
    padding-right: 50px;
    width: 33%;
    justify-content: left;
}
p {
  text-align: center;
}
.search a {
  font-size: 20px;
}
#register a {
  font-size: 20px;
}
.login {
  display: inline-flex;
  justify-content: center;
  align-items: center;
}

</style>