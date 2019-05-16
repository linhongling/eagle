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
              <el-select v-model="querys.clientIds" clearable
                         multiple filterable placeholder="请选择">
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
              <el-date-picker end-placeholder="结束日期"
                              format="yyyy-MM-dd"
                              range-separator="至"
                              start-placeholder="开始日期"
                              type="datetimerange"
                              v-model="queryOrderDate"/>
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
              <el-select v-model="querys.transferCompanyIds" clearable
                         multiple filterable placeholder="请选择">
                <el-option v-for="item in transferCoList"
                           :key="item.id"
                           :value="item.id"
                           :label="item.name">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="回单：">
              <el-date-picker end-placeholder="结束日期"
                              format="yyyy-MM-dd"
                              range-separator="至"
                              start-placeholder="开始日期"
                              type="datetimerange"
                              v-model="queryReceiptDate"/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row colspan="24">
          <el-col :span="8">
            <el-form-item label="业务员：">
              <el-select v-model="querys.salesManIds" clearable style="width:200px;"
                         multiple filterable placeholder="请选择">
                <el-option v-for="item in salesmanList"
                           :key="item.id"
                           :value="item.id"
                           :label="item.name">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row colspan="24">
          <el-button type="primary" size="small" @click="searchOrder">查询</el-button>
          <el-button type="primary" size="small" @click="exportOrder" v-loading.fullscreen.lock="fullscreenLoading">导出
          </el-button>
          <el-button type="primary" size="small" @click="createOrder">新增</el-button>
          <el-button type="primary" size="small" @click="updateOrder" :disabled=this.visibles.choosed>修改</el-button>
          <el-button type="primary" size="small" @click="getDetail" :disabled=this.visibles.choosed>查看详情</el-button>
          <el-button type="primary" size="small" @click="deleteOrder" :disabled=this.visibles.choosed>删除</el-button>
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
        <el-table-column prop="clientName" label="客户" width="120"></el-table-column>
        <el-table-column prop="addr" label="目的地" width="120"></el-table-column>
        <el-table-column prop="goodsName" label="品名" width="120"></el-table-column>
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
        <el-table-column prop="transferCompanyName" label="转运公司" width="120"></el-table-column>
        <el-table-column prop="transferNo" label="转运单号"></el-table-column>
        <el-table-column prop="receipt" label="回单" width="120">
          <template slot-scope="scope">
            <span>{{scope.row.receipt | formatDateSimple}}</span>
          </template>
        </el-table-column>
        <el-table-column prop="salesmanName" label="业务员"></el-table-column>
        <el-table-column prop="commission" label="提成" width="120"></el-table-column>
        <el-table-column prop="remark" label="备注"></el-table-column>
      </el-table>

      <el-pagination
        :page-size="10"
        :current-page.sync="pageNum"
        layout="total, prev, pager, next"
        @current-change=""
        :total="total">
      </el-pagination>

      <el-dialog title="订单信息" :visible.sync="dialogVisible" v-if='dialogVisible' width="1000px">
        <order_detail :id="this.currentRowId" :type="this.type" @close-dialog="closeDialog"></order_detail>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  import base from '@/components/base.vue'
  import {getOrderList, getClientInfoList, getTransferCoInfoList, getExportList, deleteOrder, getSalesmanInfoList} from '@/api/api'
  import Order_detail from './order_detail'
  import {parseTime} from '@/util/utils'

  export default {
    components: {Order_detail},
    extends: base,
    data() {
      return {
        loading: false,
        fullscreenLoading: false,
        tableData: [],
        exportData: [],
        currentRow: {},
        currentRowId: '',
        querys: {
          no: '',
          clientIds: [],
          startOrderDate: '',
          endOrderDate: '',
          transferNo: '',
          transferCompanyIds: [],
          startReceipt: '',
          endReceipt: '',
          salesManIds: []
        },
        queryOrderDate: '',
        queryReceiptDate: '',
        visibles: {
          choosed: true,
        },
        dialogVisible: false,
        clientList: null,
        transferCoList: null,
        salesmanList: null,
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
        this.setQueryDateTime()
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
        this.currentRow = ''
        this.currentRowId = ''
      },
      createOrder() {
        this.type = 1
        this.dialogVisible = true
      },
      updateOrder() {
        this.type = 2
        this.dialogVisible = true
      },
      getDetail() {
        this.type = 0
        this.dialogVisible = true
      },
      exportOrder() {
        this.$confirm('确认导出?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.fullscreenLoading = true;
          var json = JSON.stringify(this.querys);
          getExportList(json).then((res) => {
            if (res.status == 200) {
              import('@/vendor/Export2Excel').then(excel => {
                const multiHeader = [['', '', '', '', '', '', '', '', '运费收入', '', '', '出货成本', '', '', '', '', '', '', '', '']]
                const header = ['日期', '运单号', '客户', '目的地', '品名', '件数', '重量', '体积', '月结', '现付', '到付',
                  '运费', '直送', '保险', '转运公司', '转运单号', '回单', '业务员', '提成', '备注']
                const filterVal = ['orderDate', 'no', 'clientName', 'destination', 'goodsName', 'count', 'weight', 'volume',
                  'freightMonthly', 'freightNow', 'freightArrive', 'costFreight', 'costDirect', 'costInsurance',
                  'transferCompanyName', 'transferNo', 'receipt', 'salesmanName', 'commission', 'remark']
                const list = res.data
                const data = this.formatJson(filterVal, list)
                const merges = ['I1:K1', 'L1:N1']
                excel.export_json_to_excel({
                  multiHeader,
                  header,
                  merges,
                  data
                })
              })
            } else {
              this.$message.error(res.msg);
            }
          }).finally(() => {
            this.fullscreenLoading = false
          })
        })
      },
      formatJson(filterVal, jsonData) {
        return jsonData.map(v => filterVal.map(j => {
          if ((j === 'orderDate' || j === 'receipt') && v[j])  {
            return parseTime(v[j], '{y}-{m}-{d}')
          } else {
            return v[j]
          }
        }))
      },
      deleteOrder() {
        this.$confirm('确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleteOrder(this.currentRowId).then((res) => {
            if (res.status == 200) {
              this.$message.success("删除成功");
              this.searchOrder()
            }
          })
        })
      },
      getClientInfoList() {
        getClientInfoList().then((res) => {
          if (res.status == 200) {
            this.clientList = res.data
          }
        })
      },
      getTransferCoInfoList() {
        getTransferCoInfoList().then((res) => {
          if (res.status == 200) {
            this.transferCoList = res.data
          }
        })
      },
      closeDialog(refresh) {
        this.dialogVisible = false
        if (refresh)
          this.searchOrder()
      },
      setQueryDateTime() {
        if (this.queryOrderDate) {
          this.querys.startOrderDate = this.queryOrderDate[0]
          this.querys.endOrderDate = this.queryOrderDate[1]
        } else {
          this.querys.startOrderDate = null
          this.querys.endOrderDate = null
        }

        if (this.queryReceiptDate) {
          this.querys.startReceipt = this.queryReceiptDate[0]
          this.querys.endReceipt = this.queryReceiptDate[1]
        } else {
          this.querys.startReceipt = null
          this.querys.endReceipt = null
        }
      },
      getSalesmanInfoList() {
        getSalesmanInfoList().then((res) => {
          if (res.status == 200) {
            this.salesmanList = res.data
          }
        })
      }
    },
    mounted() {
      this.searchOrder();
      this.getClientInfoList();
      this.getTransferCoInfoList();
      this.getSalesmanInfoList();
    }
  }
</script>

<style>
  .el-table thead.is-group th {
    background: #FFFFFF;
  }
</style>
