import Vue from 'vue';
import Router from 'vue-router';

import WalletTraffic from "../views/WalletTraffic";
import Dashboard from "../views/Dashboard";
import SystemLog from "../views/SystemLog";

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
        },
        {
            path: '/system-log',
            name: 'system-log',
            component: SystemLog,
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
