<template>
  <div class="app-container">

    <el-form size="small" :inline="true">
      <el-form-item label="床型ID："> 
        <el-input 
         placeholder="输入床型ID"
        />
      </el-form-item>
      <el-form-item label="床型名字："> 
        <el-input 
         placeholder="输入床型名字"
        />
      </el-form-item>
    </el-form>

    <el-table
      v-loading="listLoading"
      :data="users"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="id" width="95">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
       <el-table-column label="name">
        <template slot-scope="scope">
          {{ scope.row.name }} 
        </template>
      </el-table-column>
       <el-table-column label="age">
        <template slot-scope="scope">
          {{ scope.row.age }} 
        </template>
      </el-table-column>
      <el-table-column label="Email">
        <template slot-scope="scope">
          {{ scope.row.email }}
        </template>
      </el-table-column>
      
    </el-table>
  </div>
</template>

<script>
import {getUserList} from '@/api/user'

export default {
  data(){
    return{
      listLoading:false,
      users:[],
    }
  },
 created() {
   this.getUsers()
 },

  methods:{
    getUsers(){
     getUserList().then((respose)=>{
      this.users = respose.data
     })
    }

  },
}
</script>
