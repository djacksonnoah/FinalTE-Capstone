import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Selection from '../views/Selection.vue'
import Landmark from '../views/Landmark.vue'
import Map from '../views/Map.vue'
import Itinerary from '../views/Itinerary.vue'
import ItineraryDetail from '../views/ItineraryDetail.vue'
import DeleteConfirmation from '../views/DeleteConfirmation.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/selection",
      name: "selection",
      component: Selection,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/landmark/:id",
      name: "landmark",
      component: Landmark,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/map",
      name: "map",
      component: Map,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/itinerary",
      name: "itinerary",
      component: Itinerary,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/itinerary-detail/:id",
      name: "itinerary-detail",
      component: ItineraryDetail,
      meta: {requiresAuth: true}
    },
    {
      path: "/delete-confirmation/:id",
      name: "delete-confirmation",
      component: DeleteConfirmation,
      meta: {requiresAuth: true}
    }
    
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
