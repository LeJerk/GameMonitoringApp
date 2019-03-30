<template>
    <div class="searchform">
        <h4>Find by Age</h4>
        <div class="form-group">
            <input class="form-control" id="age" name="age" required type="number" v-model="age">
        </div>

        <div class="btn-group">
            <button class="btn btn-success" v-on:click="searchCustomers">Search</button>
        </div>

        <ul class="search-result">
            <li :key="index" v-for="(customer, index) in customers">
                <h6>{{customer.name}} ({{customer.age}})</h6>
            </li>
        </ul>
    </div>
</template>

<script>
    import http from "../mixins/http-connector";

    export default {
        name: "search-customer",
        data() {
            return {
                age: 0,
                customers: []
            };
        },
        methods: {
            /* eslint-disable no-console */
            searchCustomers() {
                http
                    .get("/customers/age/" + this.age)
                    .then(response => {
                        this.customers = response.data; // JSON are parsed automatically.
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });
            }
            /* eslint-enable no-console */
        }
    };
</script>

<style>
    .searchform {
        max-width: 300px;
        margin: auto;
    }

    .search-result {
        margin-top: 20px;
        text-align: left;
    }
</style>
