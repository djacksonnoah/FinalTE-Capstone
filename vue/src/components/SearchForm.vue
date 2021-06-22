<template>
  <div>
    <div>
      <form v-on:submit.prevent>
        <div>
          <div class="search-bar">
            <input type="text"  placeholder="Search for a destination" v-model="searchText" />
          </div>
        </div>
        <button class="btn-primary" @click="search">Search</button>
      </form>
    </div>
  </div>
</template>

<script>

import LocationService from "@/services/LocationService";

export default{
  data(){
    return{
      searchText: "",
      places: []
    };
  },
  methods: {
    search() {
      LocationService.search(this.searchText)
      .then(response => {

        this.$store.commit('SET_SEARCH_RESULTS', response.data.results)
      })
      .catch(error => {
        console.log(error.message);
      });
    }
  }
}



</script>
<style>
  .search-bar{
    padding: 5px;
  }
  .btn-primary {
    margin: 10px;
  }
</style>
