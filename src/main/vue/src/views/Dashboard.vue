<template>
    <b-container fluid>
        <SystemsTable v-on:systemChanged="systemChanged"/>
        <b-row>
            <b-col class="ml-1 mb-2" md>
                <h3>{{ this.selectedSystem.system }}</h3>
            </b-col>
        </b-row>
        <LogLevelsFilter/>
        <LogDataTable/>
        <b-row class="white-noise">
        </b-row>
    </b-container>
</template>

<script>
    import SystemsTable from "../components/dashboard/SystemsTable";
    import LogLevelsFilter from "../components/dashboard/LogLevelsFilter";
    import LogDataTable from "../components/dashboard/LogDataTable";

    export default {
        name: "Dashboard",
        components: {
            LogDataTable,
            SystemsTable,
            LogLevelsFilter
        },
        data() {
            return {
                selectedSystem: {
                    system: ''
                }
            }
        },
        methods: {
            systemChanged: function (system) {
                this.selectedSystem = system;
            }
        }
    }
</script>

<style scoped>
    @import "../assets/scss/dashboard.scss";
</style>
