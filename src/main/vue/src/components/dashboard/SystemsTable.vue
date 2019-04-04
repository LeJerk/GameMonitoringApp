<template>
    <div class="row">
        <div class="col-md">
            <b-table
                    :fields="fields"
                    :items="services"
                    @row-clicked="showDetails"
                    hover
                    responsive
                    small
                    striped>
            </b-table>
        </div>
    </div>
</template>

<script>
    export default {
        name: "SystemsTable",
        data() {
            return {
                fields: [
                    {
                        key: 'system',
                        label: 'Service',
                        class: String,
                        sortable: true
                    },
                    {
                        key: 'activeModules',
                        class: String,
                        sortable: true
                    },
                    {
                        key: 'logsPerSecond',
                        label: 'Logs/s',
                        sortable: true,
                        class: String,
                        variant: 'info'
                    }, {
                        key: 'todaysErrorLogs',
                        label: 'Errors today',
                        sortable: true,
                        class: String,
                        variant: 'danger'
                    }
                ],
                services: [
                    {system: "Freespin Game", activeModules: 40, logsPerSecond: 4000, todaysErrorLogs: 440},
                    {system: "Freespin Account", activeModules: 55, logsPerSecond: 1500, todaysErrorLogs: 200},
                    {system: "Game Filter", activeModules: 100, logsPerSecond: 3300, todaysErrorLogs: 500},
                    {system: "Game Admin", activeModules: 10, logsPerSecond: 15, todaysErrorLogs: 5},
                    {system: "Game Datahub", activeModules: 33, logsPerSecond: 300, todaysErrorLogs: 10}
                ]
            }
        },
        methods: {
            showDetails: function (service) {
                this.$emit('systemChanged', service);
            }
        },
        mounted() {
            this.showDetails(this.services[0]);
        },
    }
</script>

<style scoped>

</style>
