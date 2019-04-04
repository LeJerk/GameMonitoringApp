import Vue from 'vue';
import App from './views/App';
import router from './router/router';

import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import {library} from '@fortawesome/fontawesome-svg-core';
import {faUserSecret} from '@fortawesome/free-solid-svg-icons';
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome';
import Datetime from 'vue-datetime';
import 'vue-datetime/dist/vue-datetime.css';

Vue.use(BootstrapVue);

library.add(faUserSecret);
Vue.component('font-awesome-icon', FontAwesomeIcon);

Vue.use(Datetime);

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    render: (h) => h(App),
}).$mount('#app');
