import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    searchResults: [],
    itineraries: [],
    itinerary: {
      itineraryId: '',
      userId: '',
      name: '',
      itineraryDate: ''
    },
    landmarks: [],
    landmark: {
      locationId: '',
      name: '',
      latitude: '',
      longitude: '',
      itineraryId: '',
      address: '',
      locationOrder: ''
    },
    userLocations: []
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_SEARCH_RESULTS(state, results) {
      state.searchResults = results;
    },
    SET_ITINERARY(state, itinerary) {
      state.itinerary = itinerary;
    },
    SET_ITINERARIES(state, itineraries) {
      state.itineraries = itineraries;
    },
    SET_LANDMARKS(state, landmarks) {
      state.landmarks = landmarks;
    },
    SET_LANDMARK(state, landmark) {
      state.landmark = landmark;
    },
    ADD_LANDMARK(state, landmark) {
      state.landmark.push(landmark);
    },
    SET_USER_LOCATIONS(state, userLocations) {
      state.userLocations = userLocations;
    },
  }
})
