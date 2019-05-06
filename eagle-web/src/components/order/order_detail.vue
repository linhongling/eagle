<template>
  <div style="margin-top: 15px">
    <el-form ref="orderForm" :model="form" :rules="confirmRules" label-width="120px" :disabled=formdisabled>
      <el-row :span="24">
        <el-col :span="12">
          <el-form-item label="日期" prop="orderDate">
            <el-date-picker
              v-model="form.orderDate"
              type="date"
              placeholder="选择日期">
            </el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="客户">
            <el-select v-model="form.clientId" clearable
                       filterable placeholder="请选择">
              <el-option v-for="item in clientList"
                         :key="item.id"
                         :value="item.id"
                         :label="item.name">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row :span="24">
        <el-col :span="12">
          <el-form-item label="运单号" prop="no">
            <el-input v-model="form.no" style="width: 220px" clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="品名">
            <el-select v-model="form.goodsId" clearable
                       filterable placeholder="请选择">
              <el-option v-for="item in goodsList"
                         :key="item.id"
                         :value="item.id"
                         :label="item.name">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row :span="24">
        <el-col :span="12">
          <el-form-item label="目的地">
            <el-input type="textarea" autosize v-model="form.addr" style="width: 220px" clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="备注">
            <el-input type="textarea" autosize v-model="form.remark" style="width: 220px" clearable></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row :span="24">
        <el-col :span="12">
          <el-form-item label="件数">
            <el-input v-model="form.count" style="width: 220px" clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="重量">
            <el-input v-model="form.weight" style="width: 220px" clearable></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row :span="24">
        <el-col :span="12">
          <el-form-item label="体积">
            <el-input v-model="form.volume" style="width: 220px" clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="月结">
            <el-input v-model="form.freightMonthly" style="width: 220px" clearable></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row :span="24">
        <el-col :span="12">
          <el-form-item label="现付">
            <el-input v-model="form.freightNow" style="width: 220px" clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="到付">
            <el-input v-model="form.freightArrive" style="width: 220px" clearable></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row :span="24">
        <el-col :span="12">
          <el-form-item label="运费">
            <el-input v-model="form.costFreight" style="width: 220px" clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="直送">
            <el-input v-model="form.costDirect" style="width: 220px" clearable></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row :span="24">
        <el-col :span="12">
          <el-form-item label="保险">
            <el-input v-model="form.costInsurance" style="width: 220px" clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="转运公司">
            <el-select v-model="form.transferCompanyId" clearable
                       filterable placeholder="请选择">
              <el-option v-for="item in transferCoList"
                         :key="item.id"
                         :value="item.id"
                         :label="item.name">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row :span="24">
        <el-col :span="12">
          <el-form-item label="转运单号">
            <el-input v-model="form.transferNo" style="width: 220px" clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="回单">
            <el-date-picker
              v-model="form.receipt"
              type="date"
              placeholder="选择日期">
            </el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>

    </el-form>

    <el-row>
      <el-col align="center">
        <el-button type="primary" @click="onSubmit" :disabled=saveDisabled>保存</el-button>
        <el-button @click="close">取消</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import {
    getClientInfoList,
    getTransferCoInfoList,
    getGoodsInfoList,
    getOrderDetail,
    saveOrder,
    updateOrder
  } from '../../api/api'

  export default {
    props: ['id', 'type'],
    data() {
      return {
        form: {
          orderDate: '',
          no: '',
          clientId: '',
          addr: '',
          goodsId: '',
          count: '',
          weight: '',
          volume: '',
          freightMonthly: '',
          freightNow: '',
          freightArrive: '',
          costFreight: '',
          costDirect: '',
          costInsurance: '',
          transferCompanyId: '',
          transferNo: '',
          receipt: '',
          remark: ''
        },
        formdisabled: false,
        saveDisabled: false,
        clientList: null,
        transferCoList: null,
        goodsList: null,
        confirmRules: {
          no: [
            {required: true, message: '请输入运单号', trigger: 'blur'}
          ],
          orderDate: [
            {required: true, message: '请输入日期', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      onSubmit() {
        this.$refs.orderForm.validate((valid) => {
          if (valid) {
            var json = JSON.stringify(this.form);
            if (this.type == 1) {
              saveOrder(json).then((res) => {
                if (res.status == 200) {
                  this.$message.success("保存成功");
                  this.closeRefresh();
                } else {
                  this.$message.error(res.msg);
                }
              })
            } else if (this.type == 2) {
              var json = JSON.stringify(this.form);
              updateOrder(json).then((res) => {
                if (res.status == 200) {
                  this.$message.success("保存成功");
                  this.closeRefresh();
                } else {
                  this.$message.error(res.msg);
                }
              })
            }
          }
        })
      },
      close() {
        this.$emit('close-dialog', false)
      },
      closeRefresh() {
        this.$emit('close-dialog', true)
      },
      getOrderDetail() {
        if (this.id != null && this.id != '') {
          getOrderDetail(this.id).then((res) => {
            if (res.status == 200) {
              this.form = res.data;
            } else {
              this.$message.error(res.msg);
            }
          })
        }
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
      getGoodsInfoList() {
        getGoodsInfoList().then((res) => {
          if (res.status == 200) {
            this.goodsList = res.data
          }
        })
      }
    },
    mounted() {
      if (this.type != 1) {
        this.getOrderDetail();
      }
      if (this.type == 0) {
        this.formdisabled = true
        this.saveDisabled = true
      }
      this.getClientInfoList()
      this.getTransferCoInfoList()
      this.getGoodsInfoList()
    }
  }
</script>

<style>
</style>
