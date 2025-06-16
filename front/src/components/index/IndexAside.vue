<template>
  <el-aside class="index-aside" width="200px">
    <div class="index-aside-inner">
      <el-menu default-active="1">
        <el-menu-item @click="menuHandler('/')" index="1">
          <!-- <i class="el-icon-s-home"></i> -->
          首页
        </el-menu-item>
        <sub-menu
          v-for="menu in menuList"
          :key="menu.menuId"
          :menu="menu"
          :dynamicMenuRoutes="dynamicMenuRoutes"
        ></sub-menu>
      </el-menu>
    </div>
  </el-aside>
</template>
<script>
import SubMenu from "@/components/index/IndexAsideSub";
export default {
  data() {
    return {
      menuList: [],
      dynamicMenuRoutes: []
    };
  },
  components: {
    SubMenu
  },
  mounted() {
    // 获取动态菜单数据并且渲染
    this.menuList = JSON.parse(sessionStorage.getItem("menuList") || "[]");
    this.dynamicMenuRoutes = JSON.parse(
      sessionStorage.getItem("dynamicMenuRoutes") || "[]"
    );
  },
  methods: {
    menuHandler(path) {
      this.$router.push({ path: path });
    }
  }
};
</script>
<style lang="scss" scoped>
.index-aside {
  // background: #fffbea;
  border-radius: 18px 0 0 18px;
  box-shadow: 0 4px 32px 0 rgba(144, 238, 144, 0.12),
    0 1.5px 6px 0 rgba(0, 206, 209, 0.06);
  margin-top: 80px;
  border-right: 1px solid #e0f7ef;
  .index-aside-inner {
    width: 217px;
    height: 100%;
    overflow-y: auto;
    background: transparent;
    padding: 0;
  }
  .el-menu {
    background: transparent;
    border: none;
    .el-menu-item {
      color: #3bb78f;
      font-weight: 500;
      border-radius: 8px;
      margin-bottom: 6px;
      &:hover,
      &.is-active {
        background: linear-gradient(90deg, #b8f2e6 0%, #3bb78f 100%) !important;
        color: #fff !important;
      }
    }
  }
}
</style>

