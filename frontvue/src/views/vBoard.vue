<template>

    <div class='vBoard'>
        <h2 class="title">기본 게시판</h2>


		<table class="board">
            <thead>
                <tr>
                    <th>#</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>날짜</th>
                    <!-- <th>조회수</th> -->
                </tr>
            </thead>
            <tbody>
				<vPost v-for="post in postList" :key="post.id" :post="post"></vPost>
				
            </tbody>
        </table>

		<vPagination :totalPage="totalPage" :currentPage="getCurPage" :pageSize="6" @change-page="doPaging"/>
		
    </div>
</template>

<script>

import vPost from "./components/vPost.vue";
import vPagination from "./components/vPagination.vue";

export default{
    name:'vBoard',
	components : {
		vPost,
		vPagination,
	},
    data() {
        return {
            postList : [

				{ pId: 0, title: "게시판 샘플 1", writter: "홍길동", pDate: "2024-10-15" },
				{ pId: 1, title: "게시판 샘플 2", writter: "이몽룡", pDate: "2024-10-16" },
				{ pId: 2, title: "게시판 샘플 3", writter: "춘향", pDate: "2024-10-17" },
				{ pId: 3, title: "게시판 샘플 4", writter: "박혁거세", pDate: "2024-10-18" },

			],
            
            totalPage:10,
            currentPage: 1,
        }
    },
	setup(){		
       

	},
    computed:{

        getCurPage(){

            let page = this.$route.query.page;            
            page = ( page ? Number(page)  : 1 );
            return page;

            // let page = this.$route.query.page;
            // return page && !isNaN(page) ? Number(page) : 1; 
        }       
    },
    methods: {
        doPaging(page){
            this.currentPage = page;
        }
    },
    created() {
        
    },
}

</script>

<style>

.title {
	text-align: center;
	color: #333;
	margin-bottom: 20px;
}

.board {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
}

.board th {
  padding: 10px;
  text-align: left;
  border-bottom: 1px solid #ddd;
  background-color: #f4f4f4;
  color: #333;
  font-weight: bold;
}

.board tr:hover {
  background-color: #f1f1f1;
}



</style>


