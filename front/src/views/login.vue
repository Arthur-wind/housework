<template>
  <div class="login-bg">
    <div class="container loginIn">
      <div class="login-panel">
        <el-form :model="rulesForm" class="login-form" label-position="left" label-width="80px">
          <div class="title-container">
            <h3 class="title">家政服务平台的设计与实现登录</h3>
          </div>
          <el-form-item label="用户名" class="input-item">
            <!-- <span class="svg-container">
              <svg-icon icon-class="user" />
            </span> -->
            <el-input placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username"/>
          </el-form-item>
          <el-form-item label="密码" class="input-item">
            <!-- <span class="svg-container">
            <svg-icon icon-class="password" />
          </span> -->
            <el-input placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password"/>
          </el-form-item>
          <el-form-item label="验证码" class="input-item" v-if="1 == '1'">

            <el-input placeholder="请输入验证码" name="code" type="text" v-model="rulesForm.code"/>
            <div class="getCodeBt" @click="getRandCode(4)">
              <span v-for="(item, index) in codes" :key="index"
                    :style="{color:'#fff',transform:item.rotate,fontSize:'16px'}">{{ item.num }}</span>
            </div>
          </el-form-item>
          <el-form-item v-if="roles.length>1" label="角色" prop="loginInRole" class="role-select" label-width="60px">
            <el-radio
                v-for="item in roles"
                :key="item.roleName"
                v-model="rulesForm.role"
                :label="item.roleName"
            >{{ item.roleName }}
            </el-radio>
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
<!--<script>-->
<!--const urlParams = new URLSearchParams(window.location.search);-->
<!--const token = urlParams.get('token');-->

<!--if (token) {-->
<!--  fetch('http://localhost:8080/api/auth/verify-token', {-->
<!--    method: 'GET',-->
<!--    headers: {-->
<!--      'Authorization': 'Bearer ' + token-->
<!--    }-->
<!--  })-->
<!--      .then(res => res.json())-->
<!--      .then(data => {-->
<!--        if (data.success) {-->
<!--          localStorage.setItem('token', token);-->
<!--          localStorage.setItem('user', JSON.stringify(data.data));-->
<!--          window.location.href = '/'; // 跳转到后台首页-->
<!--        } else {-->
<!--          alert('Token 失效，请重新登录');-->
<!--          window.location.href = './login.html';-->
<!--        }-->
<!--      });-->
<!--}-->
<!--</script>-->

<script>
import menu from "@/utils/menu";
export default {
  data() {
    return {
      rulesForm: {
        username: "",
        password: "",
        role: "",
        code: '',
      },
      menus: [],
      roles: [],
      tableName: "",
      codes: [
        {num: 1, color: '#000', rotate: '10deg', size: '16px'},
        {num: 2, color: '#000', rotate: '10deg', size: '16px'},
        {num: 3, color: '#000', rotate: '10deg', size: '16px'},
        {num: 4, color: '#000', rotate: '10deg', size: '16px'}
      ],
    };
  },
  mounted() {
    // 获取整个 hash 部分，例如：#/login?token=abc
    const hash = window.location.hash;
    const queryString = hash.split('?')[1] || '';

    // 使用 URLSearchParams 解析
    const params = new URLSearchParams(queryString);
    const token = params.get('token');

    if (token) {
      console.log(" 成功获取 token：", token);
      localStorage.setItem("token", token);
      this.validateToken(token); // 发起验证请求
    } else {
      console.error(" 无法从 URL 中获取 token");
    }


    let menus = menu.list();
    this.menus = menus;
    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin == '是') {
        this.roles.push(this.menus[i])
      }
    }
  },
  created() {
    console.log('rulesForm in created:', this.rulesForm);
    this.getRandCode();
  },
  methods: {
    validateToken(token) {
      fetch('/springbootc90g5/auth/verify-token', {
        method: 'GET',
        headers: {
          'Authorization': 'Bearer ' + token
        },
        credentials: 'include' // 如果后端需要 cookie 或 session 支持
      })
          .then(res => res.json())
          .then(data => {
            if (data.code === 0) {
              console.log(" Token 验证通过，用户信息：", data);
              const user = {
                userId: data.userId,
                username: data.username,
                tableName: data.tableName,
                role: data.role
              };
              localStorage.setItem("user", JSON.stringify(data.data));
            } else {
              console.error("Token 无效或已过期",token);
              alert("登录失败，请重新登录");
              // window.location.href = '/login';
            }
          })
          .catch(err => {
            console.error(" 请求失败：", err);
          });
    },


    register(tableName) {
      this.$storage.set("loginTable", tableName);
      this.$router.push({path: '/register'})
    },
    // 登陆
    login() {
      let code = ''
      for (let i in this.codes) {
        code += this.codes[i].num
      }
      if ('1' == '1' && !this.rulesForm.code) {
        this.$message.error("请输入验证码");
        return;
      }
      if ('1' == '1' && this.rulesForm.code.toLowerCase() != code.toLowerCase()) {
        this.$message.error("验证码输入有误");
        this.getRandCode()
        return;
      }
      if (!this.rulesForm.username) {
        this.$message.error("请输入用户名");
        return;
      }
      if (!this.rulesForm.password) {
        this.$message.error("请输入密码");
        return;
      }
      if (this.roles.length > 1) {
        if (!this.rulesForm.role) {
          this.$message.error("请选择角色");
          return;
        }
        let menus = this.menus;
        for (let i = 0; i < menus.length; i++) {
          if (menus[i].roleName == this.rulesForm.role) {
            this.tableName = menus[i].tableName;
          }
        }
      } else {
        this.tableName = this.roles[0].tableName;
        this.rulesForm.role = this.roles[0].roleName;
      }

      this.$http({
        url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
        method: "get"
      }).then(({data}) => {
        if (data && data.code === 0) {
          this.$storage.set("Token", data.token);
          this.$storage.set("role", this.rulesForm.role);
          this.$storage.set("sessionTable", this.tableName);
          this.$storage.set("adminName", this.rulesForm.username);
          this.$router.replace({path: "/index/"});
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    getRandCode(len = 4) {
      this.randomString(len)
    },
    randomString(len = 4) {
      let chars = [
          "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
          "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
          "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G",
          "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
          "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2",
          "3", "4", "5", "6", "7", "8", "9"
      ]
      let colors = ["0", "1", "2","3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"]
      let sizes = ['14', '15', '16', '17', '18']

      let output = [];
      for (let i = 0; i < len; i++) {
        // 随机验证码
        let key = Math.floor(Math.random() * chars.length)
        this.codes[i].num = chars[key]
        // 随机验证码颜色
        let code = '#'
        for (let j = 0; j < 6; j++) {
          let key = Math.floor(Math.random() * colors.length)
          code += colors[key]
        }
        this.codes[i].color = code
        // 随机验证码方向
        let rotate = Math.floor(Math.random() * 60)
        let plus = Math.floor(Math.random() * 2)
        if (plus == 1) rotate = '-' + rotate
        this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
        // 随机验证码字体大小
        let size = Math.floor(Math.random() * sizes.length)
        this.codes[i].size = sizes[size] + 'px'
      }
    },
  }
  
};
</script>
<style lang="scss" scoped>
.login-bg {
  min-height: 100vh;
  background: url('~@/assets/img/loginbackground.jpg') no-repeat center center;
  background-size: cover;
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
// .login-panel {
//   background: #f0f6ff;
//   border: 1px solid #cce0ff;
//   box-shadow: 0 4px 32px 0 rgba(100, 149, 237, 0.18), 0 1.5px 6px 0 rgba(30, 144, 255, 0.08);
// }
.login-form {
  position: relative;
  top: 0;
  right: 0;
  width: 350px;
  height: 100%;
  background: #ffffff;
  padding: 0 60px;
  font-size: 18px;
  font-weight: bold;
  box-shadow: 0 4px 32px rgba(144, 238, 144, 0.18), 0 1.5px 6px rgba(0, 206, 209, 0.08);
  border-radius: 18px;
}

.title-container {
  text-align: center;
  margin-bottom: 32px;
  .title {
    color: #2574c7;
    text-shadow: 0 2px 8px #e6f0ff;
    font-size: 28px;
    font-weight: 600;
    letter-spacing: 2px;
  }
}
.input-item {
  margin-bottom: 22px;
  background: #eaf3ff;
  border: 1px solid #b3d1ff;
  border-radius: 8px;
  padding: 0 12px;
  position: relative;
  padding-right: 70px; // 给验证码预留空间
  // 让内容区（图标+输入框）横向排列
  .el-form-item__content {
    display: flex;
    align-items: center;
  }
  .svg-container {
    color: #2574c7;
    font-size: 18px;
    margin-right: 8px;
    z-index: 2;
  }
  .el-input {
    background: transparent;
    border: none;
    flex: 1;
  }
  .getCodeBt {
    position: absolute;
    left: 195px;
    top: 50%;
    transform: translateY(-50%);
    background: #6cb6ff;
    color: #fff;
    border-radius: 6px;
    padding: 0 12px;
    height: 32px;
    display: flex;
    align-items: center;
    cursor: pointer;
    font-size: 16px;
    font-weight: 600;
    box-shadow: 0 2px 8px #b3d1ff;
    user-select: none;
  }
}
.role-select {
  margin-bottom: 18px;
  .el-radio {
    margin-right: 18px;
    color: #2574c7;
  }
  .el-radio__input.is-checked .el-radio__inner {
    border-color: #2574c7;
    background: #b3d1ff;
  }
}
.loginInBt {
  width: 100%;
  background: linear-gradient(90deg, #b3d1ff 0%, #2574c7 100%);
  color: #fff;
  border: none;
  border-radius: 8px;
  font-size: 18px;
  font-weight: 500;
  margin-bottom: 18px;
  box-shadow: 0 2px 8px #b3d1ff;
  transition: background 0.3s;
  &:hover {
    background: linear-gradient(90deg, #2574c7 0%, #b3d1ff 100%);
  }
}
.setting {
  justify-content: center;
  .register {
    color: #5eaaff;
    cursor: pointer;
    font-size: 15px;
    padding: 0 8px;
    border-radius: 4px;
    transition: background 0.2s, color 0.2s;
    &:hover {
      background: #e0f0ff;
      color: #2574c7;
    }
  }
}
</style>
