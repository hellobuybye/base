<template>
    <header>
		<h1><a href="#" class="logo"><img alt="Vue logo" src="../../assets/logo.png" width="110"></a></h1> 
		<div>윤환이의 놀이터</div>
	</header>
</template>

<script>
export default{
    name:'commHeader',
    data() {
        
    },
    methods: {
        
    },
    created() {
        
    },
}

</script>

<style>
	header{width:100%; text-align:center; position:relative; height:120px; border-bottom:1px solid #35495e}
	header h1{position:absolute; top:0; left:100px;}
	header div{position:absolute; top:0; left:100px;}	
	/* header ul.menu:after{display:block; clear:both; content:'';}
	header ul.menu{position:absolute; top:20px; right:50px;}
	header ul.menu li{float:left; padding:10px 20px; list-style:none;} */

	a{text-decoration:none; color:coral;}
</style>


