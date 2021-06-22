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

        if(this.locationResults.length > 0)
        {
          address = this.locationResults[0].address;
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

      
        
        const locations = this.locationResults.map(result => {
          const lat = result.latitude;
          const lng = result.longitude;
          const location = {lat: lat, lng:lng};
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





//       const directionsService = new google.maps.DirectionsService();
//       const directionsRenderer = new google.maps.DirectionsRenderer();
//       directionsRenderer.setMap(map);
//       document.getElementById("submit").addEventListener("click", () => {
//         calculateAndDisplayRoute(directionsService, directionsRenderer, locations);
//       });

//       calculateAndDisplayRoute(directionsService, directionsRenderer, locations) 
//       {
        
//       }
//         directionsService.route(
//         {
//           origin: document.getElementById("start").value,
//           destination: document.getElementById("end").value,
//           waypoints: locations,
//           optimizeWaypoints: true,
//           travelMode: google.maps.TravelMode.DRIVING,
//         },
//           (response, status) => {
//           if (status === "OK" && response) {
//           directionsRenderer.setDirections(response);
//           const route = response.routes[0];
//           const summaryPanel = document.getElementById("directions-panel");
//           summaryPanel.innerHTML = "";
       
//       } 
//     }
//   );
// }
     








     
    
    }
  },
  watch: {
    locationResults() {
      this.loadMap();
    }
  },
  computed: {
      locationResults() {
        return this.$store.state.landmarks;
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
  width: 80%;
  height: 75vh;
}
</style>