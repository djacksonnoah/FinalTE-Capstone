import axios from 'axios';


export default {

    search(searchText) {
        //change this so the key is not hardcoded in
      const url = `/maps/search?search=${searchText}`;
      return axios.get(url);
    }
  
  }