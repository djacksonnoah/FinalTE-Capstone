<template>
  <div>
    <div id="landmarks list">
      <tbody>
        <tr
          v-for="itinerary in this.$store.state.itineraries"
          v-bind:key="itinerary.userId"
        >
          <td>
            <router-link
              :to="{ name: 'itinerary-detail', params: { id: itinerary.itineraryId } }"
              >{{ itinerary.name }}</router-link
            >
          </td>
          <td>{{ itinerary.itineraryDate }}</td>
          <!-- <td>test</td>
                <td>test1</td> -->
          <td>
            <router-link
              :to="{ name: '', params: { id: itinerary.itineraryId } }"
              >EDIT</router-link
            >
          </td>
        </tr>
      </tbody>
    </div>
  </div>
</template>

<script>
</script>

<style>
</style>