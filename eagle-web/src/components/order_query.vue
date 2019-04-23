<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/index' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>订单管理</el-breadcrumb-item>
    </el-breadcrumb>
    <div style="margin-top: 15px">
      <el-form ref="querys" :model="querys" label-width="100px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="运单号：">
              <el-input v-model="querys.no" style="width:200px;" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="客户名称：">
              <el-select v-model="querys.clientId" clearable
                         filterable placeholder="请选择">
                <el-option v-for="item in clientList"
                           :key="item.id"
                           :value="item.id"
                           :label="item.name">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="日期：">
              <el-date-picker
                v-model="querys.orderDate"
                type="date"
                format="yyyy-MM-dd"
                value-format="timestamp">
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row colspan="24">
          <el-col :span="8">
            <el-form-item label="转运单号：">
              <el-input v-model="querys.transferNo" style="width:200px;" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="转运公司：">
              <el-select v-model="querys.transferCompanyId" clearable
                         filterable placeholder="请选择">
                <el-option v-for="item in clientList"
                           :key="item.id"
                           :value="item.id"
                           :label="item.name">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="回单：">
              <el-date-picker
                v-model="querys.receipt"
                type="date"
                format="yyyy-MM-dd"
                value-format="timestamp">
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row colspan="24">
          <el-button type="primary" size="small" @click="searchOrder">查询</el-button>
          <el-button type="primary" size="small" @click="createOrder">新增</el-button>
          <el-button type="primary" size="small" @click="updateOrder" :disabled=this.visibles.choosed>修改</el-button>
          <el-button type="primary" size="small" @click="searchDetail" :disabled=this.visibles.choosed>查看详情</el-button>
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
        <el-table-column label="日期" width="120">
          <template slot-scope="scope">
            <span>{{scope.row.orderDate | formatDateSimple}}</span>
          </template>
        </el-table-column>
        <el-table-column prop="no" label="运单号" width="120"></el-table-column>
        <el-table-column prop="clientId" label="客户" width="120"></el-table-column>
        <el-table-column prop="addr" label="目的地" width="120"></el-table-column>
        <el-table-column prop="goodsType" label="品名" width="120"></el-table-column>
        <el-table-column prop="count" label="件数" width="120"></el-table-column>
        <el-table-column prop="weight" label="重量" width="120"></el-table-column>
        <el-table-column prop="volume" label="体积" width="120"></el-table-column>
        <el-table-column label="收入">
          <el-table-column prop="freightMonthly" label="月结" width="120"></el-table-column>
          <el-table-column prop="freightNow" label="现付" width="120"></el-table-column>
          <el-table-column prop="freightArrive" label="到付" width="120"></el-table-column>
        </el-table-column>
        <el-table-column label="成本">
          <el-table-column prop="costFreight" label="运费" width="120"></el-table-column>
          <el-table-column prop="costDirect" label="直送" width="120"></el-table-column>
          <el-table-column prop="costInsurance" label="保险" width="120"></el-table-column>
        </el-table-column>
        <el-table-column prop="transferCompanyId" label="转运公司" width="120"></el-table-column>
        <el-table-column prop="transferNo" label="转运单号"></el-table-column>
        <el-table-column prop="receipt" label="回单" width="120">
          <template slot-scope="scope">
            <span>{{scope.row.receipt | formatDateSimple}}</span>
          </template>
        </el-table-column>
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
  import {getOrderList} from '../api/api'

  export default {
    extends: base,
    data() {
      return {
        loading: false,
        tableData: [],
        currentRow: {},
        currentRowId: '',
        querys: {
          no: '',
          clientId: '',
          orderDate: '',
          transferNo: '',
          transferCompanyId: '',
          receipt: ''
        },
        visibles: {
          choosed: true,
        },
        clientList: null,
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
        getOrderList(json).then((res) => {
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

      },
      searchDetail() {

      }
    },
    mounted() {
      this.searchOrder();
    }
  }
</script>

<style>
  .el-table thead.is-group th {
     background: #FFFFFF;
  }
</style>
