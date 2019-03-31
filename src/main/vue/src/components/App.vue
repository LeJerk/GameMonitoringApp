<template>
    <div id="app">
        <NavBar/>
        <router-view></router-view>
    </div>
</template>

<script defer>
    import NavBar from "./navbar/NavBar";

    export default {
        name: 'App',
        components: {
            NavBar
        },
    };
</script>

<style>
    @import '../assets/styles/app.scss';
</style>
