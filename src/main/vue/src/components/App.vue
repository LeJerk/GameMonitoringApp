<template>
  <div id="app">
    <Dashboard/>
  </div>
</template>

<script>
  import Dashboard from './dashboard/Dashboard';

  export default {
    name: 'App',
    components: {
      Dashboard,
    },
  };
</script>

<style>
  @import '../assets/styles/app.css';
</style>
