<template>
<div class="selection">
   
    <div>
      <h2>What would you like to find?</h2>
      
      <search-form class ="search" />
      <center><router-link to="/register">login to add to itinerary</router-link></center>
      <p></p>
      <search-results />
       
    </div>
    <display-map />
</div>
</template>

<script>
import SearchForm from "../components/SearchForm";
import SearchResults from "@/components/SearchResults";
import DisplayMap from '../components/DisplayMap.vue';

export default{
    components: {
      SearchResults,
      SearchForm,
        DisplayMap
    }
}

</script>

<style>
.selection {
  display: inline-flex; 
  justify-content: left;
  flex-direction: row;
  padding-left: 35px;
}

.search {
  display: flex;
  justify-content: center;
  padding-bottom: 20px;
}
#register-link{
  text-align: left;
}
</style>
