<template>

    <div class="pagination">
      
      <!-- <a href="#">&laquo;</a> -->
      <a href="#" 
        @click="changePage(currentPage - 1)">&laquo;</a>

        <!-- <a href="#" class="active">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a> -->

        <a v-for="page in visiblePages" :key="page" 
          href="#" 
          @click="changePage(page)"
          :class="{ active: currentPage === page }">
            {{ page }}
        </a>

        <!-- <a href="#">&raquo;</a> -->
        <a href="#"
          @click="changePage(currentPage + 1)">&raquo;</a>
        
    </div>

</template>

<script>
export default{
    name:'vPagination',
    data() {
        return {
            
        }
    },
    props:{
      totalPage : {
        type: Number,
        Required:true,
      },
      currentPage : {
        type: Number, 
        Required:true,
      },
      pageSize : {
        type: Number,
        Required:true,        
      }
    },
    computed:{
      visiblePages(){
        const half = Math.floor(this.pageSize / 2); // 가운데 기준으로 페이지 범위 설정
        let start = Math.max(this.currentPage - half, 1);
        let end = Math.min(start + this.pageSize - 1, this.totalPage);

        // start와 end가 조정되었을 때 반대로 맞추기
        if (end - start + 1 < this.pageSize) {
          start = Math.max(end - this.pageSize + 1, 1);
        }

        // 범위 내의 페이지 리스트 반환
        return Array.from({ length: end - start + 1 }, (_, i) => start + i);
      }
    },
    methods: {
      changePage(page){

        if(page > 0 && page <= this.totalPage){
          
          this.$emit("change-page", page); // 상위컴포넌트로 컨트롤 넘김          
        }

      }
    },
    created() {
        
    },
}

</script>

<style scoped>
.pagination {
  display: flex;
  justify-content: center;
  gap: 5px;
}

.pagination a {
  text-decoration: none;
  color: #42b983;
  padding: 8px 12px;
  border: 1.5px solid #ddd;
  border-radius: 4px;
  transition: background-color 0.3s, color 0.3s;
}

.pagination a.active {
  background-color: #42b983;
  color: #fff;
  font-weight: bold;
}

.pagination a.disabled {
  color: #ccc;
  pointer-events: none;
}

.pagination a:hover:not(.active):not(.disabled) {
  background-color: #f1f1f1;
}
</style>


