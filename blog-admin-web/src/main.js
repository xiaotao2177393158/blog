import { createApp } from "vue";
import {
  ElButton,
  ElContainer,
  ElAside,
  ElHeader,
  ElMain,
  ElFooter,
  ElMenu,
  ElSubmenu,
  ElMenuItemGroup,
  ElMenuItem,
  ElForm,
  ElFormItem,
  ElInput,
  ElPopover,
  ElTag,
  ElCard,
  ElTable,
  ElTableColumn,
  ElPagination,
  ElDialog,
  ElPopconfirm,
  ElUpload,
  ElLoading,
  ElSelect,
  ElOption,
  ElRadioGroup,
  ElRadio,
  ElCascader,
  ElCheckbox,
  ElInputNumber,
  ElDatePicker,
  ElTree,
} from "element-plus";
import * as Sentry from "@sentry/browser";
import { Integrations } from "@sentry/tracing";
import App from "./App.vue";
import router from "./router/index";

// md
import VMdEditor from "@kangc/v-md-editor/lib/codemirror-editor";
import "@kangc/v-md-editor/lib/style/codemirror-editor.css";

// 这是预览时引用的
import VMdPreview from "@kangc/v-md-editor/lib/preview";
import "@kangc/v-md-editor/lib/style/preview.css";

// 主题   markdown 解析 markdown-it
import "@kangc/v-md-editor/lib/style/base-editor.css";
import vuepressTheme from "@kangc/v-md-editor/lib/theme/vuepress.js";
import "@kangc/v-md-editor/lib/theme/style/vuepress.css";

//代码行号
import createLineNumbertPlugin from "@kangc/v-md-editor/lib/plugins/line-number/index";

// 快捷复制代码
import createCopyCodePlugin from "@kangc/v-md-editor/lib/plugins/copy-code/index";
import "@kangc/v-md-editor/lib/plugins/copy-code/copy-code.css";

// Emoji
import createEmojiPlugin from "@kangc/v-md-editor/lib/plugins/emoji/index";
import "@kangc/v-md-editor/lib/plugins/emoji/emoji.css";

// 任务列表
import createTodoListPlugin from "@kangc/v-md-editor/lib/plugins/todo-list/index";
import "@kangc/v-md-editor/lib/plugins/todo-list/todo-list.css";

// 内容定位
import createAlignPlugin from "@kangc/v-md-editor/lib/plugins/align";

// katex 公式
import createKatexPlugin from "@kangc/v-md-editor/lib/plugins/katex/cdn";

// Mermaid 流程图
import createMermaidPlugin from "@kangc/v-md-editor/lib/plugins/mermaid/cdn";
import "@kangc/v-md-editor/lib/plugins/mermaid/mermaid.css";

// 代码块解析
import Prism from "prismjs";

// codemirror 编辑器的相关资源
import Codemirror from "codemirror";

// mode
import "codemirror/mode/markdown/markdown";
import "codemirror/mode/javascript/javascript";
import "codemirror/mode/css/css";
import "codemirror/mode/htmlmixed/htmlmixed";
import "codemirror/mode/vue/vue";
// edit
import "codemirror/addon/edit/closebrackets";
import "codemirror/addon/edit/closetag";
import "codemirror/addon/edit/matchbrackets";
// placeholder
import "codemirror/addon/display/placeholder";
// active-line
import "codemirror/addon/selection/active-line";
// scrollbar
import "codemirror/addon/scroll/simplescrollbars";
import "codemirror/addon/scroll/simplescrollbars.css";
// style
import "codemirror/lib/codemirror.css";

VMdEditor.Codemirror = Codemirror;
VMdEditor.use(vuepressTheme, {
  Prism,
  extend(md) {
    // md为 markdown-it 实例，可以在此处进行修改配置,并使用 plugin 进行语法扩展
    // md.set(option).use(plugin);
  },
  config: {
    toc: {
      includeLevel: [1, 2, 3, 4],
    },
  },
});

VMdPreview.use(vuepressTheme, {
  Prism,
});

VMdEditor.use(createLineNumbertPlugin());
VMdEditor.use(createCopyCodePlugin());
VMdEditor.use(createEmojiPlugin());
VMdEditor.use(createTodoListPlugin());
VMdEditor.use(createAlignPlugin());
VMdEditor.use(createKatexPlugin());
VMdEditor.use(createMermaidPlugin());

VMdPreview.use(createLineNumbertPlugin());
VMdPreview.use(createCopyCodePlugin());
VMdPreview.use(createEmojiPlugin());
VMdPreview.use(createTodoListPlugin());
VMdPreview.use(createAlignPlugin());
VMdPreview.use(createKatexPlugin());
VMdPreview.use(createMermaidPlugin());

// 修改后的主题样式必须放在最后面
import "../theme/index.css";

const orderStatus = {
  0: "待支付",
  1: "已支付",
  2: "配货完成",
  3: "出库成功",
  4: "交易成功",
  "-1": "手动关闭",
  "-2": "超时关闭",
  "-3": "商家关闭",
};

const app = createApp(App);
// 全局过滤器
app.config.globalProperties.$filters = {
  orderMap(status) {
    return orderStatus[status] || "未知状态";
  },
  prefix(url) {
    if (url && url.startsWith("http")) {
      return url;
    } else {
      url = `https://node.xiaotao.cloud${url}`;
      return url;
    }
  },
  resetImgUrl(imgObj, imgSrc, maxErrorNum) {
    if (maxErrorNum > 0) {
      imgObj.onerror = function () {
        resetImgUrl(imgObj, imgSrc, maxErrorNum - 1);
      };
      setTimeout(function () {
        imgObj.src = imgSrc;
      }, 500);
    } else {
      imgObj.onerror = null;
      imgObj.src = imgSrc;
    }
  },
};

app.use(router);

app
  .use(VMdEditor)
  .use(VMdPreview)
  .use(ElButton)
  .use(ElContainer)
  .use(ElAside)
  .use(ElHeader)
  .use(ElMain)
  .use(ElFooter)
  .use(ElMenu)
  .use(ElSubmenu)
  .use(ElMenuItemGroup)
  .use(ElMenuItem)
  .use(ElForm)
  .use(ElFormItem)
  .use(ElInput)
  .use(ElPopover)
  .use(ElTag)
  .use(ElCard)
  .use(ElTable)
  .use(ElTableColumn)
  .use(ElPagination)
  .use(ElDialog)
  .use(ElPopconfirm)
  .use(ElUpload)
  .use(ElLoading)
  .use(ElSelect)
  .use(ElOption)
  .use(ElRadioGroup)
  .use(ElRadio)
  .use(ElCascader)
  .use(ElCheckbox)
  .use(ElTree)
  .use(ElDatePicker)
  .use(ElInputNumber);

// Sentry.init({
//   dsn: "https://f866b695d21d467ba523f1adf14e0a24@o584908.ingest.sentry.io/5737358",
//   integrations: [new Integrations.BrowserTracing()],

//   // Set tracesSampleRate to 1.0 to capture 100%
//   // of transactions for performance monitoring.
//   // We recommend adjusting this value in production
//   tracesSampleRate: 1.0,
// });

app.mount("#app");
