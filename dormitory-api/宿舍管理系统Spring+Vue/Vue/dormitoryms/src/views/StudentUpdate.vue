<template>
    <div style="margin-top: 60px;margin-left:330px;width: 300px;height: 500px;border: 0px solid red;" >
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="ID">
                <el-input v-model="ruleForm.id" readonly></el-input>
            </el-form-item>
            <el-form-item label="学号" prop="number">
                <el-input v-model="ruleForm.number"></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="gender">
                <div style="width: 170px;height: 30px;">
                    <template>
                        <el-radio v-model="ruleForm.gender" label="男">男</el-radio>
                        <el-radio v-model="ruleForm.gender" label="女">女</el-radio>
                    </template>
                </div>
            </el-form-item>
            <el-form-item label="宿舍：" prop="dormitoryName">
                <el-select @change="dormitoryName" v-model="ruleForm.dormitoryName" placeholder="请选择宿舍">
                    <el-option v-for="item in dormitoryList" :label="item.name" :value="item.name"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">立即修改</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>

</template>

<script>
import Axios from 'axios';
    export default {
        data() {
            return {
                category:null,
                ruleForm: {
                    number: '',
                    name: '',
                    gender: '男',
                    dormitoryId: '',
					dormitoryName:''
                },
                dormitoryList: '',
                rules: {
                    number: [
                        { required: true, message: '请输入学号', trigger: 'blur' }
                    ],
                    name: [
                        { required: true, message: '请输入姓名', trigger: 'blur' }
                    ],
                    gender: [
                        { required: true, message: '请输入性别', trigger: 'blur' }
                    ],
                    dormitoryId: [
                        { required: true, message: '请选择宿舍', trigger: 'change' }
                    ]
                }
            };
        },
        methods: {
			dormitoryName(){
				// console.log(this.ruleForm.dormitoryName);
				this.dormitoryList.forEach((item) => {
				    if(item.name === this.ruleForm.dormitoryName){
						this.ruleForm.dormitoryId = item.id;
					}
				})
			},
            submitForm(formName) {
                const _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.put('http://localhost:8085/student/update',_this.ruleForm).then(function (resp) {
                            if(resp.data.code == 0){
                                _this.$alert(_this.ruleForm.name+'修改成功', '', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/studentManager')
                                    }
                                });
                            }
                        })
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },
        created() {
            const _this = this;
            axios.get('http://localhost:8085/dormitory/availableList').then(function (resp) {
                _this.dormitoryList = resp.data.data
            })
            axios.get('http://localhost:8085/student/findById/'+_this.$route.query.id).then(function (resp) {
                _this.ruleForm = resp.data.data
            })
        }
    }
</script>
