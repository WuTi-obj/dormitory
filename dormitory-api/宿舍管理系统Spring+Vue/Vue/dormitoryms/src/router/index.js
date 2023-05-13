import AbsentDormitoryRecordVue from '@/views/AbsentDormitoryRecord.vue'
import AbsentRegisterVue from '@/views/AbsentRegister.vue'
import AbsentRecordVue from '@/views/AbsentRecord.vue'
import BuildingAddVue from '@/views/BuildingAdd.vue'
import BuildingManagerVue from '@/views/BuildingManager.vue'
import BuildingUpdateVue from '@/views/BuildingUpdate.vue'
import DormitoryAdminVue from '@/views/DormitoryAdmin.vue'
import DormitoryAddVue from '@/views/DormitoryAdd.vue'
import DormitoryAdminAddVue from '@/views/DormitoryAdminAdd.vue'
import DormitoryAdminManagerVue from '@/views/DormitoryAdminManager.vue'
import DormitoryAdminUpdateVue from '@/views/DormitoryAdminUpdate.vue'
import DormitoryManagerVue from '@/views/DormitoryManager.vue'
import DormitoryUpdateVue from '@/views/DormitoryUpdate.vue'
import LoginViewVue from '@/views/LoginView.vue'
import MoveoutRegisterVue from '@/views/MoveoutRegister.vue'
import MoveRecordVue from '@/views/MoveRecord.vue'
import StudentAddVue from '@/views/StudentAdd.vue'
import StudentManagerVue from '@/views/StudentManager.vue'
import StudentUpdateVue from '@/views/StudentUpdate.vue'
import SystemAdminVue from '@/views/SystemAdmin.vue'

import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
  {
	  path:'/login',
	  name:'登录',
	  component:LoginViewVue
  },
  {
	  path:'/dormitoryAdmin',
	  name:'宿舍管理员',
	  component:DormitoryAdminVue,
	  redirect:'/absentRegister',
	  children:[
		  {
			  path:'/absentDormitoryRecord',
			  name:'缺寝记录',
			  component:AbsentDormitoryRecordVue
		  },
		  {
			  path:'/absentRegister',
			  name:'缺寝登记',
			  component:AbsentRegisterVue
		  }
	  ]
  },
  {
	  path:'/systemAdmin',
	  name:'系统管理员',
	  component:SystemAdminVue,
	  redirect:'/dormitoryAdminManager',
	  children:[
		  {
			  path:'/dormitoryAdminManager',
			  name:'宿舍管理',
			  component:DormitoryAdminManagerVue
		  },
		  {
			  path:'/dormitoryAdminAdd',
			  name:'添加宿管',
			  component:DormitoryAdminAddVue
		  },
		  {
			  path:'/dormitoryAdminUpdate',
			  name:'修改宿管',
			  component:DormitoryAdminUpdateVue
		  },
		  {
			  path:'/studentAdd',
			  name:'添加学生',
			  component:StudentAddVue
		  },
		  {
			  path:'/studentManager',
			  name:'学生管理',
			  component:StudentManagerVue
		  },
		  {
			  path:'/studentUpdate',
			  name:'修改学生',
			  component:StudentUpdateVue
		  },
		  {
			  path:'/buildingAdd',
			  name:'添加楼宇',
			  component:BuildingAddVue
		  },
		  {
			  path:'/buildingManager',
			  name:'楼宇管理',
			  component:BuildingManagerVue
		  },
		  {
			  path:'/buildingUpdate',
			  name:'修改楼宇',
			  component:BuildingUpdateVue
		  },
		  {
			  path:'/dormitoryAdd',
			  name:'添加宿舍',
			  component:DormitoryAddVue
		  },
		  {
			  path:'/dormitoryManager',
			  name:'宿舍管理',
			  component:DormitoryManagerVue
		  },
		  {
			  path:'/dormitoryUpdate',
			  name:'修改宿舍',
			  component:DormitoryUpdateVue
		  },
		  {
			  path:'/moveoutRegister',
			  name:'迁出登记',
			  component:MoveoutRegisterVue
		  },
		  {
			  path:'/moveoutRecord',
			  name:'迁出记录',
			  component:MoveRecordVue
		  },
		  {
			  path:'/absentRecord',
			  name:'缺寝记录',
			  component:AbsentRecordVue
		  }
	  ]
  }
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
