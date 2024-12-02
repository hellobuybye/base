<template>
    <aside class='commLeft'>
        <span class="first-depth" href="#">Board</span>
        <ul class="second-depth">
            <li class="second-depth"><a href="#"> test 1</a></li>
            <li class="second-depth"><a href="#"> test 2</a></li>
            <li class="second-depth"><a href="#"> test 3</a></li>
            <li class="second-depth"><a href="#"> test 4</a></li>
        </ul>
    </aside>
</template>

<script>
export default{
    name:'commLeft',
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
 

.commLeft {
  width: 200px;
  background-color: #ffffffdc;
  color: #ecf0f1;
  padding: 15px;
  border-right: 1px sox rgba(0, 0, 0, 0.1);
  overflow-y: auto; /* 스크롤 지원 */
}

/* .commLeft a {  
  font-weight: bold;
} */
.commLeft .first-depth {
    display: block;
    padding: 10px 20px;
    color: #2c3e50;
    font-size: 16px;
    font-weight: bold;
    
}

.commLeft ul {    
    /* list-style: none; */
    padding: 0;
}

.commLeft a:hover {
  background-color: #42b883;
}

.second-depth li{
  margin-left: 20px;
}

.second-depth li a {
  color: #285b7e;
  font-size: 14px;
  padding: 8px 0px;
  display: block;
  text-decoration: none;
}

.second-depth li a:hover {
  background-color: #42b883;
}

</style>


