<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/index' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>客户管理</el-breadcrumb-item>
    </el-breadcrumb>
    <div style="margin-top: 15px">
      <el-form ref="querys" :model="querys" label-width="100px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="客户名称：">
              <el-input v-model="querys.name" style="width:200px;" clearable></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row colspan="24">
          <el-button type="primary" size="small" @click="resetAndSearch">查询</el-button>
          <el-button type="primary" size="small" @click="createClient">新增</el-button>
          <el-button type="primary" size="small" @click="updateClient" :disabled=this.visibles.choosed>修改</el-button>
          <el-button type="primary" size="small" @click="getDetail" :disabled=this.visibles.choosed>查看详情</el-button>
          <!--<el-button type="primary" size="small" @click="deleteClient" :disabled=this.visibles.choosed>删除</el-button>-->
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
        <el-table-column prop="name" label="客户名称"></el-table-column>
        <el-table-column prop="phone" label="电话"></el-table-column>
        <el-table-column prop="contact" label="联系人"></el-table-column>
        <el-table-column prop="cellphone" label="联系人手机"></el-table-column>
        <el-table-column prop="addr" label="地址"></el-table-column>
        <el-table-column prop="salesmanName" label="业务员名称"></el-table-column>
        <el-table-column prop="isValidate" label="是否有效" :formatter="enumsFormatter"></el-table-column>
        <el-table-column prop="remark" label="备注"></el-table-column>
        <el-table-column prop="createDate" label="创建时间">
          <template slot-scope="scope">
            <span>{{scope.row.createDate | formatDate}}</span>
          </template>
        </el-table-column>
        <el-table-column prop="modifyDate" label="修改时间">
          <template slot-scope="scope">
            <span>{{scope.row.modifyDate | formatDate}}</span>
          </template>
        </el-table-column>
      </el-table>

      <el-pagination
        :page-size="10"
        :current-page.sync="pageNum"
        layout="total, prev, pager, next"
        @current-change=""
        :total="total">
      </el-pagination>

      <el-dialog title="客户信息" :visible.sync="dialogVisible" v-if='dialogVisible' width="40%">
        <client_detail :id="this.currentRowId" :type="this.type" @close-dialog="closeDialog"></client_detail>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  import base from '@/components/base.vue'
  import {getClientList, deleteClient} from '@/api/api'
  import Client_detail from "./client_detail";

  export default {
    components: {Client_detail},
    extends: base,
    data() {
      return {
        loading: false,
        tableData: [],
        currentRow: {},
        currentRowId: '',
        dialogVisible: false,
        type: '',
        querys: {
          name: ''
        },
        visibles: {
          choosed: true,
        },
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
        this.searchClient()
      },
      searchClient() {
        this.loading = true;
        var obj = {
          pageInfo: {
            pageNum: this.pageNum,
            pageSize: 10
          },
          param: this.querys
        }
        var json = JSON.stringify(obj);
        getClientList(json).then((res) => {
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
      createClient() {
        this.type = 1
        this.dialogVisible = true
      },
      updateClient() {
        this.type = 2
        this.dialogVisible = true
      },
      getDetail() {
        this.type = 0
        this.dialogVisible = true
      },
      closeDialog(refresh) {
        this.dialogVisible = false
        if (refresh)
          this.searchClient()
      },
      deleteClient() {
        this.$confirm('确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleteClient(this.currentRowId).then((res) => {
            if (res.status == 200) {
              this.$message.success("删除成功");
              this.searchClient()
            }
          })
        })
      },
      enumsFormatter(row, column, cellValue) {
        if (cellValue === 1) {
          return "是"
        } else {
          return "否"
        }
      }
    },
    mounted() {
      this.searchClient();
    }
  }
</script>

<style>
</style>
