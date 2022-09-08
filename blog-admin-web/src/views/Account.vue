<template>
    <el-card class="account-container">
        <el-form
            :model="nameForm"
            :rules="rules"
            ref="nameRef"
            label-width="80px"
            label-position="right"
            class="demo-ruleForm"
        >
            <el-form-item label="登录名：" prop="loginName">
                <el-input
                    style="width: 200px"
                    v-model="nameForm.loginName"
                    disabled
                ></el-input>
            </el-form-item>
            <el-form-item label="昵称：" prop="nickName">
                <el-input
                    style="width: 200px"
                    v-model="nameForm.nickName"
                ></el-input>
            </el-form-item>
            <el-form-item label="邮箱：" prop="userEmail">
                <el-input
                    style="width: 200px"
                    v-model="nameForm.email"
                ></el-input>
            </el-form-item>
            <el-form-item label="url：" prop="url">
                <el-input
                    style="width: 200px"
                    v-model="nameForm.url"
                ></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="danger" @click="submitName"
                    >确认修改</el-button
                >
            </el-form-item>
        </el-form>
    </el-card>
    <el-card class="account-container">
        <el-form
            :model="passForm"
            :rules="rules"
            ref="passRef"
            label-width="80px"
            label-position="right"
            class="demo-ruleForm"
        >
            <el-form-item label="原密码：" prop="oldpass">
                <el-input
                    type="password"
                    style="width: 200px"
                    v-model="passForm.oldpass"
                ></el-input>
            </el-form-item>
            <el-form-item label="新密码：" prop="newpass">
                <el-input
                    type="password"
                    style="width: 200px"
                    v-model="passForm.newpass"
                ></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="danger" @click="submitPass"
                    >确认修改</el-button
                >
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
import { onMounted, reactive, ref, toRefs } from "vue";
import axios from "@/utils/axios";
import { ElMessage } from "element-plus";
import { localRemove } from "@/utils";
import md5 from "js-md5";
export default {
    name: "Account",
    setup() {
        const nameRef = ref(null);
        const passRef = ref(null);
        const state = reactive({
            user: null,
            nameForm: {
                loginName: "",
                nickName: "",
                email: "",
                url: "",
            },
            passForm: {
                oldpass: "",
                newpass: "",
            },
            rules: {
                loginName: [
                    {
                        required: "true",
                        message: "登录名不能为空",
                        trigger: ["change"],
                    },
                ],
                nickName: [
                    {
                        required: "true",
                        message: "昵称不能为空",
                        trigger: ["change"],
                    },
                ],
                oldpass: [
                    {
                        required: "true",
                        message: "原密码不能为空",
                        trigger: ["change"],
                    },
                ],
                newpass: [
                    {
                        required: "true",
                        message: "新密码不能为空",
                        trigger: ["change"],
                    },
                ],
            },
        });
        onMounted(() => {
            getUserInfo();
        });
        const getUserInfo = async () => {
            axios.get(`/wpUsers/getUserInfo`).then((res) => {
                console.log(res.data);
                state.user = res.data;
                state.nameForm.loginName = res.data.username;
                state.nameForm.nickName = res.data.userNicename;
                state.nameForm.email = res.data.userEmail;
                state.nameForm.url = res.data.userUrl;
            });
        };
        const submitName = () => {
            nameRef.value.validate((vaild) => {
                if (vaild) {
                    axios
                        .put(`/wpUsers/one/${state.user.id}`, {
                            username: state.nameForm.loginName,
                            userNicename: state.nameForm.nickName,
                            userEmail: state.nameForm.email,
                            userUrl: state.nameForm.url,
                        })
                        .then(() => {
                            ElMessage.success("修改成功");
                            window.location.reload();
                        });
                }
            });
        };
        const submitPass = () => {
            passRef.value.validate((vaild) => {
                if (vaild) {
                    axios
                        .put(
                            `/wpUsers/password/${state.user.id}/${md5(
                                state.passForm.oldpass
                            )}/${md5(state.passForm.newpass)}`
                        )
                        .then(() => {
                            ElMessage.success("密码修改成功");
                            localRemove("token");
                            window.location.reload();
                        });
                }
            });
        };
        return {
            ...toRefs(state),
            nameRef,
            passRef,
            submitName,
            submitPass,
        };
    },
};
</script>

<style>
.account-container {
    margin-bottom: 20px;
}
</style>