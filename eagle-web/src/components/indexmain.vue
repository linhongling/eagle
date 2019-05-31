<template>
  <div>
    <el-row>
      <el-col>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>待处理问题单</span>
          </div>
          <div v-for="o in taskList" :key="o.id" class="text item">
            <span style="cursor:pointer" @click="getTaskDetail(o.id)">
              {{ o.taskDesc }}
            </span>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import {getUnFinishTask} from '@/api/api'

  export default {
    data() {
      return {
        taskList: null
      }
    },
    methods: {
      getUnFinishTask() {
        getUnFinishTask(this.id).then((res) => {
          if (res.status == 200) {
            this.taskList = res.data;
          } else {
            this.$message.error(res.msg);
          }
        })
      },
      getTaskDetail(id) {
        let that = this;
        that.$router.push({path:"/index/taskQuery/", query:{taskId:id}});
      }
    },
    mounted() {
      this.getUnFinishTask()
    }
  }
</script>

<style>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  /*.box-card {
    width: 480px;
  }*/
</style>
