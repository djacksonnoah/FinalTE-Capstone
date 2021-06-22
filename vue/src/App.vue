<template>
  <div id="app">
    <section id="left-panel"></section>
    <section id="central-panel">
      <header id="nav-header" v-if="showHeader">
        <img src="./assets/img/CLEtestbanner.png">
        <div id="nav">
          <li>
            <router-link to="/">Home</router-link>
            <router-link v-bind:to="{name: 'selection'}">Search</router-link>
            <router-link v-bind:to="{ name: 'itinerary' }" v-if="$store.state.token != ''">Itinerary</router-link>
            <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
          </li>
        </div>
      </header>
      
      <router-view/>
      <footer>&nbsp;</footer>
    </section>
    <section id="right-panel"></section>
  </div>
</template>

<script>

export default {
  data(){
    return {
      showHeader: {}
    }
  },
  created() {
    this.showHeader = this.$route.path != "/";
  },
  watch: {
    $route (to){
      this.showHeader = to.path != "/";
    }
  }
}
</script>



