<template>
  <div style="margin-top: 15px">
    <el-form ref="transferCoForm" :model="form" :rules="confirmRules" label-width="120px" :disabled=formdisabled>
      <el-form-item label="品名" prop="name">
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
  import {getTransferCoDetail, saveTransferCo, updateTransferCo} from '../../api/api'

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
          remark: '',
          isValidate: 1
        },
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
        this.$refs.transferCoForm.validate((valid) => {
          if (valid) {
            var json = JSON.stringify(this.form);
            if (this.type == 1) {
              saveTransferCo(json).then((res) => {
                if (res.status == 200) {
                  this.$message.success("保存成功");
                  this.closeRefresh();
                } else {
                  this.$message.error(res.msg);
                }
              })
            } else if (this.type == 2) {
              var json = JSON.stringify(this.form);
              updateTransferCo(json).then((res) => {
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
      searchTransferCo() {
        if (this.id != null && this.id != '') {
          getTransferCoDetail(this.id).then((res) => {
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
        this.searchTransferCo();
      if (this.type == 0)
        this.formdisabled = true
    }
  }
</script>

<style>
</style>
