<template>
  <div class="home-comment">
    <div class="title">用户留言</div>
    <div class="comment-list">
      <div v-for="(item,index) in list"  v-bind:key="index" class="comment-item">
        <div class="user-content">
          <el-image
            class="avator"
            :src="item.avator"
          ></el-image>
          <span class="user">{{item.name}}</span>
        </div>
        <div class="comment">{{item.content}}</div>
        <div class="create-time">{{item.createTime}}</div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      list: [
        {
          name: "MaskLin",
          avator:
            "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
          content:
            "诺兰用极致的叙事张力剥开了 “原子弹之父” 的灵魂褶皱 —— 当奥本海默在听证会上颤抖着说出 “我成了死神，世界的毁灭者”，黑白与彩色画幅的割裂恰似科学理想与道德深渊的博弈。曼哈顿计划实验室里噼啪作响的电流、 Trinity 核试验时灼穿视网膜的白光，以及人群欢呼中隐藏的末日回响，每一帧都在叩问：当人类触碰到神的权柄，文明的齿轮会碾过多少良知的残骸？影片最震撼的不是核爆的视觉奇观，而是让观众在奥本海默的瞳孔里，看见科技狂喜与存在恐惧的永恒角力。",
          createTime: "6月22日 00:00"
        },
        {
          name: "MaskLin",
          avator:
            "诺兰用极致的叙事张力剥开了 “原子弹之父” 的灵魂褶皱 —— 当奥本海默在听证会上颤抖着说出 “我成了死神，世界的毁灭者”，黑白与彩色画幅的割裂恰似科学理想与道德深渊的博弈。曼哈顿计划实验室里噼啪作响的电流、 Trinity 核试验时灼穿视网膜的白光，以及人群欢呼中隐藏的末日回响，每一帧都在叩问：当人类触碰到神的权柄，文明的齿轮会碾过多少良知的残骸？影片最震撼的不是核爆的视觉奇观，而是让观众在奥本海默的瞳孔里，看见科技狂喜与存在恐惧的永恒角力。",
          content: "111",
          createTime: "6月22日 00:00"
        },
        {
          name: "MaskLin",
          avator:
            "诺兰用极致的叙事张力剥开了 “原子弹之父” 的灵魂褶皱 —— 当奥本海默在听证会上颤抖着说出 “我成了死神，世界的毁灭者”，黑白与彩色画幅的割裂恰似科学理想与道德深渊的博弈。曼哈顿计划实验室里噼啪作响的电流、 Trinity 核试验时灼穿视网膜的白光，以及人群欢呼中隐藏的末日回响，每一帧都在叩问：当人类触碰到神的权柄，文明的齿轮会碾过多少良知的残骸？影片最震撼的不是核爆的视觉奇观，而是让观众在奥本海默的瞳孔里，看见科技狂喜与存在恐惧的永恒角力。",
          content: "111",
          createTime: "6月22日 00:00"
        },
        {
          name: "MaskLin",
          avator: "诺兰用极致的叙事张力剥开了 “原子弹之父” 的灵魂褶皱 —— 当奥本海默在听证会上颤抖着说出 “我成了死神，世界的毁灭者”，黑白与彩色画幅的割裂恰似科学理想与道德深渊的博弈。曼哈顿计划实验室里噼啪作响的电流、 Trinity 核试验时灼穿视网膜的白光，以及人群欢呼中隐藏的末日回响，每一帧都在叩问：当人类触碰到神的权柄，文明的齿轮会碾过多少良知的残骸？影片最震撼的不是核爆的视觉奇观，而是让观众在奥本海默的瞳孔里，看见科技狂喜与存在恐惧的永恒角力。",
          content: "111",
          createTime: "6月22日 00:00"
        }
      ]
    };
  }
};
</script>
<style lang="scss" scoped>
.home-comment {
  background: #ffffff;
  .title {
    font-size: 18px;
    color: #666;
    font-weight: bold;
    padding: 10px;
    border-bottom: 1px solid #eeeeee;
  }
  .comment-list {
    padding: 10px;
    .comment-item {
      padding: 10px;
      border-bottom: 1px solid #eeeeee;
      .user-content {
        display: flex;
        align-items: center;
        .user {
          font-size: 18px;
          color: #666;
          font-weight: bold;
          line-height: 50px;
          margin-left: 10px;
        }
        .avator {
          width: 50px;
          height: 50px;
          border-radius: 50%;
        }
      }
      .comment {
        margin-top: 10px;
        font-size: 14px;
        color: #888888;
      }
      .create-time {
        margin-top: 15px;
        font-size: 14px;
        color: #888888;
      }
    }
  }
}
</style>
