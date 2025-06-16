<template>
	<div class="navbar" :style="{background:heads.headBgColor,height:heads.headHeight,boxShadow:heads.headBoxShadow,lineHeight:heads.headHeight}">
		<div class="title-menu" :style="{justifyContent:heads.headTitleStyle=='1'?'flex-start':'center'}">
			<el-image v-if="heads.headTitleImg" class="title-img" :style="{width:heads.headTitleImgWidth,height:heads.headTitleImgHeight,boxShadow:heads.headTitleImgBoxShadow,borderRadius:heads.headTitleImgBorderRadius}" :src="heads.headTitleImgUrl" fit="cover"></el-image>
			<div class="title-name" :style="{color:heads.headFontColor,fontSize:heads.headFontSize}">{{this.$project.projectName}}</div>
		</div>
		<div class="right-menu">
			<div class="user-info" :style="{color:heads.headUserInfoFontColor,fontSize:heads.headUserInfoFontSize}">{{this.$storage.get('role')}} {{this.$storage.get('adminName')}}</div>
			<div v-if="this.$storage.get('role')!='管理员'" class="logout" :style="{color:heads.headLogoutFontColor,fontSize:heads.headLogoutFontSize}" @click="onIndexTap">退出到前台</div>
			<div class="logout" :style="{color:heads.headLogoutFontColor,fontSize:heads.headLogoutFontSize}" @click="onLogout">退出登录</div>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				dialogVisible: false,
				ruleForm: {},
				user: {},
				heads: {"headFontSize":"20px","headTitleImgHeight":"44px","headFontColor":"rgba(74, 50, 22, 1)","headTitleImg":false,"headHeight":"58px","headTitleImgBorderRadius":"22px","headTitleImgUrl":"http://codegen.caihongy.cn/20201021/cc7d45d9c8164b58b18351764eba9be1.jpg","headUserInfoFontSize":"16px","headTitleImgWidth":"44px","headTitleStyle":"1","headLogoutFontSize":"16px"},
			};
		},
		created() {
			this.setHeaderStyle()
		},
		mounted() {
			let sessionTable = this.$storage.get("sessionTable")
			this.$http({
				url: sessionTable + '/session',
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
					this.user = data.data;
					this.$storage.set('userid',data.data.id);
				} else {
					let message = this.$message
					message.error(data.msg);
				}
			});
		},
		methods: {
			onLogout() {
				let storage = this.$storage
				let router = this.$router
				storage.clear()
				router.replace({
					name: "login"
				});
			},
      			onIndexTap(){
      				window.location.href = `${this.$base.indexUrl}`
    			},
			setHeaderStyle() {
			  this.$nextTick(()=>{
			    document.querySelectorAll('.navbar .right-menu .logout').forEach(el=>{
			      el.addEventListener("mouseenter", e => {
			        e.stopPropagation()
			        el.style.backgroundColor = this.heads.headLogoutFontHoverBgColor
					el.style.color = this.heads.headLogoutFontHoverColor
			      })
			      el.addEventListener("mouseleave", e => {
			        e.stopPropagation()
			        el.style.backgroundColor = "transparent"
					el.style.color = this.heads.headLogoutFontColor
			      })
			    })
			  })
			},
		}
	};
</script>


<style lang="scss" scoped>
	.navbar {
  height: 60px;
  line-height: 60px;
  width: 100%;
  padding: 0 34px;
  box-sizing: border-box;
  background: linear-gradient(90deg, #b8f2e6 0%, #e6ffe6 100%);
  box-shadow: 0 2px 8px #b8f2e6;
  position: relative;
  z-index: 111;
  border-bottom: 1px solid #e0f7ef;

  .right-menu {
    position: absolute;
    right: 34px;
    top: 0;
    height: 100%;
    display: flex;
    justify-content: flex-end;
    align-items: center;
    z-index: 111;
    .user-info {
      font-size: 16px;
      color: #3bb78f;
      padding: 0 12px;
      font-weight: 500;
    }
    .logout {
      font-size: 16px;
      color: #5ec6c6;
      padding: 0 12px;
      cursor: pointer;
      border-radius: 6px;
      transition: background 0.2s, color 0.2s;
      &:hover {
        background: #e0f7ef;
        color: #3bb78f;
      }
    }
  }
  .title-menu {
    display: flex;
    justify-content: flex-start;
    align-items: center;
    width: 100%;
    height: 100%;
    .title-img {
      width: 44px;
      height: 44px;
      border-radius: 22px;
      box-shadow: 0 1px 6px #b8f2e6;
      margin-right: 16px;
    }
    .title-name {
      font-size: 24px;
      color: #3bb78f;
      font-weight: 700;
      letter-spacing: 2px;
      text-shadow: 0 2px 8px #e6ffe6;
    }
  }
}

</style>
