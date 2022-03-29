<template>
  <div class="element-container">
      <el-row :gutter="20">
        <el-col :span="6">床型：<el-input v-model="input" placeholder="请输入内容"></el-input></el-col>
        <el-col :span="6">床型：<el-input v-model="input" placeholder="请输入内容"></el-input></el-col>
        <el-col :span="6">床型：<el-input v-model="input" placeholder="请输入内容"></el-input></el-col>
        <el-col :span="6">床型：<el-input v-model="input" placeholder="请输入内容"></el-input></el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="6">床型：<el-input v-model="input" placeholder="请输入内容"></el-input></el-col>
        <el-col :span="6">床型：<el-input v-model="input" placeholder="请输入内容"></el-input></el-col>
        <el-col :span="6">床型：<el-input v-model="input" placeholder="请输入内容"></el-input></el-col>
        <el-col :span="6">床型：<el-input v-model="input" placeholder="请输入内容"></el-input></el-col>
      </el-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  data(){
    return {
      input:'aaa'
    }
  }
}
</script>

<style lang="scss" scoped>

</style>
