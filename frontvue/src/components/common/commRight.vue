<template>
    <aside class='commRight'>
        <!-- <ul>
            <li id='logo'>
                <div>Inventory</div>
                <div>Manager</div>
            </li>
            <li>HOME</li>
            <li>MANAGER</li>
            <li>STATE</li>
            <li>REGISTER</li>
            <li id="company">
                <div>Welcomt to Inventory</div>
                <div>Seoul Gangnam <br> ... </div>
                <div>@copyright demnodey</div>
            </li>
        </ul>
        <img id="left_btn" @click="toggle" src="../../assets/logo.png"  width="50"> -->
    </aside>
</template>

<script>
export default{
    name:'commRight',
    data() {
        return {
            
        }
    },
    methods: {
        resize:function () {
            // $(window).resize(function(){
            //     var height = (window.innerHeight / 2) + px;
            //     $('#left_btn').css({'top': height})                
            // });
        }
    },
    created() {
        this.resize();
    },
}

</script>

<style>
  /* a{color:black}
  a:hover{color:rgb(255,98,124);}
  .commLeft{
    position:fixed; 
    top:0px; 
    left:0px; 
    width:250px; 
    width:300px; 
    height:1000px; 
    background:rgba(255,98,124,0.6); 
    padding:40px 0; 
    overflow: hidden
  }
  .commLeft ul {padding: 0 30px}
  .commLeft ul li { font-size:25px;  height:75px;} 
  .commLeft ul li#logo {font-family: 'Passion One', cursive; font-size:50px; height:170px;}
  .commLeft ul li#logo div {line-height: 0.8}
  .commLeft ul li#company {font-size:16px; margin-top:150px; }
  #left_btn {position:fixed; top:495px; left:-60px; cursor:pointer} */

.commRight {
  width: 200px;
  /* background-color: #f4f4f4;
  border-right: 1px solid #ddd;
  padding: 15px;
  box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1); */
  
}
</style>


