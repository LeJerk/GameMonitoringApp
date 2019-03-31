<template>
    <div class="submitform">
        <div v-if="!submitted">
            <div class="form-group">
                <label for="name">Name</label>
                <input class="form-control" id="name" name="name" required type="text" v-model="customer.name">
            </div>

            <div class="form-group">
                <label for="age">Age</label>
                <input class="form-control" id="age" name="age" required type="number" v-model="customer.age">
            </div>

            <button class="btn btn-success" v-on:click="saveCustomer">Submit</button>
        </div>

        <div v-else>
            <h4>You submitted successfully!</h4>
            <button class="btn btn-success" v-on:click="newCustomer">Add</button>
        </div>
    </div>
</template>

<script>
    import http from '../../assets/http-connector'

    export default {
        name: 'add-customer',
        data() {
            return {
                customer: {
                    id: 0,
                    name: '',
                    age: 0,
                    active: false
                },
                submitted: false
            }
        },
        methods: {
            /* eslint-disable no-console */
            saveCustomer() {
                var data = {
                    name: this.customer.name,
                    age: this.customer.age
                };

                http
                    .post('/customer', data)
                    .then(response => {
                        this.customer.id = response.data.id;
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });

                this.submitted = true;
            },
            newCustomer() {
                this.submitted = false;
                this.customer = {};
            }
        }
    }
</script>

<style>
    .submitform {
        max-width: 300px;
        margin: auto;
    }
</style>
