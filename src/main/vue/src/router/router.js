import Vue from 'vue';
import Router from 'vue-router';
// import CustomersList from '../components/CustomersList.vue';
import AddCustomer from '../components/temp/AddCustomer.vue';
import SearchCustomers from '../components/temp/SearchCustomers.vue';
// import Customer from '../components/Customer.vue';
import App from '../components/App';

Vue.use(Router);

export default new Router({

  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'app',
      component: App,
    },
    {
      path: '/add',
      name: 'add',
      component: AddCustomer,
    },
    {
      path: '/search',
      name: 'search',
      component: SearchCustomers,
    },
  ],
});

// mode: 'history',
//   routes: [
//   {
//     path: '/',
//     name: 'customers',
//     alias: '/customer',
//     component: CustomersList,
//     children: [
//       {
//         path: '/customer/:id',
//         name: 'customer-details',
//         component: Customer,
//         props: true,
//       },
//     ],
//   },
