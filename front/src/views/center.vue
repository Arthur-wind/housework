<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
	  style="background: transparent;"
    >  
     <el-row>
      <el-col :span="12">
        <el-form-item   v-if="flag=='employer'"  label="账号" prop="employer_account">
          <el-input v-model="ruleForm.employer_account" readonly              placeholder="账号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='employer'"  label="姓名" prop="employer_name">
          <el-input v-model="ruleForm.employer_name"               placeholder="姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='employer'"  label="年龄" prop="age">
          <el-input v-model="ruleForm.age"               placeholder="年龄" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='employer'"  label="性别" prop="gender">
          <el-select v-model="ruleForm.gender"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in employergenderOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='employer'"  label="手机" prop="phone">
          <el-input v-model="ruleForm.phone"               placeholder="手机" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="24">  
        <el-form-item v-if="flag=='employer'" label="照片" prop="photo">
          <file-upload
          tip="点击上传照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.photo?ruleForm.photo:''"
          @change="employerphotoUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='employee'"  label="雇员账号" prop="employee_account">
          <el-input v-model="ruleForm.employee_account" readonly              placeholder="雇员账号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='employee'"  label="雇员姓名" prop="employee_name">
          <el-input v-model="ruleForm.employee_name"               placeholder="雇员姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='employee'"  label="年龄" prop="age">
          <el-input v-model="ruleForm.age"               placeholder="年龄" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='employee'"  label="性别" prop="gender">
          <el-select v-model="ruleForm.gender"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in employeegenderOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='employee'"  label="联系电话" prop="contact_phone">
          <el-input v-model="ruleForm.contact_phone"               placeholder="联系电话" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='employee'"  label="身份证" prop="id_card">
          <el-input v-model="ruleForm.id_card"               placeholder="身份证" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="24">  
        <el-form-item v-if="flag=='employee'" label="照片" prop="photo">
          <file-upload
          tip="点击上传照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.photo?ruleForm.photo:''"
          @change="employeephotoUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
      <el-form-item v-if="flag=='users'" label="用户名" prop="username">
        <el-input v-model="ruleForm.username" 
        placeholder="用户名"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      employergenderOptions: [],
      employeegenderOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.employergenderOptions = "男,女".split(',')
    this.employeegenderOptions = "男,女".split(',')
  },
  methods: {
    employerphotoUploadChange(fileUrls) {
        this.ruleForm.photo = fileUrls;
    },
    employeephotoUploadChange(fileUrls) {
        this.ruleForm.photo = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.employer_account)&& 'employer'==this.flag){
        this.$message.error('账号不能为空');
        return
      }
      if((!this.ruleForm.password)&& 'employer'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.employer_name)&& 'employer'==this.flag){
        this.$message.error('姓名不能为空');
        return
      }
      if( 'employer' ==this.flag && this.ruleForm.age&&(!isIntNumer(this.ruleForm.age))){
       this.$message.error(`年龄应输入整数`);
        return
      }
      if( 'employer' ==this.flag && this.ruleForm.phone&&(!isMobile(this.ruleForm.phone))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
        if(this.ruleForm.photo!=null) {
                this.ruleForm.photo = this.ruleForm.photo.replace(new RegExp(this.$base.url,"g"),"");
        }
      if((!this.ruleForm.employee_account)&& 'employee'==this.flag){
        this.$message.error('雇员账号不能为空');
        return
      }
      if((!this.ruleForm.password)&& 'employee'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.employee_name)&& 'employee'==this.flag){
        this.$message.error('雇员姓名不能为空');
        return
      }
      if( 'employee' ==this.flag && this.ruleForm.age&&(!isIntNumer(this.ruleForm.age))){
       this.$message.error(`年龄应输入整数`);
        return
      }
      if( 'employee' ==this.flag && this.ruleForm.contact_phone&&(!isMobile(this.ruleForm.contact_phone))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }
      if( 'employee' ==this.flag && this.ruleForm.id_card&&(!checkIdCard(this.ruleForm.id_card))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
        if(this.ruleForm.photo!=null) {
                this.ruleForm.photo = this.ruleForm.photo.replace(new RegExp(this.$base.url,"g"),"");
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
