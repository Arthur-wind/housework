const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootc90g5/",
            name: "springbootc90g5",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootc90g5/front/index.html',
            loginUrl: 'http://localhost:8080/springbootc90g5/front/pages/login/login.html'
        };
    },
    getProjectName(){
        return {
            projectName: "三元一次家政"
        } 
    }
}
export default base

// 全局基础配置。

// 提供后端基础 URL、项目名、首页链接等信息。
// 通过 get() 和 getProjectName() 方法获取这些配置，便于全局调用和修改。