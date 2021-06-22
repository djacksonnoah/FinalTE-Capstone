<template>

  <div class="ui segment">
  
    <div class="ui divided items">
      <div class="item" v-for="place in $store.state.searchResults" :key="place.id">
        <div class="content">
          <!-- change this to a router-link that goes to the details page -->
          <router-link class="landmark" v-bind:to="{name:'landmark', params:{id: place.place_id}}">{{place.name}}</router-link>
          <div class="add-itinerary">
          <add-location-to-itinerary v-bind:place="place" />
          </div>
          <div a href="#" class="meta">{{place.formatted_address}}</div>
          <div class="metab">Rating: {{place.rating}}</div>
          <div class="metac">Number of ratings: {{place.user_ratings_total}}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AddLocationToItinerary from "@/components/AddLocationToItinerary";
import itineraryService from "@/services/ItineraryService";
import landmarkService from "@/services/LandmarkService";

export default {
name: "SearchResults",
  components: {AddLocationToItinerary},
  created() {
    

    if(!this.$store.state.itineraries || this.$store.state.itineraries.length == 0)
    {
      // console.log("test");
      itineraryService.getByUser(this.$store.state.user.id).then(result => {
        this.$store.commit('SET_ITINERARIES', result.data)
        //add them to the store
        
      })
    }

    if(!this.$store.state.locations || this.$store.state.locations.length == 0)
    {
      landmarkService.getLocationsByUserId(this.$store.state.user.id).then(result => {
        this.$store.commit('SET_USER_LOCATIONS', result.data)
      })
    }
  }
}
</script>

<style scoped>

.location {
  color: #000000;
}
.header{
  padding: 0px;
  color: black;
}
.landmark{
  color: black;
  padding-left: 15px;
  font-size: 18px;
}
.landmark:hover {
  color: red;
}
.add-itinerary {
  padding-left: 30px;
}
.meta{
  color: black;
  padding-left: 30px;
  font-family: 'Oswald', sans-serif;
  font-size: 15px;
}
.metab{
  color: black;
  padding-left: 30px;
  font-family: 'Oswald', sans-serif;
  font-size: 15px;
}
.metac{
  color: black;
  padding-left: 30px;
  padding-bottom: 20px;
  font-family: 'Oswald', sans-serif;
  font-size: 15px;
}

</style>
