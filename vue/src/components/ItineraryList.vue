<template>
    <div id="itinerary list">
        <h3>
            <u>Your Itinerary List:</u>
        </h3>
            <thead>
                <tr>
                    <th><h4>Itinerary Name</h4></th>
                    <th><h4>Date</h4></th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="itinerary in this.$store.state.itineraries" v-bind:key="itinerary.userId">
                    <td>
                        <router-link :to="{name:'itinerary-detail', params:{id:itinerary.itineraryId}}">{{itinerary.name}}</router-link>

                    </td>
                    <td>{{itinerary.itineraryDate}} </td>
                <!-- <td>test</td>
                <td>test1</td> -->
                    
                    <td>
                        <router-link :to="{name:'delete-confirmation',params:{id:itinerary.itineraryId}}">DELETE</router-link>
                    </td>
                    <td v-if="showForm">
                        <edititinerary />
                    </td>
                </tr>
            </tbody>
    </div>
</template>

<script>
import itineraryService from "../services/ItineraryService";
import Edititinerary from "../components/EditItinerary.vue"
export default {
    data() {
        return {
            showForm: false,
        }
    },
    methods: {
        getItineraries() {
            itineraryService.getByUser(this.$store.state.user.id).then(response => {
                this.$store.commit("SET_ITINERARIES", response.data)
            })
        }
    },
    created(){
        this.getItineraries();
    },
    components: {
        Edititinerary,
    }
}
</script>

<style>
    
</style>