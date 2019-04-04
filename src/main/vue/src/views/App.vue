<template>
    <div id="app">
        <NavBar/>
        <router-view></router-view>
    </div>
</template>

<script>
    import NavBar from "../components/navbar/NavBar";

    export default {
        name: 'App',
        components: {
            NavBar
        },
    };
</script>

<style scoped>
    @import '../assets/scss/app.scss';
</style>
