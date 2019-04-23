<template>
  <div style="margin-top: 15px">
    <el-form ref="form" :model="form" :rules="confirmRules" label-width="120px" :disabled=formdisabled>
      <el-form-item label="客户名称" prop="name">
        <el-input v-model="form.name" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="电话">
        <el-input v-model="form.phone" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="联系人">
        <el-input v-model="form.contact" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="联系人手机">
        <el-input v-model="form.cellphone" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="公司地址">
        <el-input v-model="form.addr" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="备注">
        <el-input v-model="form.remark" style="width:70%;" clearable></el-input>
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
  import {getClientDetail, saveClient, updateClient} from '../api/api'

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
          remark: ''
        },
        formdisabled: false,
        confirmRules: {
          name: [
            {required: true, message: '请输入名称', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      onSubmit() {
        var json = JSON.stringify(this.form);
        if(this.type == 1) {
          saveClient(json).then((res) => {
            if (res.status == 200) {
              this.$message.success("保存成功");
              this.close();
            } else {
              this.$message.error(res.msg);
            }
          })
        } else if(this.type == 2){
          var json = JSON.stringify(this.form);
          updateClient(json).then((res) => {
            if (res.status == 200) {
              this.$message.success("保存成功");
              this.close();
            } else {
              this.$message.error(res.msg);
            }
          })
        }
      },
      close() {
        if (this.type == 0) {
          this.$emit('close-dialog', false)
        } else {
          this.$emit('close-dialog', true)
        }
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
    },
    mounted() {
      if (this.type != 1)
        this.searchClient();
      if (this.type == 0)
        this.formdisabled = true
    }
  }
</script>

<style>
</style>
