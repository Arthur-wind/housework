import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import material_certification from '@/views/modules/material_certification/list'
    import service_project from '@/views/modules/service_project/list'
    import employer_evaluation from '@/views/modules/employer_evaluation/list'
    import consult_employee from '@/views/modules/consult_employee/list'
    import contract_signing from '@/views/modules/contract_signing/list'
    import application_appointment from '@/views/modules/application_appointment/list'
    import requirement_info from '@/views/modules/requirement_info/list'
    import project_type from '@/views/modules/project_type/list'
    import consult_employer from '@/views/modules/consult_employer/list'
    import messages from '@/views/modules/messages/list'
    import service_appointment from '@/views/modules/service_appointment/list'
    import employer from '@/views/modules/employer/list'
    import employee from '@/views/modules/employee/list'
    import electronic_signature from '@/views/modules/electronic_signature/list'
    import config from '@/views/modules/config/list'
    import service_project_comment from '@/views/modules/service_project_comment/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '网站公告',
        component: news
      }
      ,{
	path: '/material_certification',
        name: '资料认证',
        component: material_certification
      }
      ,{
	path: '/service_project',
        name: '服务项目',
        component: service_project
      }
      ,{
	path: '/employer_evaluation',
        name: '雇主评价',
        component: employer_evaluation
      }
      ,{
	path: '/consult_employee',
        name: '咨询雇员',
        component: consult_employee
      }
      ,{
	path: '/contract_signing',
        name: '签订合同',
        component: contract_signing
      }
      ,{
	path: '/application_appointment',
        name: '申请预约',
        component: application_appointment
      }
      ,{
	path: '/requirement_info',
        name: '需求信息',
        component: requirement_info
      }
      ,{
	path: '/project_type',
        name: '项目类型',
        component: project_type
      }
      ,{
	path: '/consult_employer',
        name: '咨询雇主',
        component: consult_employer
      }
      ,{
	path: '/messages',
        name: '意见反馈',
        component: messages
      }
      ,{
	path: '/service_appointment',
        name: '服务预约',
        component: service_appointment
      }
      ,{
	path: '/employer',
        name: '雇主',
        component: employer
      }
      ,{
	path: '/employee',
        name: '雇员',
        component: employee
      }
      ,{
	path: '/electronic_signature',
        name: '电子签名',
        component: electronic_signature
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/service_project_comment',
        name: '服务项目评论',
        component: service_project_comment
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
