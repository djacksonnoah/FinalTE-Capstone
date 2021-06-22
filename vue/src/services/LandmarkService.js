 import axios from 'axios';
import { create } from 'core-js/core/object';


export default {
    get(itineraryId) {
        return axios.get(`/locations/${itineraryId}`)
    },
    getLocationsByUserId(userId) {
        return axios.get(`/locations/user/${userId}`)
    },
    create(location) {
        return axios.post(`/locations/`, location)
    },

    delete(locationId) {
        return axios.delete(`/locations/${locationId}`)
    },

    update(locationId) {
        return axios.put(`/locations/${locationId}`)
    }

};
