import Vue from 'vue'
import Router from 'vue-router'
import index from '@/components/index'
import login from '@/components/login'
import indexmain from '@/components/indexmain'
import orderQuery from '@/components/order/order_query'
import clientQuery from '@/components/client/client_query'
import clientDetail from '@/components/client/client_detail'
import transferCompany from '@/components/transfercompany/transfer_company'
import goodsQuery from '@/components/goods/goods_query'
import salesmanQuery from '@/components/salesman/salesman_query'
import taskQuery from '@/components/ordertask/task_query'
import destination from '@/components/destination/destination_query'
import employee from '@/components/employee'
import role from '@/components/role'
import system from '@/components/system'
Vue.use(Router)
export const constantRouterMap = [
  {
    path:'/login',
    name:'login',
    component:login
  },
  {
    path:'/',
    redirect:'/login',
  }
]
export default new Router({
  routes: constantRouterMap
})

export const asyncRouterMap = [
  {
    path: '/index',
    name: 'index',
    component: index,
    children:[
      {
        path: '',
        name: 'indexmain',
        component: indexmain,
        meta:{
          title:"首页",
        },
      },
      {
        path: 'orderQuery',
        name: 'orderQuery',
        component: orderQuery,
        menu:"orderQuery",
        meta:{
          title:"订单",
        },
      },
      {
        path: 'clientQuery',
        name: 'clientQuery',
        component: clientQuery,
        menu:"clientQuery",
        meta:{
          title:"客户管理",
        }
      },
      {
        path: 'clientDetail',
        name: 'clientDetail',
        component: clientDetail,
        menu:"clientDetail",
        meta:{
          title:"客户详情",
        }
      },
      {
        path: 'transferCompany',
        name: 'transferCompany',
        component: transferCompany,
        menu:"transferCompany",
        meta:{
          title:"转运公司管理",
        },
      },
      {
        path: 'goodsQuery',
        name: 'goodsQuery',
        component: goodsQuery,
        menu:"goodsQuery",
        meta:{
          title:"品类管理",
        },
      },
      {
        path: 'salesmanQuery',
        name: 'salesmanQuery',
        component: salesmanQuery,
        menu:"salesmanQuery",
        meta:{
          title:"业务员管理",
        },
      },
      {
        path: 'taskQuery',
        name: 'taskQuery',
        component: taskQuery,
        menu:"taskQuery",
        meta:{
          title:"问题单管理",
        },
      },
      {
        path: 'destination',
        name: 'destination',
        component: destination,
        menu:"destination",
        meta:{
          title:"目的地管理",
        },
      },
      {
        path:'system',
        name: 'system',
        component:system,
        redirect:"system/employee",
        meta:{
          title:"系统管理",
        },
        children:[
          {
            path: 'employee',
            name: 'employee',
            component: employee,
            menu:"employee",
            meta:{
              title:"人员管理",
              icon:"el-icon-setting"
            },
          },
          {
            path: 'role',
            name: 'role',
            component: role,
            menu:"role",
            meta:{
              title:"角色管理",
              icon:"el-icon-setting"
            },
          }
        ]
      },

    ]
  },

]



