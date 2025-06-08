<template>
  <div>
        <div class="container">
      <div class="login-form">
        <h1 class="h1">家政服务平台的设计与实现注册</h1>
		<el-form ref="rgsForm" class="rgs-form" :model="ruleForm">
			
			<el-form-item label="账号" class="input" v-if="tableName=='employer'">
			  <el-input v-model="ruleForm.employer_account" autocomplete="off" placeholder="账号"  />
			</el-form-item>
			
			<el-form-item label="密码" class="input" v-if="tableName=='employer'">
			  <el-input v-model="ruleForm.password" autocomplete="off" placeholder="密码" type="password"#elsetype="text" />
			</el-form-item>
			<el-form-item label="确认密码" class="input" v-if="tableName=='employer'">
			  <el-input v-model="ruleForm.password2" autocomplete="off" placeholder="确认密码" type="password"/>
			</el-form-item>

			
			<el-form-item label="姓名" class="input" v-if="tableName=='employer'">
			  <el-input v-model="ruleForm.employer_name" autocomplete="off" placeholder="姓名"  />
			</el-form-item>
			
			<el-form-item label="年龄" class="input" v-if="tableName=='employer'">
			  <el-input v-model="ruleForm.age" autocomplete="off" placeholder="年龄"  />
			</el-form-item>
			
			<el-form-item label="手机" class="input" v-if="tableName=='employer'">
			  <el-input v-model="ruleForm.phone" autocomplete="off" placeholder="手机"  />
			</el-form-item>
			
			<el-form-item label="雇员账号" class="input" v-if="tableName=='employee'">
			  <el-input v-model="ruleForm.employee_account" autocomplete="off" placeholder="雇员账号"  />
			</el-form-item>
			
			<el-form-item label="密码" class="input" v-if="tableName=='employee'">
			  <el-input v-model="ruleForm.password" autocomplete="off" placeholder="密码" type="password"#elsetype="text" />
			</el-form-item>
			<el-form-item label="确认密码" class="input" v-if="tableName=='employee'">
			  <el-input v-model="ruleForm.password2" autocomplete="off" placeholder="确认密码" type="password"/>
			</el-form-item>

			
			<el-form-item label="雇员姓名" class="input" v-if="tableName=='employee'">
			  <el-input v-model="ruleForm.employee_name" autocomplete="off" placeholder="雇员姓名"  />
			</el-form-item>
			
			<el-form-item label="年龄" class="input" v-if="tableName=='employee'">
			  <el-input v-model="ruleForm.age" autocomplete="off" placeholder="年龄"  />
			</el-form-item>
		
			<el-form-item label="联系电话" class="input" v-if="tableName=='employee'">
			  <el-input v-model="ruleForm.contact_phone" autocomplete="off" placeholder="联系电话"  />
			</el-form-item>
			
			<el-form-item label="身份证" class="input" v-if="tableName=='employee'">
			  <el-input v-model="ruleForm.id_card" autocomplete="off" placeholder="身份证"  />
			</el-form-item>
			<div style="display: flex;flex-wrap: wrap;width: 100%;justify-content: center;">
				<el-button class="btn" type="primary" @click="login()">注册</el-button>
				<el-button class="btn close" type="primary" @click="close()">取消</el-button>
			</div>
		</el-form>
      </div>
      <!-- <div class="nk-navigation">
        <a href="#">
          <div @click="login()">注册</div>
        </a>
      </div> -->
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
  created() {
    
  },
  methods: {
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    close(){
	this.$router.push({ path: "/login" });
    },
    // 注册
    login() {
	var url=this.tableName+"/register";
      if((!this.ruleForm.employer_account) && `employer` == this.tableName){
        this.$message.error(`账号不能为空`);
        return
      }
      if((!this.ruleForm.password) && `employer` == this.tableName){
        this.$message.error(`密码不能为空`);
        return
      }
      if((this.ruleForm.password!=this.ruleForm.password2) && `employer` == this.tableName){
	    this.$message.error(`两次密码输入不一致`);
	    return
      }
      if((!this.ruleForm.employer_name) && `employer` == this.tableName){
        this.$message.error(`姓名不能为空`);
        return
      }
      if(`employer` == this.tableName && this.ruleForm.age&&(!this.$validate.isIntNumer(this.ruleForm.age))){
        this.$message.error(`年龄应输入整数`);
        return
      }
      if(`employer` == this.tableName && this.ruleForm.phone&&(!this.$validate.isMobile(this.ruleForm.phone))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
      if((!this.ruleForm.employee_account) && `employee` == this.tableName){
        this.$message.error(`雇员账号不能为空`);
        return
      }
      if((!this.ruleForm.password) && `employee` == this.tableName){
        this.$message.error(`密码不能为空`);
        return
      }
      if((this.ruleForm.password!=this.ruleForm.password2) && `employee` == this.tableName){
	    this.$message.error(`两次密码输入不一致`);
	    return
      }
      if((!this.ruleForm.employee_name) && `employee` == this.tableName){
        this.$message.error(`雇员姓名不能为空`);
        return
      }
      if(`employee` == this.tableName && this.ruleForm.age&&(!this.$validate.isIntNumer(this.ruleForm.age))){
        this.$message.error(`年龄应输入整数`);
        return
      }
      if(`employee` == this.tableName && this.ruleForm.contact_phone&&(!this.$validate.isMobile(this.ruleForm.contact_phone))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }

      this.$http({
        url: url,
        method: "post",
        data:this.ruleForm,
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
	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.h1 {
		margin-top: 10px;
	}

	body {
		padding: 0;
		margin: 0;
	}

	

	.nk-navigation {
		margin-top: 15px;

		a {
			display: inline-block;
			color: #fff;
			background: rgba(255, 255, 255, .2);
			width: 100px;
			height: 50px;
			border-radius: 30px;
			text-align: center;
			display: flex;
			align-items: center;
			margin: 0 auto;
			justify-content: center;
			padding: 0 20px;
		}

		.icon {
			margin-left: 10px;
			width: 30px;
			height: 30px;
		}
	}

	.register-container {
		margin-top: 10px;

		a {
			display: inline-block;
			color: #fff;
			max-width: 500px;
			height: 50px;
			border-radius: 30px;
			text-align: center;
			display: flex;
			align-items: center;
			margin: 0 auto;
			justify-content: center;
			padding: 0 20px;

			div {
				margin-left: 10px;
			}
		}
	}

	.container {
		height: 100vh;
		background-position: center center;
		background-size: cover;
		background-repeat: no-repeat;
    				background-image: url(http://codegen.caihongy.cn/20211104/0d708b599e614301a43ac8d3dbcfa864.jpg);
		    
		.login-form {
			right: 50%;
			top: 50%;
			transform: translate3d(50%, -50%, 0);
			border-radius: 10px;
			background-color: rgba(255,255,255,.5);
			font-size: 14px;
			font-weight: 500;
      box-sizing: border-box;

			width: 430px;
			height: auto;
			padding: 15px;
			margin: 0px 0px 0px -10px;
			border-radius: 0;
			border-width: 4px;
			border-style: dotted;
			border-color: rgba(74, 50, 22, 1);
			background-color: rgba(253, 253, 229, 1);
			box-shadow: 0px 0px 0px 15px rgba(253, 253, 229, 1);

			.h1 {
				width: 400px;
				height: 32px;
				line-height:32px;
				color: rgba(74, 50, 22, 1);
				font-size: 18px;
				padding: 0px 0px 0px 0px;
				margin: 0px 0px 20px -20px;
				border-radius: 0;
				border-width: 0;
				border-style: dotted;
				border-color: rgba(255, 255, 255, 1);
				background-color: rgba(255, 215, 0, 0);
				box-shadow: 0px 0px 0px 0px rgba(74, 50, 22, 1);
				text-align: center;
			}

			.rgs-form {
				display: flex;
				flex-direction: column;
				justify-content: center;
				align-items: center;

        .el-form-item {
          width: 100%;
          display: flex;

          & ::v-deep .el-form-item__content {
            flex: 1;
            display: flex;
          }
        }

				.input {
          width: 320px;
          height:auto;
          padding: 0px 0px 0px 0px;
          margin: 0px 0px 10px -30px;
          border-radius: 0;
          border-width: 0;
          border-style: solid;
          border-color: rgba(255,0,0,0);
          background-color: rgba(30, 144, 255, 0);
          box-shadow: 0 0 6px rgba(255,0,0,0);

					& ::v-deep .el-form-item__label {
            width: 120px;
            line-height:42px;
            color: rgba(0, 0, 0, 1);
            font-size: 14px;
            padding: 0px 0px 0px 0px;
            margin: 0px 10px 0px 10px;
            border-radius: 0;
            border-width: 0;
            border-style: solid;
            border-color: rgba(255,0,0,0);
            background-color: rgba(255, 215, 0, 0);
            box-shadow: 0 0 6px rgba(255,0,0,0);
					}

					& ::v-deep .el-input__inner {
            width: 220px;
            height: 40px;
            line-height:40px;
            color: rgba(0, 0, 0, 1);
            font-size: 14px;
            padding: 0px 0px 0px 15px;
            margin: 0px 0px 0px 0px;
            border-radius: 4px;
            border-width: 2px;
            border-style: dotted;
            border-color: rgba(74, 50, 22, 1);
            background-color: rgba(253, 253, 229, 1);
            box-shadow: 0 0 6px rgba(255,0,0,0);
            text-align: left;
					}
				}

        .send-code {
          & ::v-deep .el-input__inner {
            width: 135px;
            height: 40px;
            line-height:40px;
            color: #606266;
            font-size: 14px;
            padding: 0px 0px 0px 10px;
            margin: 0px 0px 0px 0px;
            border-radius: 4px 0px 0px 4px;
            border-width: 2px;
            border-style: dotted;
            border-color: rgba(74, 50, 22, 1);
            background-color: rgba(253, 253, 229, 1);
            box-shadow: 0 0 6px rgba(255,0,0,0);
            text-align: left;
          }

          .register-code {
            margin: 0;
            padding: 0;
            width: 86px;
            height: 40px;
            line-height:40px;
            color: #fff;
            font-size: 14px;
            border-width: 0;
            border-style: solid;
            border-color: rgba(255,0,0,0);
            border-radius: 0;
            background-color: rgba(74, 50, 22, 1);
            box-shadow: 0 0 6px rgba(255,0,0,0);
          }
        }

				.btn {
					margin: 10px 0px 0px 5px;
          padding: 0;
					width: 88px;
					height: 40px;
          line-height:40px;
					color: #fff;
					font-size: 14px;
					border-width: 0;
					border-style: solid;
					border-color: #409EFF;
					border-radius: 4px;
					background-color: rgba(74, 50, 22, 1);
          box-shadow: 0 0 6px rgba(255,0,0,0);
				}

				.close {
          margin: 10px 0px 0px 20px;
          padding: 0px 0px 0px 0px;
          width: 88px;
          height: 40px;
          line-height:40px;
          color: rgba(255, 255, 255, 1);
          font-size: 14px;
          border-width: 0;
          border-style: solid;
          border-color: #409EFF;
          border-radius: 4px;
          background-color: rgba(74, 50, 22, 1);
          box-shadow: 0 0 6px rgba(255,0,0,0);
				}

			}
		}
	}
</style>
