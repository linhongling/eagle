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
              <el-input v-model="querys.no" style="width:220px;" clearable></el-input>
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

        <el-row>
          <el-col :span="8">
            <el-form-item label="状态：">
              <el-select v-model="querys.status" clearable
                         filterable placeholder="请选择">
                <el-option v-for="item in statusList"
                           :key="item.id"
                           :value="item.id"
                           :label="item.name">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row colspan="24">
          <el-button type="primary" size="small" @click="resetAndSearch">查询</el-button>
          <el-button type="primary" size="small" @click="createTask">新增</el-button>
          <el-button type="primary" size="small" @click="getDetail" :disabled=this.visibles.choosed>查看详情</el-button>
          <el-button type="primary" size="small" @click="updateTask" :disabled=this.visibles.choosed>修改</el-button>
          <el-button type="primary" size="small" @click="updateTaskStatus" :disabled=this.visibles.choosed>已解决
          </el-button>
          <el-button type="primary" size="small" @click="deleteTask" :disabled=this.visibles.choosed>删除</el-button>

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
        <el-table-column label="运单号" width="180">
          <template slot-scope="scope">
            <span style="text-decoration:underline;cursor:pointer" @click="getOrderDetail(scope.row.orderNo)">{{scope.row.orderNo}}</span>
          </template>
        </el-table-column>
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
        <task_detail :id="this.currentRowId" :type="this.type" @close-dialog="closeTaskDialog"></task_detail>
      </el-dialog>

      <el-dialog title="订单信息" :visible.sync="orderDialogVisible" v-if='orderDialogVisible' width="1000px">
        <order_detail :id="this.currentRowOrderId" :type="this.type" @close-dialog="closeDialog"></order_detail>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  import base from '@/components/base.vue'
  import {getTaskList, updateTaskStatus, getIdByOrderNo, deleteTask} from '@/api/api'
  import Task_detail from "./task_detail";
  import Order_detail from "../order/order_detail";

  export default {
    components: {Order_detail, Task_detail},
    extends: base,
    data() {
      return {
        loading: false,
        tableData: [],
        exportData: [],
        currentRow: {},
        currentRowId: '',
        currentRowOrderId: '',
        querys: {
          no: '',
          startCreateDate: '',
          endCreateDate: '',
          status: ''
        },
        queryCreateDate: '',
        statusList: [{id: '', name: '全部'}, {id: 0, name: '未解决'}, {id: 1, name: '已解决'}],
        visibles: {
          choosed: true,
        },
        dialogVisible: false,
        orderDialogVisible: false,
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
      resetAndSearch() {
        this.pageNum = 1
        this.searchTask()
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
      getDetail() {
        this.type = 0
        this.dialogVisible = true
      },
      closeDialog(refresh) {
        this.orderDialogVisible = false
      },
      closeTaskDialog(refresh) {
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
      },
      updateTaskStatus() {
        this.$confirm('确认已解决问题?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          updateTaskStatus(this.currentRowId).then((res) => {
            if (res.status == 200) {
              this.$message.success("修改成功");
              this.searchTask()
            }
          })
        })
      },
      getOrderDetail(orderNo) {
        getIdByOrderNo(orderNo).then((res) => {
          if (res.status == 200) {
            this.currentRowOrderId = res.data
            this.type = 0
            this.orderDialogVisible = true
          }
        })
      },
      deleteTask() {
        this.$confirm('确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleteTask(this.currentRowId).then((res) => {
            if (res.status == 200) {
              this.$message.success("删除成功");
              this.searchTask()
            }
          })
        })

      }
    },
    mounted() {
      this.searchTask();
      this.currentRowId = this.$route.query.taskId
    }
  }
</script>

<style>
  .el-table thead.is-group th {
    background: #FFFFFF;
  }
</style>
