<template>

<div class="landmark">
    <div class="landmark-options">
        <div class="rtnsearch">
            <router-link :to="{name: 'selection'}">RETURN TO PREVIOUS SEARCH</router-link>
        </div>
        <div class="space"></div>
            <div id="additinerary">
             <h5>ADD TO ITINERARY</h5> <add-location-to-itinerary v-bind:place="landmark" />
           <!-- <button class="btn btn-primary" v-on:click="create()">ADD TO ITINERARY</button> -->
            </div>
        </div>

        <div class="name">
             <h1>{{landmark.name}}</h1>
        </div>

      

       <div id="details">
            <h2>
                <strong>Venue Type:</strong>
            {{landmark.types[0]}}
            </h2>
        
            <h3 v-if="landmark.opening_hours.open_now">
            <strong>Currently Open:</strong>
                <!-- {{landmark.opening_hours.open_now}} **only displays text currently open if open now is true-->
            </h3>
        </div>
        <div id="map">
            <!-- **Map stuff goes here** -->
        </div>

        <div id="photo">
            <h3 v-if="landmark.photos">
            <google-photo  v-for="photo in landmark.photos" v-bind:key="photo.id" v-bind:photo="photo" height="150" />
            </h3>
        </div>

  </div>
</template>

<script>
// import landmarkService from "../services/LandmarkService";
import GooglePhoto from "@/components/GooglePhoto";
import AddLocationToItinerary from "@/components/AddLocationToItinerary";

export default {
    name: "landmark-detail",
  components: {
    AddLocationToItinerary,
      GooglePhoto
  },
    data() {
        return {
            landmark: {
                locationId: "",
                name: "",
                latitude: "",
                longitude: "",
                itineraryID :"",
                address: "",
                location_order: "",
            }
        };
    },
    methods: {
        // create() {
        //     landmarkService.create()
        //     .then(response => {
        //         if(response.status === 200)
        //         {
        //             this.$router.push(`/${this.landmark}`)
        //         }
        //     });
        // }
    },
    created () {
        // landmarkService.get(this.$store.state.searchResults.place_id).then((response) => {
        //     this.landmark = response.data;
        // });
        let id = this.$route.params.id;
        this.landmark = this.$store.state.searchResults.find(result => result.place_id == id);
        console.table(this.landmark);
    },

}

</script>

<style>
  .landmark-options {
      width: 100%;
      display: inline-flex;
  }
  .rtnsearch{
      width: 33%;
      justify-content: left;
  }
  .space {
      width: 34%;
  }
  .additinerary {
      width: 33%;
      justify-content: flex-end;
  }
  .name {
      width: 100%;
      justify-content: center;
  }
  #photo {
      padding: 50px;
  }
</style>
