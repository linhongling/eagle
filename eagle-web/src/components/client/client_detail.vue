<template>
  <div style="margin-top: 15px">
    <el-form ref="clientForm" :model="form" :rules="confirmRules" label-width="120px" :disabled=formdisabled>
      <el-form-item label="客户名称" prop="name">
        <el-input v-model="form.name" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="电话" prop="phone">
        <el-input v-model="form.phone" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="联系人">
        <el-input v-model="form.contact" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="联系人手机" prop="cellphone">
        <el-input v-model="form.cellphone" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="公司地址">
        <el-input v-model="form.addr" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="业务员">
        <el-select v-model="form.salesmanId" clearable
                   filterable placeholder="请选择">
          <el-option v-for="item in salesmanList"
                     :key="item.id"
                     :value="item.id"
                     :label="item.name">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="是否有效">
        <el-switch
          v-model="form.isValidate"
          :active-value=1
          :inactive-value=0
          active-text="是"
          inactive-text="否">
        </el-switch>
      </el-form-item>

      <el-form-item label="备注">
        <el-input type="textarea" v-model="form.remark" style="width:70%;" clearable></el-input>
      </el-form-item>
    </el-form>

    <el-row>
      <el-col align="center">
        <el-button type="primary" @click="onSubmit">保存</el-button>
        <el-button @click="close">取消</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import {getClientDetail, saveClient, updateClient, getSalesmanInfoList} from '../../api/api'

  export default {
    props: ['id', 'type'],
    data() {
      return {
        form: {
          name: '',
          phone: '',
          contact: '',
          cellphone: '',
          addr: '',
          salesmanId: '',
          remark: '',
          isValidate: 1
        },
        salesmanList: null,
        formdisabled: false,
        confirmRules: {
          name: [
            {required: true, message: '请输入名称', trigger: 'blur'}
          ],
          cellphone: [
            {
              pattern: /^1[34578]\d{9}$/,
              message: '请输入正确的手机号码',
              trigger: 'blur'
            }
         ],
          phone: [
            {
              pattern: /^[0-9]*[1-9][0-9]*$/,
              message: '请输入正确的号码',
              trigger: 'blur'
            }
          ]
        }
      }
    },
    methods: {
      onSubmit() {
        this.$refs.clientForm.validate((valid) => {
          if (valid) {
            var json = JSON.stringify(this.form);
            if (this.type == 1) {
              saveClient(json).then((res) => {
                if (res.status == 200) {
                  this.$message.success("保存成功");
                  this.closeRefresh();
                } else {
                  this.$message.error(res.msg);
                }
              })
            } else if (this.type == 2) {
              var json = JSON.stringify(this.form);
              updateClient(json).then((res) => {
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
      searchClient() {
        if (this.id != null && this.id != '') {
          getClientDetail(this.id).then((res) => {
            if (res.status == 200) {
              this.form = res.data;
            } else {
              this.$message.error(res.msg);
            }
          })
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
      if (this.type != 1)
        this.searchClient();
      if (this.type == 0)
        this.formdisabled = true
      this.getSalesmanInfoList()
    }
  }
</script>

<style>
</style>
