<template>
    <v-md-editor
        v-model="text"
        height="30vw"
        :autofocus="true"
        :include-level="[1, 2, 3, 4]"
        :left-toolbar="leftBar"
        :disabled-menus="[]"
        @upload-image="handleUploadImage"
        @copy-code-success="handleCopyCodeSuccess"
    ></v-md-editor>
</template>
<script>
import { reactive, ref, toRefs } from "vue";
import axios from "@/utils/axios";
export default {
    name: "mdEdit",

    setup() {
        //左侧工具栏
        const leftBar = ref(
            "undo redo clear h bold italic strikethrough quote ul ol table hr link | emoji | image | code save"
        );

        const state = reactive({
            text: `
:grinning:

$$\sum_{i=1}^n a_i=0$$

::: tip
  dsa
:::

- [x] Task

::: align-center
  center
:::

::: align-right
  right
:::

            `,
        });
        const handleCopyCodeSuccess = (code) => {
            console.log(code);
        };

        // 图片上传
        const handleUploadImage = async (event, insertImage, files) => {
            for (let i in files) {
                // 拿到 files 之后上传到文件服务器，然后向编辑框中插入对应的内容
                const formData = new FormData();
                formData.append("file", files[i]);
                console.log(files[i]);
                //你自己的上传文件接口
                await axios.post(`/upload/img`, formData).then((res) => {
                    console.log(res);
                    insertImage({
                        url: "https://qiniu.xiaotao.cloud/" + res.data.key,
                        desc: files[i].name,
                    });
                });
            }
        };

        return {
            ...toRefs(state),
            leftBar,
            handleUploadImage,
            handleCopyCodeSuccess,
        };
    },
};
</script>