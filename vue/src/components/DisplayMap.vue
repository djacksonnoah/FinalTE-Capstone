<template>
  <div class="Map">
  
   </div>
 
</template>

<script>
import googlemapscreate from '@/utils/googlemaps.js';
export default {
  name: 'Map',
  methods: {
    async loadMap() {
      try {

        let address = 'Cleveland';
    
        const google = await googlemapscreate();
        const geocoder = new google.maps.Geocoder();
      
        const map = new google.maps.Map(this.$el);

        if(this.searchResults.length > 0)
        {
          address = this.searchResults[0].formatted_address;
        }
        geocoder.geocode({ address: address }, (results, status) => {
          if (status !== 'OK' || !results[0]) {
            throw new Error(status);
          }

          map.setCenter(results[0].geometry.location);
          map.setZoom(14);
          //map.fitBounds(results[0].geometry.viewport);
        });

        //this creates the markers
        const markerClickHandler = (marker) => {
          map.setZoom(13);
          map.setCenter(marker.getPosition());
        };

      
        
        const locations = this.$store.state.searchResults.map(result => {
          const location = result.geometry.location;
          return {             
              position: { 
              ...location
            }, 
            name: result.name
          }
        });
        locations.map((location) => 
                          {
                              
                              //const image = "https://logos-world.net/wp-content/uploads/2020/05/Cleveland-Indians-Logo-700x394.png"
                              const marker = new google.maps.Marker({ ...location, map, animation: google.maps.Animation.DROP, draggable: true, opacity: 0.95, title: location.name });
                              marker.addListener(`click`, () => markerClickHandler(marker));
                              return marker;
                          });
   

        

        
      } catch (error) {
        console.error(error);
      }
    
    }
  },
  watch: {
    searchResults() {
      this.loadMap();
    }
  },
  computed: {
      searchResults() {
        return this.$store.state.searchResults;
      }
  },
  mounted(){
    this.loadMap();
  }
  
};
</script>

<style>
html,
body {
  margin: 0;
  padding: 0;
}

.Map {
  width: 75%;
  height: 75vh;
}
</style>