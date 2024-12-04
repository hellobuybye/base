<template>
    <header>
		<div class="logo">
			<a href="/" ><img alt="Vue logo" src="../../assets/logo.png"></a>
			<span class="title">윤환이의 놀이터</span>
		</div>
		
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

<style scoped>
	header{
		width:100%; 
		border-bottom:1px solid #35495e;
		padding-top: 20px;		
		padding-bottom: 20px;		
	}

	header a{
		padding-bottom: 0px;
		margin-bottom: 0px;
		
	}	

	header .logo{
		display: flex;
		/* flex-direction: row; */
		padding-Left:20px;
		align-items: center;
		
	}	

	header .logo img{
		width: auto;
		height: 32px;
	}	
	header .logo .title{
		margin-left:10px;
		margin-bottom: 0px;
		font-size: 30px;
		font-weight: bold;				
		
	}	
	
</style>


