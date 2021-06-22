<template>
  <div>
    <h3>
            <u>Create New Itinerary Here:</u>
    </h3>
    <div>
      <form v-on:submit.prevent="saveOrder">
        <div>
          <div>
            <input type="text"  placeholder="Name of your itinerary?" v-model="itinerary.name" />
          </div>
          <div>
            <input type="date"  id="itinerary-date" v-model="itinerary.itineraryDate" />
          </div>
        </div>
        <button class="btn btn-primary" v-on:click="create()">Create</button>
      </form>
    </div>
  </div>
</template>

<script>

import itineraryService from "@/services/ItineraryService";

export default{
  name: "create-itinerary",
  props: {},
  data(){
    return{
      itinerary: {
        name: "",
        itineraryDate: "",
        userId: this.$store.state.user.id  
        }
    };
  },
  methods: {
    create() {
      itineraryService.create(this.itinerary)
      .then(() => {
        // after the itinerary is created
        // reload all itineraries
        this.getItineraries();

        this.itinerary = {
          name: "",
          itineraryDate: "",
          userId: this.$store.state.user.id
        };
      });
    },
    getItineraries()
    {
      itineraryService.getByUser(this.$store.state.user.id).then(response => {
        this.$store.commit("SET_ITINERARIES", response.data)
      });
    }
  },
}



</script>
<style>
</style>
