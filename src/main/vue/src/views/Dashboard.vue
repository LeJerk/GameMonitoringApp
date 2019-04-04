<template>
    <div id="dashboard">
        <SystemsTable v-on:systemChanged="systemChanged"/>
        <div class="row">
            <div class="col-md ml-1 mb-2">
                <h3>{{ this.selectedSystem.system }}</h3>
            </div>
        </div>
        <LogLevelsFilter/>
        <FilterOptions/>
    </div>
</template>

<script>
    import SystemsTable from "../components/dashboard/SystemsTable";
    import LogLevelsFilter from "../components/dashboard/LogLevelsFilter";
    import FilterOptions from "../components/dashboard/FilterOptions";

    export default {
        name: "Dashboard",
        components: {
            SystemsTable,
            LogLevelsFilter,
            FilterOptions
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
