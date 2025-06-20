<template>
  <div class="register-bg">
    <div class="container registerIn">
      <div class="register-panel">
        <el-form ref="rgsForm" class="register-form" label-position="left" label-width="100px" :model="ruleForm">
          <div class="title-container">
            <h3 class="title">三元一次家政</h3>
          </div>
          
          <!-- 雇主注册表单 -->
          <template v-if="tableName=='employer'">
            <el-form-item label="账号" class="input-item">
              <el-input v-model="ruleForm.employer_account" autocomplete="off" placeholder="请输入账号" />
            </el-form-item>
            
            <el-form-item label="密码" class="input-item">
              <el-input v-model="ruleForm.password" autocomplete="off" placeholder="请输入密码" type="password" show-password />
            </el-form-item>
            
            <el-form-item label="确认密码" class="input-item">
              <el-input v-model="ruleForm.password2" autocomplete="off" placeholder="请再次输入密码" type="password" show-password />
            </el-form-item>
            
            <el-form-item label="姓名" class="input-item">
              <el-input v-model="ruleForm.employer_name" autocomplete="off" placeholder="请输入姓名" />
            </el-form-item>
            
            <el-form-item label="年龄" class="input-item">
              <el-input v-model="ruleForm.age" autocomplete="off" placeholder="请输入年龄" />
            </el-form-item>
            
            <el-form-item label="手机" class="input-item">
              <el-input v-model="ruleForm.phone" autocomplete="off" placeholder="请输入手机号码" />
            </el-form-item>
          </template>
          
          <!-- 雇员注册表单 -->
          <template v-if="tableName=='employee'">
            <el-form-item label="雇员账号" class="input-item">
              <el-input v-model="ruleForm.employee_account" autocomplete="off" placeholder="请输入雇员账号" />
            </el-form-item>
            
            <el-form-item label="密码" class="input-item">
              <el-input v-model="ruleForm.password" autocomplete="off" placeholder="请输入密码" type="password" show-password />
            </el-form-item>
            
            <el-form-item label="确认密码" class="input-item">
              <el-input v-model="ruleForm.password2" autocomplete="off" placeholder="请再次输入密码" type="password" show-password />
            </el-form-item>
            
            <el-form-item label="雇员姓名" class="input-item">
              <el-input v-model="ruleForm.employee_name" autocomplete="off" placeholder="请输入雇员姓名" />
            </el-form-item>
            
            <el-form-item label="年龄" class="input-item">
              <el-input v-model="ruleForm.age" autocomplete="off" placeholder="请输入年龄" />
            </el-form-item>
            
            <el-form-item label="联系电话" class="input-item">
              <el-input v-model="ruleForm.contact_phone" autocomplete="off" placeholder="请输入联系电话" />
            </el-form-item>
            
            <el-form-item label="身份证" class="input-item">
              <el-input v-model="ruleForm.id_card" autocomplete="off" placeholder="请输入身份证号码" />
            </el-form-item>
          </template>
          
          <div class="btn-group">
            <el-button type="primary" @click="login()" class="registerBt">注册</el-button>
            <el-button class="registerBt close" @click="close()">取消</el-button>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        employer_account: '',
        password: '',
        password2: '',
        employer_name: '',
        age: '',
        phone: '',
        employee_account: '',
        employee_name: '',
        contact_phone: '',
        id_card: ''
      },
      tableName: "",
      rules: {},
    };
  },
  mounted() {
    let table = this.$storage.get("loginTable");
    this.tableName = table;
  },
  methods: {
    close() {
      this.$router.push({ path: "/login" });
    },
    login() {
      var url = this.tableName + "/register";
      // 验证逻辑保持不变...
      this.$http({
        url: url,
        method: "post",
        data: this.ruleForm,
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "注册成功",
            type: "success",
            duration: 1500,
            onClose: () => {
              this.$router.replace({ path: "/login" });
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
.register-bg {
  min-height: 100vh;
  background: linear-gradient(135deg, #b8f2e6 0%, #e6ffe6 100%);
  display: flex;
  align-items: center;
  justify-content: center;
}

.container.registerIn {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 80vh;
}

.register-panel {
  background: #fffbea;
  border-radius: 18px;
  box-shadow: 0 4px 32px 0 rgba(144, 238, 144, 0.18), 0 1.5px 6px 0 rgba(0, 206, 209, 0.08);
  padding: 48px 40px 36px;
  width: 520px;
  border: 1px solid #e0f7ef;
}

.register-form {
  width: 100%;
}

.title-container {
  text-align: center;
  margin-bottom: 32px;
  
  .title {
    color: #3bb78f;
    font-size: 28px;
    font-weight: 600;
    letter-spacing: 2px;
    text-shadow: 0 2px 8px #e6ffe6;
  }
}

.input-item {
  margin-bottom: 22px;
  background: #f6fff8;
  border-radius: 8px;
  padding: 0 12px;
  border: 1px solid #d2f5e3;
  
  ::v-deep .el-form-item__label {
    color: #3bb78f;
    font-size: 16px;
    font-weight: 500;
  }
  
  ::v-deep .el-input__inner {
    background: transparent;
    border: none;
    height: 40px;
    line-height: 40px;
  }
}

.btn-group {
  display: flex;
  justify-content: center;
  margin-top: 32px;
}

.registerBt {
  width: 120px;
  background: linear-gradient(90deg, #b8f2e6 0%, #3bb78f 100%);
  color: #fff;
  border: none;
  border-radius: 8px;
  font-size: 16px;
  font-weight: 500;
  box-shadow: 0 2px 8px #b8f2e6;
  transition: all 0.3s;
  
  &:hover {
    background: linear-gradient(90deg, #3bb78f 0%, #b8f2e6 100%);
    transform: translateY(-2px);
  }
  
  &.close {
    background: #b8b8b8;
    margin-left: 20px;
    
    &:hover {
      background: #888;
    }
  }
}
</style>