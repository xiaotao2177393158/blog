<template>
    <div id="permiss">
        <div class="box">
            <v-md-preview
                :text="text"
                ref="preview"
                @image-click="imgClick"
                id="preview"
            ></v-md-preview>
        </div>
        <div>
            <el-tree
                :data="data"
                :load="loadNode"
                lazy
                empty-text="sss"
                :props="defaultProps"
                highlight-current="true"
                accordion
                @node-click="handleNodeClick"
            />
        </div>
    </div>
</template>
<script>
import {
    defineComponent,
    onMounted,
    reactive,
    ref,
    toRefs,
    nextTick,
} from "vue";
import axios from "@/utils/axios";
export default defineComponent({
    name: "preview",
    setup() {
        //值
        const text = ref("");
        // 预览组件的引用
        const preview = ref();
        //锚点数组 所有节点
        const catalogue = ref([]);
        // h1 节点
        const catalogueH1 = ref([]);
        // 当前显示的所有节点
        const data = ref([]);

        const defaultProps = {
            children: "children",
            label: "label",
        };

        onMounted(() => {
            loadFile();
        });

        const handleNodeClick = (data) => {
            console.log(data);
        };

        // 获取接口数据
        const loadFile = async () => {
            text.value = "";
            // 从接口获取文档内容
            await axios.get(`/wpPosts/39`).then((res) => {
                console.log(res);
                text.value = res.data.postContentFiltered;

                getTitle();
            });
        };

        //图片点击
        const imgClick = (url, index) => {
            console.log(url, index);
        };

        //解析所有文本
        const getTitle = () => {
            // nextTick : 页面渲染完毕执行
            nextTick(() => {
                // preview.value = text.value;
                //获取所有的标题
                console.log("@@@@@" + preview.value);
                const anchors =
                    preview.value.$el.querySelectorAll("h1,h2,h3,h4,h5,h6");
                const titles = Array.from(anchors).filter(
                    (title) => !!title.innerText.trim()
                );
                if (!titles.length) {
                    data.value = [];
                    catalogue.value = [];
                    catalogueH1.value = [];
                    return;
                }

                const hTags = Array.from(
                    new Set(titles.map((title) => title.tagName))
                ).sort();

                //添加节点
                catalogue.value = titles.map((el) => ({
                    title: el.innerText,
                    lineIndex: el.getAttribute("data-v-md-line"),
                    indent: hTags.indexOf(el.tagName),
                }));

                // 获取 h1
                const anchorsH1 = preview.value.$el.querySelectorAll("h1");
                const titlesH1 = Array.from(anchorsH1).filter(
                    (title) => !!title.innerText.trim()
                );

                const hTagsH1 = Array.from(
                    new Set(titlesH1.map((title) => title.tagName))
                ).sort();

                data.value = titlesH1.map((el) => ({
                    label: el.innerText,
                    lineIndex: el.getAttribute("data-v-md-line"),
                    indent: hTagsH1.indexOf(el.tagName),
                }));

                catalogueH1.value = titlesH1.map((el) => ({
                    title: el.innerText,
                    lineIndex: el.getAttribute("data-v-md-line"),
                    indent: hTagsH1.indexOf(el.tagName),
                }));

                // const heading = preview.$el.querySelector(
                //     `[data-v-md-line="${lineIndex}"]`
                // );

                // if (heading) {
                //     preview.scrollToTarget({
                //         target: heading,
                //         scrollContainer: window,
                //         top: 60,
                //     });
                // }
            });
        };

        // 更新节点数据
        const loadNode = (node, resolve) => {
            let h = null; // 存放当前选中节点
            let hasChild = false; // 判断是否还有下一个节点

            h = node.data.label;
            console.log("h:" + h);

            let nextNode = null; // 存放下一个节点
            for (let i = 0; i < catalogue.value.length; i++) {
                // 如果是当前选中的节点
                console.log(catalogue.value.length);
                if (
                    catalogue.value[i].title == h &&
                    catalogue.value[i + 1].indent > catalogue.value[i].indent &&
                    h != catalogue.value[catalogue.value.length - 1].title
                ) {
                    console.log("####:" + catalogue.value[i + 1].title);

                    nextNode = catalogue.value[i + 1].title;
                    hasChild = true;
                    break;
                } else {
                    hasChild = false;
                }
            }

            let data = [];
            if (hasChild) {
                data = [
                    {
                        label: nextNode,
                    },
                ];
            } else {
                data = [];
            }

            resolve(data);
        };

        return {
            data,
            text,
            catalogue,
            catalogueH1,
            preview,
            defaultProps,
            loadNode,
            imgClick,
            handleNodeClick,
        };
    },
});
</script>
   
<style scoped>
#permiss {
    width: 70%;
    margin: auto;
}

#permiss > div {
    display: inline-block;
}

#permiss > div:nth-child(1) {
    width: 80%;
}
#permiss > div:nth-child(2) {
    width: 20%;
    float: right;
    margin-top: 5vw;
}
</style>