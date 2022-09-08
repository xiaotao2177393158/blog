<template>
    <el-card class="good-container">
        <template #header>
            <div class="header">
                <el-button
                    type="primary"
                    size="small"
                    icon="el-icon-plus"
                    @click="handleAdd"
                    >新增商品</el-button
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
            <el-table-column type="selection" width="55"> </el-table-column>
            <el-table-column prop="id" label="编号"> </el-table-column>
            <el-table-column prop="postName" label="文章名称">
            </el-table-column>
            <el-table-column prop="postDate" label="发布时间"></el-table-column>
            <el-table-column
                prop="postModified"
                label="更新时间"
            ></el-table-column>
            <el-table-column label="状态">
                <template #default="scope">
                    <span
                        style="color: green"
                        v-if="scope.row.postStatus == 'publish'"
                        >已发布</span
                    >
                    <span
                        style="color: red"
                        v-else-if="scope.row.postStatus == 'draft'"
                        >草稿</span
                    >
                    <span style="color: gray" v-else>其他</span>
                </template>
            </el-table-column>

            <el-table-column label="操作">
                <template #default="scope">
                    <el-button
                        type="primary"
                        size="small"
                        plain
                        @click="handleEdit(scope.row.goodsId)"
                        >编辑</el-button
                    >
                    <el-button
                        type="danger"
                        size="small"
                        plain
                        v-if="scope.row.postStatus == 'publish'"
                        @click="handleStatus(scope.row.goodsId, 1)"
                        >下线</el-button
                    >
                    <el-button
                        type="primary"
                        size="small"
                        plain
                        v-else
                        @click="handleStatus(scope.row.goodsId, 0)"
                        >发布</el-button
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
import { useRouter } from "vue-router";
export default {
    name: "Good",
    setup() {
        const multipleTable = ref(null);
        const router = useRouter();
        const state = reactive({
            loading: false,
            tableData: [], // 数据列表
            multipleSelection: [], // 选中项
            total: 0, // 总条数
            currentPage: 1, // 当前页
            pageSize: 10, // 分页大小
        });
        onMounted(() => {
            getGoodList();
        });
        // 获取轮播图列表
        const getGoodList = () => {
            state.loading = true;
            axios
                .get(`/wpPosts/search/${state.currentPage}/${state.pageSize}`)
                .then((res) => {
                    console.log(res);
                    state.tableData = res.data.list;
                    state.total = res.data.total;
                    state.currentPage = res.data.pageNum;
                    state.loading = false;
                });
        };
        const handleAdd = () => {
            router.push({ path: "/add" });
        };
        const handleEdit = (id) => {
            router.push({ path: "/add", query: { id } });
        };
        // 选择项
        const handleSelectionChange = (val) => {
            state.multipleSelection = val;
        };
        const changePage = (val) => {
            state.currentPage = val;
            getGoodList();
        };
        const handleStatus = (id, status) => {
            axios
                .put(`/goods/status/${status}`, {
                    ids: id ? [id] : [],
                })
                .then(() => {
                    ElMessage.success("修改成功");
                    getGoodList();
                });
        };
        return {
            ...toRefs(state),
            multipleTable,
            handleSelectionChange,
            handleAdd,
            handleEdit,
            getGoodList,
            changePage,
            handleStatus,
        };
    },
};
</script>

<style scoped>
.good-container {
    min-height: 100%;
}
.el-card.is-always-shadow {
    min-height: 100% !important;
}
</style>