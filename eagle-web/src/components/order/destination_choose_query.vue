<template>
  <div>
    <div style="margin-top: 15px">
      <el-form ref="querys" :model="querys" label-width="100px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="目的地：">
              <el-input v-model="querys.destination" style="width:200px;" clearable></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row colspan="24">
          <el-button type="primary" size="small" @click="resetAndSearch">查询</el-button>
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
        <el-table-column prop="destination" label="目的地" width="200"></el-table-column>
        <el-table-column prop="recipient" label="收件人" width="100"></el-table-column>
        <el-table-column prop="phone" label="收件人手机" width="150"></el-table-column>
        <el-table-column prop="addr" label="地址"></el-table-column>
      </el-table>

      <el-pagination
        :page-size="5"
        :current-page.sync="pageNum"
        layout="total, prev, pager, next"
        @current-change="search"
        :total="total">
      </el-pagination>

    </div>
  </div>
</template>

<script>
  import base from '@/components/base.vue'
  import {queryDestinationList, deleteDestination} from '@/api/api'

  export default {
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
          destination: ''
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
        this.search()
      },
      search() {
        this.loading = true;
        var obj = {
          pageInfo: {
            pageNum: this.pageNum,
            pageSize: 5
          },
          param: this.querys
        }
        var json = JSON.stringify(obj);
        queryDestinationList(json).then((res) => {
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
      enumsFormatter(row, column, cellValue) {
        if (cellValue === 1) {
          return "是"
        } else {
          return "否"
        }
      }
    },
    mounted() {
      this.search();
    }
  }
</script>

<style>
</style>
