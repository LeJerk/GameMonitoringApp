<template>
    <b-row>
        <b-col class="ml-1" md>
            <b-button-group>
                <b-button
                        :key="level.name"
                        :variant="level.variant"
                        v-for="level in logLevels"
                        :pressed.sync="level.state"
                        v-on:click="changeLogLevel(level)">
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
                    {name: "all", logs: 205, variant: 'outline-info', state: true},
                    {name: "info", logs: 40, variant: 'outline-success', state: false},
                    {name: "warning", logs: 55, variant: 'outline-warning', state: false},
                    {name: "error", logs: 100, variant: 'outline-danger', state: false},
                    {name: "fatal", logs: 10, variant: 'outline-dark', statue: false},

                ]
            }
        },
        methods: {
            changeLogLevel: function (level) {
                this.logLevels.find(function (element) {
                    if (element.state === true) {
                        element.state = false;
                    }

                    if (element === level) {
                        element.state = true;
                    }
                });

                this.$emit('logLevelChanged', level.name);
            }
        }
    }
</script>

<style scoped>

</style>
