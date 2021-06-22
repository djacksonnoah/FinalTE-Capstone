<template>
  <div>
      <h3>Are you sure you want to delete this itinerary? {{itinerary.name}}</h3>
      <div class="text-center">
      <button v-on:click="deleteItinerary">Yes</button>
      <button onclick="history.back()">No</button>
      </div>
  </div>
</template>

<script>
import itineraryService from "../services/ItineraryService.js"
export default {
    data () {
        return {
            itinerary: {}
        }
    },
    methods: {
        deleteItinerary() {
            itineraryService.delete(this.$route.params.id)
            window.history.go(-1)
        },

    created() {
        itineraryService.get(this.$route.params.id).then((response) => {
            this.itinerary = response.data
        })
    }
}
}
</script>

<style>
.text-center {
    text-align: center;
}
</style>