<template>
  <div style="margin-top: 15px">
    <el-form ref="destinationForm" :model="form" :rules="confirmRules" label-width="120px" :disabled=formdisabled>
      <el-form-item label="目的地" prop="destination">
        <el-input v-model="form.destination" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="收件人" prop="recipient">
        <el-input v-model="form.recipient" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="收件人手机" prop="phone">
        <el-input v-model="form.phone" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="地址" prop="addr">
        <el-input v-model="form.addr" style="width:70%;" clearable></el-input>
      </el-form-item>
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
  import {getDestinationDetail, saveDestination, updateDestination} from '../../api/api'

  export default {
    props: ['id', 'type'],
    data() {
      return {
        form: {
          destination: '',
          recipient: '',
          phone: '',
          addr: ''
        },
        salesmanList: null,
        formdisabled: false,
        saveDisabled: false,
        confirmRules: {
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
        this.$refs.destinationForm.validate((valid) => {
          if (valid) {
            var json = JSON.stringify(this.form);
            if (this.type == 1) {
              saveDestination(json).then((res) => {
                if (res.status == 200) {
                  this.$message.success("保存成功");
                  this.closeRefresh();
                } else {
                  this.$message.error(res.msg);
                }
              })
            } else if (this.type == 2) {
              var json = JSON.stringify(this.form);
              updateDestination(this.id, json).then((res) => {
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
      searchDestination() {
        if (this.id != null && this.id != '') {
          getDestinationDetail(this.id).then((res) => {
            if (res.status == 200) {
              this.form = res.data;
            } else {
              this.$message.error(res.msg);
            }
          })
        }
      },
    },
    mounted() {
      if (this.type != 1)
        this.searchDestination();
      if (this.type == 0)
        if (this.type == 0) {
          this.formdisabled = true
          this.saveDisabled = true
        }
    }
  }
</script>

<style>
</style>
