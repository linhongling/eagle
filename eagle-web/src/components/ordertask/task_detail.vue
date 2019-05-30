<template>
  <div style="margin-top: 15px">
    <el-form ref="taskForm" :model="form" :rules="confirmRules" label-width="120px" :disabled=formdisabled>
      <el-form-item label="问题描述" prop="taskDesc">
        <el-input type="textarea" v-model="form.taskDesc" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="订单号" prop="orderNo">
        <el-input v-model="form.orderNo" style="width:70%;" clearable></el-input>
      </el-form-item>

      <el-form-item label="状态">
        <el-switch
          v-model="form.status"
          :active-value=1
          :inactive-value=0
          active-text="已解决"
          inactive-text="未解决">
        </el-switch>
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
  import {getTaskDetail, saveTask, updateTask} from '../../api/api'

  export default {
    props: ['id', 'type'],
    data() {
      return {
        form: {
          taskDesc: '',
          orderNo: '',
          status: 0
        },
        salesmanList: null,
        formdisabled: false,
        saveDisabled: false,
        confirmRules: {
          taskDesc: [
            {required: true, message: '请输入问题描述', trigger: 'blur'},
            {max: 255, message: '问题描述最多255个字符', trigger: 'blur'}
          ],
          orderNo: [
            {required: true, message: '请输入订单号', trigger: 'blur'},
          ]
        }
      }
    },
    methods: {
      onSubmit() {
        this.$refs.taskForm.validate((valid) => {
          if (valid) {
            var json = JSON.stringify(this.form);
            if (this.type == 1) {
              saveTask(json).then((res) => {
                if (res.status == 200) {
                  this.$message.success("保存成功");
                  this.closeRefresh();
                } else {
                  this.$message.error(res.msg);
                }
              })
            } else if (this.type == 2) {
              var json = JSON.stringify(this.form);
              updateTask(this.id, json).then((res) => {
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
      searchTask() {
        if (this.id != null && this.id != '') {
          getTaskDetail(this.id).then((res) => {
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
        this.searchTask();
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
