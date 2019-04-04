<template>
    <div id="system-log">
        <div class="row">
            <div class="col-sm-12 top-buffer">
                <div class="collapse filter-panel" id="filter-panel">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <form class="form-inline" role="form">
                                <div class="form-group">
                                    <label>Number of message:</label>
                                    <select class="form-control takesize-filter" value.bind="takeSize">
                                        <option model.bind="25" selected="selected">25</option>
                                        <option model.bind="50">50</option>
                                        <option model.bind="100">100</option>
                                        <option model.bind="200">200</option>
                                    </select>
                                </div><!-- form group [takeSize] -->
                                <div class="form-group">
                                    <label class="filter-col">From:</label>
                                    <date-time-picker/>
                                </div><!-- form group [dateFrom] -->
                                <div class="form-group">
                                    <label class="filter-col">To:</label>
                                    <date-time-picker/>
                                </div><!-- form group [dateTo] -->
                            </form>
                            <div class="form-search-filter">
                                <label>Search message:</label>
                                <input class="form-control search-filter" type="text" value.bind="searchTerm">
                            </div><!-- form group [search] -->
                            <div class="form-group">
                                <div class="col-sm-2 append-default">
                                    <button class="btn btn-default filter-col"
                                            click.delegate="filterDate(loglevel, dateFrom, dateTo, takeSize)"
                                            type="submit">
                                        <span class="fa fa-search"></span> Apply
                                    </button>
                                </div>
                                <div class="col-sm-2 append-default">
                                    <button class="btn btn-default filter-col" click.delegate="clearFilter()"
                                            type="submit">
                                        <span class="fa fa-eraser"></span> Clear
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <button class="btn btn-primary" data-target="#filter-panel" data-toggle="collapse" type="button">
                    <span class="fa fa-filter"></span> Filter options
                </button>
                <table aurelia-table="data.bind: searchResult.Entities; display-data.bind: $logData; filters.bind: filters;"
                       class="table table-sm table-responsive tbl-fixed"
                       show.bind="searchResult.Entities.length > 0">
                    <thead>
                    <tr>
                        <th aut-sort="custom.bind: dateSort" class="col-sm-2">Timestamp</th>
                        <th class="col-sm-1">System</th>
                        <th class="col-sm-2">CorrelationId</th>
                        <th class="col-sm-1">Log Level</th>
                        <th>Message</th>
                        <!--<th>Exception</th>-->
                    </tr>
                    </thead>
                    <tbody>
                    <tr aut-select="row.bind: logItem" class="${loglevelCss(logItem.LogLevel)} logMsg"
                        repeat.for="logItem of $logData">
                        <td><a click.delegate="filterOnTimeInterval(logItem.Timestamp)">${logItem.Timestamp |
                            fromUnixTime}</a></td>
                        <td>${getLastPartInSystemName(logItem.System)}</td>
                        <th><a click.delegate="filterOnCorrId(logItem.CorrelationId)">${logItem.CorrelationId}</a></th>
                        <td>${logItem.LogLevel}</td>
                        <td>${logItem.Message}</td>
                        <!--<td>${logItem.exception}</td>-->
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-12 text-center" if.bind="searchResult.Bookmark.length > 0">
                <button class="btn btn-default" click.delegate="loadMore()">Load more</button>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "SystemLog"
    }
</script>

<style scoped>
    @import "../assets/scss/dashboard.scss";
</style>
