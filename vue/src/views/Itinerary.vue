<template>
<div>
    <h1>Itinerary Information</h1>
  <div class="itinerary">
    <div class="itinerary-1">
    <itinerary-list />
    </div>
    <div class="itinerary-2">
    <create-itinerary />
    </div>
  </div>
</div>
</template>

<script>
import CreateItinerary from '../components/CreateItinerary.vue';
import ItineraryList from '../components/ItineraryList.vue';

export default{
    components: {
      CreateItinerary,
        ItineraryList
    }
};

</script>

<style>
.itinerary{
  display: flex;
  width: 100%;
  flex-direction: row;
  padding-left: 50px;
}
.itinerary-1 {
  width: 50%;
}
</style>
