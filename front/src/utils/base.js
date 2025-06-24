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
