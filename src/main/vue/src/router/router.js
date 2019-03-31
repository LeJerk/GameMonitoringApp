import Vue from 'vue';
import Router from 'vue-router';

import WalletTraffic from "../components/wallet-traffic/WalletTraffic";
import Dashboard from "../components/dashboard/Dashboard";

Vue.use(Router);

export default new Router
({
    mode: 'history',
    routes: [
        {
            path: '/',
            redirect: {
                name: "dashboard"
            }
        },
        {
            path: '/dashboard',
            name: 'dashboard',
            component: Dashboard,
        },
        {
            path: '/wallet-traffic',
            name: 'wallet-traffic',
            component: WalletTraffic,
        }
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
