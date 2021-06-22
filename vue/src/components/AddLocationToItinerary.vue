<template>
  <div>
    <form action="" class="inline-form" v-on:submit.prevent="save" v-if="$store.state.token != ''">
      <select v-model="location.itineraryId">
        <option value="select an itinerary">Select an itinerary</option>
        <option v-for="itinerary in itineraries"
          v-bind:key="itinerary.id" 
          v-bind:value="itinerary.itineraryId"
        >{{itinerary.name}}</option>
      </select>
      <button>Add</button>
    </form>
  </div>
</template>

<script>
//import itineraryService from "@/services/ItineraryService";
import landmarkService from "@/services/LandmarkService";

export default {
  name: "AddLocationToItinerary",
  props: {
    place: {},
  },
  data() {
    return {
      location: {
        locationId: '',
        name: '',
        latitude: '',
        longitude: '',
        itineraryId: '',
        address: '',
        locationOrder: ''
      }
    }
  },
  methods: {
    save() {
      const newLocation = {
        ...this.location
      }

      // call itinerary service to add this landmark -- add then()
      landmarkService.create(newLocation).then(() => {
        landmarkService.getLocationsByUserId(this.$store.state.user.id).then(result => {
            this.$store.commit('SET_USER_LOCATIONS', result.data)
        });
      });

      this.location.itineraryId = '';
      // itineraryService.update(this.location);
    },
    
  },
  created() {
    // get a list of all the itineraries

    this.location = {
      locationId: this.place.place_id,
      name: this.place.name,
      latitude: this.place.geometry.location.lat,
      longitude: this.place.geometry.location.lng,
      itineraryId: '',
      address: this.place.formatted_address,
      locationOrder: 0
    }

  },
  computed: {
    itineraries() {
      // filter out itineraries that already exist for this location
      return this.$store.state.itineraries.filter(itinerary => {

        for(let i = 0; i < this.userLocations.length; i++)
        {
          const location = this.userLocations[0];
          if(location.itineraryId == itinerary.itineraryId){
            return false;
          }
        }

        return true;
      })
    },
    userLocations() {
      return this.$store.state.userLocations.filter(l => l.locationId == this.location.locationId);
    }

  }
}
</script>

<style scoped>
  .inline-form {
    display: inline;
  }
 
</style>
