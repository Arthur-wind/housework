<template>
  <div class="login-bg">
    <div class="container loginIn">
      <div class="login-panel">
        <el-form class="login-form" label-position="left" :label-width="'0px'">
          <div class="title-container">
            <h3 class="title">家政服务平台的设计与实现登录</h3>
          </div>
          <el-form-item class="input-item">
            <span class="svg-container">
              <svg-icon icon-class="user" />
            </span>
            <el-input placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username" />
          </el-form-item>
          <el-form-item class="input-item">
            <span class="svg-container">
              <svg-icon icon-class="password" />
            </span>
            <el-input placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password" />
          </el-form-item>
          <el-form-item v-if="roles.length>1" label="角色" prop="loginInRole" class="role-select">
            <el-radio
              v-for="item in roles"
              :key="item.roleName"
              v-model="rulesForm.role"
              :label="item.roleName"
            >{{item.roleName}}</el-radio>
          </el-form-item>
          <el-form-item v-if="roles.length==1" label=" " prop="loginInRole" class="role-select"></el-form-item>
          <el-button type="primary" @click="login()" class="loginInBt">登录</el-button>
          <el-form-item class="setting">
            <span class="register" @click="register('employer')">雇主注册</span>
            <span class="register" @click="register('employee')" style="margin-left: 20px;">雇员注册</span>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>
<script>
import menu from "@/utils/menu";
export default {
  data() {
    return {
      // ...existing code...
    };
  },
  // ...existing code...
};
</script>
<style lang="scss" scoped>
.login-bg {
  min-height: 100vh;
  background: linear-gradient(135deg, #b8f2e6 0%, #e6ffe6 100%);
  display: flex;
  align-items: center;
  justify-content: center;
}
.container.loginIn {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 80vh;
}
.login-panel {
  background: #fffbea;
  border-radius: 18px;
  box-shadow: 0 4px 32px 0 rgba(144, 238, 144, 0.18), 0 1.5px 6px 0 rgba(0, 206, 209, 0.08);
  padding: 48px 40px 36px 40px;
  width: 420px;
  max-width: 90vw;
  border: 1px solid #e0f7ef;
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
  display: flex;
  align-items: center;
  margin-bottom: 22px;
  background: #f6fff8;
  border-radius: 8px;
  padding: 0 12px;
  border: 1px solid #d2f5e3;
  .svg-container {
    color: #3bb78f;
    font-size: 18px;
    margin-right: 8px;
  }
  .el-input {
    background: transparent;
    border: none;
    flex: 1;
  }
}
.role-select {
  margin-bottom: 18px;
  .el-radio {
    margin-right: 18px;
    color: #3bb78f;
  }
  .el-radio__input.is-checked .el-radio__inner {
    border-color: #3bb78f;
    background: #b8f2e6;
  }
}
.loginInBt {
  width: 100%;
  background: linear-gradient(90deg, #b8f2e6 0%, #3bb78f 100%);
  color: #fff;
  border: none;
  border-radius: 8px;
  font-size: 18px;
  font-weight: 500;
  margin-bottom: 18px;
  box-shadow: 0 2px 8px #b8f2e6;
  transition: background 0.3s;
  &:hover {
    background: linear-gradient(90deg, #3bb78f 0%, #b8f2e6 100%);
  }
}
.setting {
  display: flex;
  justify-content: center;
  .register {
    color: #5ec6c6;
    cursor: pointer;
    font-size: 15px;
    padding: 0 8px;
    border-radius: 4px;
    transition: background 0.2s, color 0.2s;
    &:hover {
      background: #e0f7ef;
      color: #3bb78f;
    }
  }
}
</style>