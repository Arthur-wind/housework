

后端项目架构中视图功能如下：
	com
        ├── annotation    // 存放自定义注解，基本都是接口
        ├── config       // Spring MVC / MyBatis 等配置类
        ├── controller    // 处理前端请求，调用业务逻辑
        ├── dao           // 数据访问层（也可能叫 mapper 或 repository）
        ├── entity          
        │	├──model         / 表单层对象（前→后）
        │	├── view		//视图实体类（多表拼装）
        │	├── entity		// 实体类
        │	└── vo           // 展示层对象（后→前）
        ├── service       // 服务层：封装业务逻辑
        │    └── impl     // 实现
        └── Application.java // 主启动类（如果是 Spring Boot 项目）