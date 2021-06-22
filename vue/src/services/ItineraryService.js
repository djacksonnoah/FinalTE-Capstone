import axios from 'axios';
//import { get } from 'core-js/core/dict';



export default {

    create(itinerary) {
        //change this so the key is not hardcoded in
      // const url = `/itinerary`;
      console.log(itinerary);
      return axios.post(`/itineraries/`, itinerary);
    },
    get(id) {
      return axios.get(`/itineraries/${id}`);
    },
    getByUser(userId) {
      return axios.get(`/itineraries/user/${userId}`);
    },
    update(itinerary) {
      return axios.put(`/itineraries/${itinerary.itineraryId}`, itinerary)
    },
    delete(id) {
      return axios.delete(`/itineraries/${id}`);
    }
  }
