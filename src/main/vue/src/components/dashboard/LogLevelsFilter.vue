<template>
    <b-row>
        <b-col class="ml-1" md>
            <b-button-group>
                <b-button
                        :key="level.name"
                        :variant="level.variant"
                        v-for="level in logLevels"
                        v-on:click="changeLogLevel(level.name)">
                    {{ level.name }} ({{ level.logs }})
                </b-button>
            </b-button-group>
        </b-col>
    </b-row>
</template>

<script>
    export default {
        name: "LogLevelsFilter",
        data() {
            return {
                logLevels: [
                    {name: "all", logs: 205, variant: 'info'},
                    {name: "info", logs: 40, variant: 'success'},
                    {name: "warning", logs: 55, variant: 'warning'},
                    {name: "error", logs: 100, variant: 'danger'},
                    {name: "fatal", logs: 10, variant: 'dark'},

                ]
            }
        },
        methods: {
            changeLogLevel: function (levelName) {
                this.$emit('logLevelChanged', levelName);
            }
        }
    }
</script>

<style scoped>

</style>
