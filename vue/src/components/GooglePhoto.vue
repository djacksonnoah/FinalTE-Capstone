<template>
  <div>
    <div>
      <form v-on:submit.prevent>
        <div>
          <div>
              <img v-bind:src="imageUrl"><br>
              <span>Photo credit: </span>
              <div class="credit" 
                v-for="credit in photo.html_attributions"
                v-bind:key="credit.id"
                v-html="credit"
                >
              </div>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      api: 'https://maps.googleapis.com/maps/api/place',
      apiKey: 'AIzaSyDUUNEBwDoixdTOMin2SZ09-JLTDtxQZ0E',
      photoPath: '/photo?maxheight=300&photoreference='
    }
  },
  props: {
    photo: {
      html_attributions: [],
      photo_reference: ""
    },
    height: {}
  },
  computed: {
    imageUrl() {
      const url = this.api + this.photoPath + this.photo.photo_reference + "&key=" + this.apiKey;
      return url;
    }
  }

}
</script>

<style>
.credit{
  display: inline;
}
</style>
