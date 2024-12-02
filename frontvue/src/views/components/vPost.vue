<template>
    
    <!-- <tr>
        <td>2</td>
        <td><a href="#">또 다른 게시글</a></td>
        <td>이몽룡</td>
        <td>2024-11-28</td>
    </tr> -->
    <tr>
        <td>{{ post.pId }}</td>
        <td><a href="#">{{ post.title }}</a></td>
        <td>{{ post.writter }}</td>
        <td>{{ post.pDate }}</td>        
    </tr>
    

</template>

<script>
export default{
    name:'vPost',

    props:{
        post:{
            type: Object,
            required:true,
        }
    },
    data() {
        return {
            
        }
    },
    methods: {
        
    },
    created() {
        
    },
}

</script>

<style>

.board tr:hover {
  background-color: #f1f1f1;
}


.board td {
  padding: 10px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

.board td a {
  text-decoration: none;
  color: #007bff;
}

.board td a:hover {
  text-decoration: underline;
}

</style>


