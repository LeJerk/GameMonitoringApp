<template>
    <b-row>
        <b-col md>
            <b-table
                    hover
                    responsive
                    small
                    :fields="fields"
                    :items="services"
                    @row-clicked="showDetails"
                    striped>
            </b-table>
        </b-col>
    </b-row>
</template>

<script>
    import httpClient from '../../assets/http-connector';

    export default {
        name: "SystemsTable",
        data() {
            return {
                fields: [],
                services: []
            }
        },
        methods: {
            showDetails: function (service) {
                this.$emit('systemChanged', service);
            },
            /* eslint-disable no-console */
            fetchSystems() {
                httpClient
                    .get('/services')
                    .then(response => {
                        this.services = response.data;
                        this.showDetails(this.services[0]);
                    });
            },
            fetchFields() {
                httpClient
                    .get('/services/fields')
                    .then(response => {
                        this.fields = response.data;
                    });
            }
            /* eslint-enable no-console */
        },
        mounted() {
            this.fetchSystems();
            this.fetchFields();
        },
    }
</script>

<style scoped>

</style>
