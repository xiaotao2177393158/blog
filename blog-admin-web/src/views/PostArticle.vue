<template>
    <form :model="form">
        <div class="box" style="width: 75%">
            <el-input
                type="text"
                class="box2"
                v-model="form.name"
                placeholder="添加标题"
                name=""
                id=""
            />
            <el-date-picker
                v-model="form.date"
                type="datetime"
                placeholder="发布时间"
            />
            <!-- markdown 编辑区 -->
            <mdEdit></mdEdit>
        </div>
        <div class="box box3">
            <div class="box1">
                <h4>发布</h4>
                <hr class="box5" />
                <el-form-item>
                    <el-button size="small" plain>保存草稿</el-button>
                    <el-button
                        size="small"
                        @click="preview"
                        plain
                        style="margin-left: 12vw"
                        >预览</el-button
                    >
                </el-form-item>
                <el-form-item>
                    可见性：
                    <el-radio-group v-model="form.resource">
                        <el-radio label="公开" />
                        <el-radio label="私密" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item>
                    分 类：
                    <el-select
                        v-model="value"
                        multiple
                        collapse-tags
                        collapse-tags-tooltip
                        placeholder="Select"
                        style="width: 240px"
                    >
                        <el-option
                            v-for="item in options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value"
                        />
                    </el-select>
                </el-form-item>
                <hr class="box5" />

                <el-button type="success" size="small" plain class="box4"
                    >发布</el-button
                >
            </div>
        </div>
    </form>
</template>
<script>
import { reactive, ref, toRefs } from "vue";
import axios from "@/utils/axios";
import MdEdit from "./MdEdit.vue";
export default {
    name: "postArticle",
    setup() {
        const form = reactive({
            name: "",
            region: "",
            date: "",
            date2: "",
            delivery: false,
            type: [],
            resource: "公开",
            desc: "",
        });

        const value = ref([]);

        const options = [
            {
                value: "java",
                label: "java",
            },
            {
                value: "前端",
                label: "前端",
            },
            {
                value: "数据库",
                label: "数据库",
            },
            {
                value: "算法",
                label: "算法",
            },
            {
                value: "面试题",
                label: "面试题",
            },
            {
                value: "其他",
                label: "其他",
            },
        ];

        // 预览
        const preview = () => {
            window.open("/#/preview");
        };

        return { form, options, value, preview };
    },
    components: { MdEdit },
};
</script>

<style scoped>
.box {
    display: inline-block;
    /* display: flex; */
}

.box1 {
    width: 20vw;
    box-shadow: 0px 5px 12px 0px rgba(0, 0, 0, 0.4);
    padding: 0.5vw;
    box-sizing: border-box;
}

.box2 {
    width: 50vw;
    margin: 1vw;
}

.box3 {
    margin-right: 0.5vw;
    float: right;
}

.box4 {
    border-radius: 0.7vw;
    margin-left: 16vw;
}

.box5 {
    border: 1px #ddd9d9 dashed;
}
</style>