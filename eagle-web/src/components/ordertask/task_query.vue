<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/index' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>问题单管理</el-breadcrumb-item>
    </el-breadcrumb>
    <div style="margin-top: 15px">
      <el-form ref="querys" :model="querys" label-width="100px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="订单号：">
              <el-input v-model="querys.no" style="width:200px;" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="创建日期：">
              <el-date-picker end-placeholder="结束日期"
                              format="yyyy-MM-dd"
                              range-separator="至"
                              start-placeholder="开始日期"
                              type="datetimerange"
                              v-model="queryCreateDate"/>
            </el-form-item>
          </el-col>
        </el-row>


        <el-row colspan="24">
          <el-button type="primary" size="small" @click="searchTask">查询</el-button>
          <el-button type="primary" size="small" @click="createTask">新增</el-button>
          <el-button type="primary" size="small" @click="updateTask" :disabled=this.visibles.choosed>修改</el-button>
        </el-row>
      </el-form>

      <el-table
        :data="tableData"
        stripe
        v-loading="loading"
        border
        style="width: 100%;margin-top: 15px"
        @current-change="handleCurrentChange">
        <el-table-column label="选择" width="50" style="text-align:center">
          <template slot-scope="scope">
            <div style="text-align:center">
              <el-radio v-model="currentRowId" :label="scope.row.id"><i></i></el-radio>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="日期" width="180">
          <template slot-scope="scope">
            <span>{{scope.row.createDate | formatDateSimple}}</span>
          </template>
        </el-table-column>
        <el-table-column prop="orderNo" label="运单号" width="180"></el-table-column>
        <el-table-column prop="taskDesc" label="问题单描述"></el-table-column>
        <el-table-column prop="status" label="状态" :formatter="enumsFormatter" width="120"></el-table-column>
      </el-table>

      <el-pagination
        :page-size="10"
        :current-page.sync="pageNum"
        layout="total, prev, pager, next"
        @current-change=""
        :total="total">
      </el-pagination>

      <el-dialog title="问题单" :visible.sync="dialogVisible" v-if='dialogVisible' width="1000px">
        <task_detail :id="this.currentRowId" :type="this.type" @close-dialog="closeDialog"></task_detail>
      </el-dialog>

    </div>
  </div>
</template>

<script>
  import base from '@/components/base.vue'
  import {getTaskList} from '@/api/api'
  import Task_detail from "./task_detail";

  export default {
    components: {Task_detail},
    extends: base,
    data() {
      return {
        loading: false,
        tableData: [],
        exportData: [],
        currentRow: {},
        currentRowId: '',
        querys: {
          no: '',
          startCreateDate: '',
          endCreateDate: ''
        },
        queryCreateDate: '',
        visibles: {
          choosed: true,
        },
        dialogVisible: false,
        pageNum: 0,
        total: 0,
      }
    },
    methods: {
      handleCurrentChange(val) {
        if (!val) {
          this.currentRow = ''
          this.visibles.choosed = true
          return
        }
        this.currentRow = val
        this.currentRowId = val.id
        this.visibles.choosed = false
      },
      searchTask() {
        this.loading = true;
        this.setQueryDateTime()
        var obj = {
          pageInfo: {
            pageNum: this.pageNum,
            pageSize: 10
          },
          param: this.querys
        }
        var json = JSON.stringify(obj);
        getTaskList(json).then((res) => {
          this.loading = false;
          if (res.status == 200) {
            this.tableData = res.data.list;
            this.total = res.data.total;
            this.pageNum = res.data.pageNum;
          } else {
            this.$message.error(res.msg);
          }
        })
        this.currentRow = ''
        this.currentRowId = ''
      },
      createTask() {
        this.type = 1
        this.dialogVisible = true
      },
      updateTask() {
        this.type = 2
        this.dialogVisible = true
      },
      closeDialog(refresh) {
        this.dialogVisible = false
        if (refresh)
          this.searchTask()
      },
      setQueryDateTime() {
        if (this.queryCreateDate) {
          this.querys.startCreateDate = this.queryCreateDate[0]
          this.querys.endCreateDate = this.queryCreateDate[1]
        } else {
          this.querys.startCreateDate = null
          this.querys.endCreateDate = null
        }

      },
      enumsFormatter(row, column, cellValue) {
        if (cellValue === 1) {
          return "已解决"
        } else {
          return "未解决"
        }
      }
    },
    mounted() {
      this.searchTask();
    }
  }
</script>

<style>
  .el-table thead.is-group th {
    background: #FFFFFF;
  }
</style>
