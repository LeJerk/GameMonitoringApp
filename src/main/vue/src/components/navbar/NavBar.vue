<template>
    <div id="navbar">
        <b-navbar toggleable="lg" type="dark" variant="dark">
            <b-navbar-brand><strong>Team Game</strong></b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav>
                    <b-nav-item active href="/dashboard">Dashboard</b-nav-item>
                    <b-nav-item href="/wallet-traffic">Wallet traffic</b-nav-item>
                    <b-nav-item href="/system-log">System log</b-nav-item>
                    <b-nav-item disabled href="#">API</b-nav-item>
                </b-navbar-nav>
            </b-collapse>
        </b-navbar>
    </div>
</template>

<script>
    export default {
        name: "NavBar"
    }
</script>

<style scoped>

</style>
