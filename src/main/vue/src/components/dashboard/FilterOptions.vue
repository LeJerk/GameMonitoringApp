<template>
    <div class="row">
        <div class="col-md ml-1 mt-3">
            <b-collapse class="filter-panel" id="filter-collapse">
                <div class="panel panel-default">
                    <div class="panel-body">

                        <b-form inline>
                            <b-form-group
                                    id="take-size"
                                    label="Number of message:"
                                    label-for="take-size"
                                    label-size="md"
                            >
                                <b-form-select
                                        :options="sizes"
                                        class="ml-3"
                                        size="sm" v-model="newTakeSize"></b-form-select>
                            </b-form-group>

                            <b-form-group
                                    class="ml-3"
                                    id="filter-date-from"
                                    label="From:"
                                    label-for="filter-date-from"
                                    label-size="md"
                            >
                                <datetime class="ml-3" v-model="dateFrom"></datetime>
                            </b-form-group>

                            <b-form-group
                                    class="ml-3"
                                    id="filter-date-to"
                                    label="To:"
                                    label-for="filter-date-to"
                                    label-size="md"
                            >
                                <datetime class="ml-3" v-model="dateTo"></datetime>
                            </b-form-group>
                        </b-form>

                        <div class="form-search-filter">
                            <label for="search">Search message:</label>
                            <input class="form-control" id="search" type="text" v-model="searchTerm">
                        </div>

                        <div class="row mb-2">
                            <div class="col-md-2">
                                <b-button
                                        size="sm"
                                        variant="outline-primary">
                                    <font-awesome-icon icon="search"/>
                                    Apply
                                </b-button>
                                <!--filterDate(loglevel, dateFrom, dateTo, takeSize)"-->
                            </div>
                            <div class="col-md">
                                <b-button
                                        size="sm"
                                        variant="outline-secondary">
                                    <font-awesome-icon icon="eraser"/>
                                    Clear
                                </b-button>
                                <!--clearFilter()"-->
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
        </div>
    </div>
</template>

<script>
    import {library} from '@fortawesome/fontawesome-svg-core';
    import {faEraser, faFilter, faSearch} from '@fortawesome/free-solid-svg-icons';

    library.add(faFilter, faSearch, faEraser);

    export default {
        name: "FilterOptions",
        data() {
            return {
                takeSize: 25,
                newTakeSize: 25,
                sizes: [25, 50, 100, 200],
                dateTo: new Date(),
                dateFrom: new Date() - 1,
                searchTerm: ''
            }
        },
    }
</script>

<style scoped>
    @import "../../assets/scss/filter-options.scss";
</style>
