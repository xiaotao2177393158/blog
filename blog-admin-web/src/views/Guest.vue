<template>
    <el-card class="guest-container">
        <template #header>
            <div class="header">
                <el-button
                    type="primary"
                    size="small"
                    disabled
                    icon="el-icon-plus"
                    @click="handleSolve"
                    >解除禁用</el-button
                >
                <el-button
                    type="danger"
                    size="small"
                    disabled
                    icon="el-icon-delete"
                    @click="handleForbid"
                    >禁用账户</el-button
                >
            </div>
        </template>
        <el-table
            v-loading="loading"
            ref="multipleTable"
            :data="tableData"
            tooltip-effect="dark"
            style="width: 100%"
            @selection-change="handleSelectionChange"
        >
            <el-table-column type="selection"> </el-table-column>
            <el-table-column prop="userNicename" label="昵称">
            </el-table-column>
            <el-table-column prop="username" label="登录名"> </el-table-column>
            <el-table-column prop="userEmail" label="邮箱"> </el-table-column>
            <el-table-column prop="userUrl" label="url"> </el-table-column>
            <el-table-column label="身份状态">
                <template #default="scope">
                    <span
                        :style="
                            scope.row.accountNotLocked
                                ? 'color: green;'
                                : 'color: red;'
                        "
                    >
                        {{ scope.row.accountNotLocked ? "正常" : "禁用" }}
                    </span>
                </template>
            </el-table-column>
            <el-table-column prop="userRegistered" label="注册时间">
            </el-table-column>
            <el-table-column label="操作">
                <template #default="scope">
                    <el-popconfirm
                        v-if="scope.row.accountNotLocked"
                        title="确定禁用吗？"
                        @confirm="handleForbid(scope.row)"
                    >
                        <template #reference>
                            <el-button type="danger" size="small" plain
                                >禁用账户</el-button
                            >
                        </template>
                    </el-popconfirm>
                    <el-button
                        @click="handleSolve(scope.row)"
                        type="primary"
                        size="small"
                        v-else
                        plain
                        >启用账户</el-button
                    >
                </template>
            </el-table-column>
        </el-table>
        <!--总数超过一页，再展示分页器-->
        <el-pagination
            background
            layout="prev, pager, next"
            :total="total"
            :page-size="pageSize"
            :current-page="currentPage"
            @current-change="changePage"
        />
    </el-card>
</template>

<script>
import { onMounted, reactive, ref, toRefs } from "vue";
import axios from "@/utils/axios";
import { ElMessage } from "element-plus";
export default {
    name: "Guest",
    setup() {
        const multipleTable = ref(null);
        const state = reactive({
            loading: false,
            tableData: [], // 数据列表
            multipleSelection: [], // 选中项
            total: 0, // 总条数
            currentPage: 1, // 当前页
            pageSize: 10, // 分页大小
        });
        onMounted(() => {
            getGuestList();
        });
        // 获取用户列表
        const getGuestList = () => {
            state.loading = true;
            axios
                .get(`/wpUsers/search/${state.currentPage}/${state.pageSize}`)
                .then((res) => {
                    console.log(res.data);
                    state.tableData = res.data.list;
                    state.total = res.data.total;
                    state.currentPage = res.data.pageNum;
                    state.loading = false;
                });
        };
        // 选择项
        const handleSelectionChange = (val) => {
            state.multipleSelection = val;
        };
        const changePage = (val) => {
            state.currentPage = val;
            getGuestList();
        };
        const handleSolve = () => {
            if (!state.multipleSelection.length) {
                ElMessage.error("请选择项");
                return;
            }
            let param = new URLSearchParams();
            param.append(
                "ids",
                state.multipleSelection.map((item) => item.id)
            );
            axios.put(`/wpUsers/users/0`, param).then(() => {
                ElMessage.success("解除成功");
                getGuestList();
            });
        };
        const handleForbid = () => {
            if (!state.multipleSelection.length) {
                ElMessage.error("请选择项");
                return;
            }
            let param = new URLSearchParams();
            param.append(
                "ids",
                state.multipleSelection.map((item) => item.id)
            );
            axios.put(`/wpUsers/users/1`, param).then(() => {
                ElMessage.success("禁用成功");
                getGuestList();
            });
        };
        return {
            ...toRefs(state),
            multipleTable,
            handleSelectionChange,
            getGuestList,
            changePage,
            handleSolve,
            handleForbid,
        };
    },
};
</script>

<style scoped>
.guest-container {
    min-height: 100%;
}
.el-card.is-always-shadow {
    min-height: 100% !important;
}
</style>