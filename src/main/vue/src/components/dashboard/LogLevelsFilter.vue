<template>
    <div class="row">
        <div class="col-md ml-1">
            <b-button-group>
                <b-button
                        :key="level.name"
                        :variant="level.variant"
                        v-for="level in logLevels"
                        v-on:click="changeLogLevel(level.name)">
                    {{ level.name }}
                </b-button>
            </b-button-group>
        </div>
    </div>
</template>

<script>
    export default {
        name: "LogLevelsFilter",
        data() {
            return {
                logLevels: [
                    {name: "info", logs: 40, variant: 'info'},
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
