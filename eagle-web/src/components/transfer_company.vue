<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/index' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>转运公司管理</el-breadcrumb-item>
    </el-breadcrumb>
    <div style="margin-top: 15px">
      <el-form ref="querys" :model="querys" label-width="120px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="转运公司名称：">
              <el-input v-model="querys.name" style="width:200px;"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row colspan="24">
          <el-button type="primary" size="small" @click="searchOrder">查询</el-button>
          <el-button type="primary" size="small" @click="createOrder">新增</el-button>
          <el-button type="primary" size="small" @click="updateOrder">修改</el-button>
        </el-row>
      </el-form>

      <el-table
        :data="tableData"
        stripe
        v-loading="loading"
        border
        style="width: 100%;margin-top: 15px"
        @current-change="handleCurrentChange">
        <el-table-column prop="name" label="转运名称"></el-table-column>
        <el-table-column prop="phone" label="电话"></el-table-column>
        <el-table-column prop="contact" label="联系人"></el-table-column>
        <el-table-column prop="cellphone" label="联系人手机"></el-table-column>
        <el-table-column prop="addr" label="地址"></el-table-column>
        <el-table-column prop="remark" label="备注"></el-table-column>
      </el-table>

      <el-pagination
        :page-size="10"
        :current-page.sync="pageNum"
        layout="total, prev, pager, next"
        @current-change=""
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>
  import base from './base.vue'
  import {getTransferCompanyList} from '../api/api'

  export default {
    extends: base,
    data() {
      return {
        loading: false,
        tableData: [],
        currentRow: {},
        querys: {
          name: ''
        },
        pageNum: 0,
        total: 0,
      }
    },
    methods: {
      handleCurrentChange(val) {
        this.currentRow = val;
      },
      searchOrder() {
        this.loading = true;
        var obj = {
          pageInfo: {
            pageNum: this.pageNum,
            pageSize: 10
          },
          param: this.querys
        }
        var json = JSON.stringify(obj);
        getTransferCompanyList(json).then((res) => {
          this.loading = false;
          if (res.status == 200) {
            this.tableData = res.data.list;
            this.total = res.data.total;
            this.pageNum = res.data.pageNum;
          } else {
            this.$message.error(res.msg);
          }
        })
      },
      createOrder() {

      },
      updateOrder() {

      }
    },
    mounted() {
      this.searchOrder();
    }
  }
</script>

<style>
</style>
