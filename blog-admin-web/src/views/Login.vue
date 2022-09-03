<template>
    <div class="login-body">
        <div class="login-container">
            <div class="head">
                <img
                    class="logo"
                    src="https://s.weituibao.com/1582958061265/mlogo.png"
                />
                <div class="name">
                    <div class="title">博客系统</div>
                    <div class="tips">Vue3.0 后台管理系统</div>
                </div>
            </div>
            <el-form
                label-position="top"
                :rules="rules"
                :model="ruleForm"
                ref="loginForm"
                class="login-form"
            >
                <el-form-item label="账号" prop="username">
                    <el-input
                        type="text"
                        v-model.trim="ruleForm.username"
                        autocomplete="off"
                    ></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input
                        type="password"
                        v-model.trim="ruleForm.password"
                        autocomplete="off"
                        @keyup.enter="submitForm"
                    ></el-input>
                </el-form-item>
                <el-form-item>
                    <div style="color: #333">
                        登录表示您已同意<a>《服务条款》</a>
                    </div>
                    <el-button
                        style="width: 100%"
                        type="primary"
                        @click="submitForm"
                        >立即登录</el-button
                    >
                    <el-checkbox v-model="checked" @change="!checked"
                        >下次自动登录</el-checkbox
                    >
                    <a href="/#/register">去注册</a>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
import axios from "@/utils/axios";
import md5 from "js-md5";
import { reactive, ref, toRefs } from "vue";
import { localSet } from "@/utils";
export default {
    name: "Login",
    setup() {
        const loginForm = ref(null);
        const state = reactive({
            ruleForm: {
                username: "",
                password: "",
            },
            checked: true,
            rules: {
                username: [
                    {
                        required: "true",
                        message: "账户不能为空",
                        trigger: "blur",
                    },
                ],
                password: [
                    {
                        required: "true",
                        message: "密码不能为空",
                        trigger: "blur",
                    },
                ],
            },
        });
        const submitForm = () => {
            loginForm.value.validate((valid) => {
                if (valid) {
                    let param = new URLSearchParams();
                    param.append("username", state.ruleForm.username);
                    param.append("password", state.ruleForm.password);
                    axios.post("/login", param).then((res) => {
                        localSet("token", res);
                        window.location.href = "/";
                    });
                } else {
                    console.log("error submit!!");
                    return false;
                }
            });
        };
        const resetForm = () => {
            loginForm.value.resetFields();
        };
        return {
            ...toRefs(state),
            loginForm,
            submitForm,
            resetForm,
        };
    },
};
</script>

<style scoped>
.login-body {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    background: url("https://img.xiaotao.cloud/pc.php") no-repeat;
    background-size: 100% 100%;
    background-attachment: fixed;
}
.login-container {
    width: 420px;
    height: 500px;
    border-radius: 1vw;
    box-shadow: 0px 21px 41px 0px rgba(0, 0, 0, 0.9);
}
.head {
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 40px 0 20px 0;
}
.head img {
    width: 100px;
    height: 100px;
    margin-right: 20px;
}
.head .title {
    font-size: 28px;
    color: #1baeae;
    font-weight: bold;
}
.head .tips {
    font-size: 12px;
    color: #999;
}
.login-form {
    width: 70%;
    margin: 0 auto;
}
</style>
<style>
.el-form--label-top .el-form-item__label {
    padding: 0;
}
.login-form .el-form-item {
    margin-bottom: 12px;
}
</style>