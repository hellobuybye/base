<template>
	
    <nav>
		<!-- <router-link to="/">Home</router-link> |
		<router-link to="/about">About</router-link> |
		<router-link to="/labs">실험실</router-link> |
		<router-link to="/menu1">메뉴1</router-link> | 
		<router-link to="/menu2">메뉴2</router-link> -->

		<router-link v-for="menu of menuList" :key="menu.id" :to="`${menu.link}`" >{{ menu.title }} | </router-link>		
		
		
	</nav>
	
</template>

<script>
export default{
    name:'commNav',
    data() {
		return{
			menuList : [{
				id : 0,
				order : 1,
				title : "Home",
				link : "/"
			}, {
				id : 1,
				order : 2,
				title : "About",
				link : "/about"
			}, {
				id : 2,
				order : 3,
				title : "labs",
				link : "/labs"
			}, {
				id : 3,
				order : 4,
				title : "Menu1",
				link : "/menu1"
			}, {
				id : 4,
				order : 5,
				title : "Menu2",
				link : "/menu2"
			}]
		}
        
    },
    methods: {
        
    },
    created() {
        this.menuList;
    },
}

</script>

<style>
	/* header{width:100%; text-align:center; position:relative; height:120px; border-bottom:1px solid #35495e}
	header nav{position:absolute; top:0; left:100px;}
	header ul.menu:after{display:block; clear:both; content:'';}
	header ul.menu{position:absolute; top:20px; right:50px;}
	header ul.menu li{float:left; padding:10px 20px; list-style:none;}

	a{text-decoration:none; color:coral;} */

	nav {
		padding: 30px;
	}

	nav a {
		font-weight: bold;
		color: #2c3e50;
	}

	nav a.router-link-exact-active {
		color: #42b983;
	}
</style>


