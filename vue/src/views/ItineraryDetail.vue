<template>
  <div class="itinerary">
    <div class="col-1">
    <ul>
       <h1>{{ itinerary.name }}</h1>
    
      <h2>Landmarks to visit:</h2>
    
   
    
    <div class="landmark-info" v-for="landmark in landmarks" v-bind:key="landmark.locationId">
      <ul>
        <p><h4> {{ landmark.name }}</h4>
        <h4>{{ landmark.address }}</h4></p>
      </ul>
      </div>
      </ul>
    </div>
    <div class="col-2">
    <locations-map />
    </div>
  </div>
</template>

<script>
import LandmarkService from "../services/LandmarkService";
import ItineraryService from "../services/ItineraryService";
//import AddLocationToItinerary from '../components/AddLocationToItinerary.vue';
import LocationsMap from '../components/LocationsMap'

export default {
  components: { LocationsMap },
  data() {
    return {
    };
  },
  methods: {
    getItineraryLandmarks() {
      LandmarkService.get(this.$route.params.id).then((response) => {
        this.$store.commit("SET_LANDMARKS", response.data);
      });
    },
    getItinerary() {
      ItineraryService.getByUser(this.$store.state.user.id).then((response) => {
        this.$store.commit("SET_ITINERARIES", response.data);
      })
    }
  },
  created() {
    this.getItinerary();
    this.getItineraryLandmarks();
  },
  computed: {

    landmarks(){
      return this.$store.state.landmarks
    } ,
    itinerary() {
      let itineraries = this.$store.state.itineraries.filter(i => i.itineraryId == this.$route.params.id);
      if(itineraries.length > 0) {
        return itineraries[0];
      }
      return {
        name: "This itinerary does not exist."
      }
    }
  }
};
</script>

<style>
.itinerary {
  display: inline-flex; 
  justify-content: left;
  flex-direction: row;
}


.col-1 {
  width: 50%;
}
.col-2 {
  width: 50%;
}
</style>
