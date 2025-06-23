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
            <el-form-item label="雇主账号" class="input-item">
              <el-input v-model="ruleForm.employer_account" autocomplete="off" placeholder="请输入雇主账号" />
            </el-form-item>
            
            <el-form-item label="密码" class="input-item">
              <el-input v-model="ruleForm.password" autocomplete="off" placeholder="请输入密码" type="password" show-password />
            </el-form-item>
            
            <el-form-item label="确认密码" class="input-item">
              <el-input v-model="ruleForm.password2" autocomplete="off" placeholder="请再次输入密码" type="password" show-password />
            </el-form-item>

            <el-form-item label="性别" class="input-item">
              <el-radio-group v-model="ruleForm.gender">
                <el-radio label="男">男</el-radio>
                <el-radio label="女">女</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item label="头像" class="input-item">
              <el-upload
                class="avatar-uploader"
                action="/springbootc90g5/file/upload"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
              >
                <img v-if="ruleForm.avatar" :src="baseURL + ruleForm.avatar" class="avatar" />
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
              </el-upload>
            </el-form-item>
            
            <el-form-item label="雇主姓名" class="input-item">
              <el-input v-model="ruleForm.employer_name" autocomplete="off" placeholder="请输入雇主姓名" />
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

            <el-form-item label="性别" class="input-item">
              <el-radio-group v-model="ruleForm.gender">
                <el-radio label="男">男</el-radio>
                <el-radio label="女">女</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item label="头像" class="input-item">
              <el-upload
                class="avatar-uploader"
                action="/springbootc90g5/file/upload"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :before-upload="beforeAvatarUpload"
              >
                <img v-if="ruleForm.avatar" :src="baseURL + ruleForm.avatar" class="avatar" />
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
              </el-upload>
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
      baseURL: '/springbootc90g5/upload/',  
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
        id_card: '',
        gender: '',
        avatar: '',
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
    handleAvatarSuccess(res) {
  if(res.code === 0) {
    this.ruleForm.avatar = res.file || '';
    console.log('上传后头像文件名:', this.ruleForm.avatar);
  } else {
    this.$message.error("头像上传失败");
  }
},
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg' || file.type === 'image/png';
      const isLt2M = file.size / 1024 / 1024 < 2;
      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG/PNG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isJPG && isLt2M;
    },
    login() {
  if (!this.ruleForm.password || !this.ruleForm.password2) {
    this.$message.error("请输入密码和确认密码");
    return;
  }
  if (this.ruleForm.password !== this.ruleForm.password2) {
    this.$message.error("两次密码输入不一致，请重新输入");
    this.ruleForm.password = '';
    this.ruleForm.password2 = '';
    return;
  }
  var url = this.tableName + "/register";
  if (this.ruleForm.avatar) {
    this.ruleForm.photo = 'upload/' + this.ruleForm.avatar;  // 这里拼接前缀提交数据库
  }
  this.$http({
    url: url,
    method: "post",
    data: {
      ...this.ruleForm,
      password2: undefined
    },
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

.avatar-uploader {
  display: flex;
  align-items: center;
  .avatar {
    width: 80px;
    height: 80px;
    display: block;
    border-radius: 50%;
    margin-right: 10px;
    border: 1px solid #eee;
    object-fit: cover;
  }
  .avatar-uploader-icon {
    font-size: 32px;
    color: #d2f5e3;
    width: 80px;
    height: 80px;
    line-height: 80px;
    text-align: center;
    border: 1px dashed #d2f5e3;
    border-radius: 50%;
    background: #f6fff8;
    cursor: pointer;
  }
}
</style>
