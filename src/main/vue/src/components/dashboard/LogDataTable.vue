<template>
    <b-row>
        <b-col class="ml-1 mt-3" md>
            <b-collapse class="filter-panel" id="filter-collapse">
                <div class="panel panel-default">
                    <div class="panel-body">

                        <b-form inline>
                            <b-form-group
                                    id="per-page"
                                    label="Number of message:"
                                    label-for="per-page"
                                    label-size="md">
                                <b-form-select
                                        :options="pageOptions"
                                        class="ml-3"
                                        size="sm"
                                        v-model="perPage">
                                </b-form-select>
                            </b-form-group>

                            <b-form-group
                                    class="ml-3"
                                    id="filter-date-from"
                                    label="From:"
                                    label-for="filter-date-from"
                                    label-size="md">
                                <datetime
                                        class="ml-3"
                                        format="yyyy-MM-dd HH:mm"
                                        type="datetime"
                                        v-model="dateFrom">
                                    <template slot="button-cancel">
                                        <font-awesome-icon icon="times"></font-awesome-icon>
                                        Cancel
                                    </template>
                                    <template slot="button-confirm">
                                        <font-awesome-icon icon="check-circle"></font-awesome-icon>
                                        Confirm
                                    </template>
                                </datetime>
                            </b-form-group>

                            <b-form-group
                                    class="ml-3"
                                    id="filter-date-to"
                                    label="To:"
                                    label-for="filter-date-to"
                                    label-size="md">
                                <datetime
                                        class="ml-3"
                                        format="yyyy-MM-dd HH:mm"
                                        type="datetime"
                                        v-model="dateTo">
                                    <template slot="button-cancel">
                                        <font-awesome-icon icon="times"></font-awesome-icon>
                                        Cancel
                                    </template>
                                    <template slot="button-confirm">
                                        <font-awesome-icon icon="check-circle"></font-awesome-icon>
                                        Confirm
                                    </template>
                                </datetime>
                            </b-form-group>
                        </b-form>

                        <div class="mt-2 mb-3">
                            <b-form-input
                                    placeholder="Enter search string"
                                    v-model="filter">
                            </b-form-input>
                        </div>

                        <div class="row mb-2">
                            <div class="col-md-2">
                                <b-button
                                        :click="filterDate()"
                                        size="sm"
                                        variant="outline-primary">
                                    <font-awesome-icon icon="search"/>
                                    Apply
                                </b-button>
                            </div>
                            <div class="col-md">
                                <b-button
                                        :disabled="!filter"
                                        @click="filter = ''"
                                        size="sm"
                                        variant="outline-secondary">
                                    <font-awesome-icon icon="eraser"/>
                                    Clear
                                </b-button>
                            </div>
                        </div>
                    </div>
                </div>
            </b-collapse>
            <b-button
                    class="mt-2"
                    v-b-toggle.filter-collapse>
                <font-awesome-icon icon="filter"/>
                Filter options
            </b-button>
        </b-col>
        <b-col class="mt-4" md="12">
            <b-table
                    :current-page="currentPage"
                    :fields="fields"
                    :filter="filter"
                    :items="logData"
                    :per-page="perPage"
                    @filtered="onFiltered"
                    hover
                    responsive
                    show-empty
                    stacked="md"
                    striped>
                <template slot="extra"
                          slot-scope="row">
                    <b-button size="sm"
                              class="mr-2"
                              @click="row.toggleDetails">
                        {{ row.detailsShowing ? 'Hide' : 'Show' }} Details
                    </b-button>
                </template>

                <template
                        slot="row-details"
                        slot-scope="row">
                    <b-card>
                        <b-row class="mb-1">
                            <b-col class="text-sm-left" sm="3"><b>Extra information:</b></b-col>
                        </b-row>
                        <b-row class="mb-1">
                            <b-col>{{ row.item.extra.split('\n') }}</b-col>
                        </b-row>
                    </b-card>
                </template>
            </b-table>

            <b-row>
                <b-col class="my-1" md="6">
                    <b-pagination
                            :per-page="perPage"
                            :total-rows="totalRows"
                            class="my-0"
                            v-model="currentPage"
                    ></b-pagination>
                </b-col>
            </b-row>
        </b-col>
        <b-col class="ml-1 mr-1 mb-3 mt-3" md>
            <b-button block variant="primary">Load more</b-button>
        </b-col>
    </b-row>
</template>

<script>
    import {library} from '@fortawesome/fontawesome-svg-core';
    import {faCheckCircle, faEraser, faFilter, faSearch, faTimes} from '@fortawesome/free-solid-svg-icons';

    library.add(faFilter, faSearch, faEraser, faTimes, faCheckCircle);
    export default {
        name: "LogDataTable",
        data() {
            return {
                fields: [
                    {
                        key: 'timestamp',
                        label: 'Timestamp',
                        class: Date,
                        sortable: true
                    },
                    {
                        key: 'system',
                        label: 'Class',
                        class: String,
                        sortable: true
                    },
                    {
                        key: 'correlationId',
                        label: 'Correlation Id',
                        class: String,
                        sortable: true
                    }, {
                        key: 'logLevel',
                        label: 'Log Level',
                        sortable: true,
                        class: String
                    }, {
                        key: 'message',
                        label: 'Message',
                        sortable: false,
                        class: String
                    }, {
                        key: 'extra',
                        label: 'Extra',
                        type: String,
                        sortable: false
                    }
                ],
                logData: [
                    {
                        timestamp: new Date().toUTCString(),
                        system: 'Solid wallet',
                        correlationId: 'aaaaaa',
                        logLevel: 'Information',
                        message: 'Not so important message',
                        extra: 'User authenticated or what ever..',
                        _rowVariant: 'success'
                    },
                    {
                        timestamp: new Date().toUTCString(),
                        system: 'GameDAO',
                        correlationId: 'bbbbbb',
                        logLevel: 'Warning',
                        message: 'Somewhat important message',
                        extra: 'This request took waaay to long.. might want to investigate.',
                        _rowVariant: 'warning'
                    },
                    {
                        timestamp: new Date().toUTCString(),
                        system: 'GameSession',
                        correlationId: 'cccccc',
                        logLevel: 'Error',
                        message: 'Might want to take a look at this..',
                        extra: 'java.util.ArrayList.rangeCheck(ArrayList.java:657)\n' +
                            'java.util.ArrayList.get(ArrayList.java:433)\n' +
                            'com.freespin.tournament.logic.TournamentEngine.payWinners(TournamentEngine.java:288)\n' +
                            'com.freespin.tournament.logic.TournamentEngine.calculateTournamentStandings(TournamentEngine.java:137)\n' +
                            'com.freespin.tournament.cache.TournamentThread.run(TournamentThread.java:32)',
                        _rowVariant: 'danger'
                    },
                    {
                        timestamp: new Date().toUTCString(),
                        system: 'Process all filters',
                        correlationId: 'dddddd',
                        logLevel: 'Fatal',
                        message: 'Dude... shit is going down!!!',
                        extra: 'PLNG IS F-ING DOWN! RELEASE THE KRAKEN!!!',
                        _rowVariant: 'dark'
                    }
                ],
                perPage: 25,
                totalRows: 0,
                currentPage: 1,
                pageOptions: [25, 50, 100, 200],
                dateTo: new Date().toISOString(),
                dateFrom: '',
                logLevelFilter: 'all',
                filter: null
            }
        },
        methods: {
            setDateFromMinusOneWeek: function () {
                let oneWeekAgo = new Date();
                oneWeekAgo.setDate(oneWeekAgo.getDate() - 7);
                this.dateFrom = oneWeekAgo.toISOString();
            },
            setTotalItems: function () {
                this.totalRows = this.logData.length;
            },
            logLevelChanged: function (logLevel) {
                this.logLevelFilter = logLevel;
            },
            filterDate: function () {

            },
            onFiltered(filteredItems) {
                this.totalRows = filteredItems.length;
                this.currentPage = 1;
            }
        },
        watch: {
            logLevelFilter: function () {
                // round-trip to back-end to fetch the new given loglevel
            }
        },
        mounted() {
            this.setDateFromMinusOneWeek();
            this.setTotalItems();
        },
    }
</script>

<style scoped>
    @import "../../assets/scss/filter-options.scss";
</style>
