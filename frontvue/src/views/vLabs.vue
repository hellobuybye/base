<template>
    <div class='vlabs'>
        <h1>실험실</h1>

        <br>

        <div>
            <h3>버튼연습</h3>
            <button @click="clickEvt(0)" color="success">Button_1</button>
            <button @click="clickEvt(1)" color="success">Button_2</button>
            <button @click="clickEvt(2)" color="success">Button_3</button>
            <div>
                버튼 결과 : {{ buttonResult }}
            </div>
        </div>

        <div>
            <h3>input 연습</h3>
            <input type="text" v-model="inputText">
            <button @click="inputClick()" color="success">입력</button>
            <div>
                입력된 문자 : {{ inputResult }}
            </div>
        </div>
        

    </div>
</template>

<script>
export default{
    name:'vLabs',

    setup(){
        
    },
    data() {
        return {
            tempList : ["HTML", "CSS", "Javascript"],
            buttonResult : '(button result)',            
            inputResult:'(input result)',

            inputText : '입력하세요'
        }
    },
    methods: {
        clickEvt(v){
            this.buttonResult = this.tempList[v];
        },
        inputClick(){
            this.inputResult = this.inputText;

        }
    },
    created() {
        
    },
}

</script>

<style>
  
</style>


