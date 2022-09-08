import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";
import vitePluginImport from "vite-plugin-babel-import";
import path from "path";
import prismjs from "vite-plugin-prismjs";

const baseUrl = {
  development: "./",
  beta: "./",
  release: "./",
};

// https://vitejs.dev/config/
export default ({ mode }) =>
  defineConfig({
    plugins: [
      vue(),
      vitePluginImport([
        {
          libraryName: "element-plus",
          libraryDirectory: "es",
          style(name) {
            return `element-plus/lib/theme-chalk/${name}.css`;
          },
        },
      ]),
      prismjs({
        languages: ["js", "json", "java", "bash"],
      }),
    ],
    base: baseUrl[mode],
    resolve: {
      alias: {
        "~": path.resolve(__dirname, "./"),
        "@": path.resolve(__dirname, "src"),
      },
    },
    server: {
      proxy: {
        "/api": {
          // target: 'http://backend-api-02.newbee.ltd/manage-api/v1',
          target: "http://node.xiaotao.cloud",
          changeOrigin: true,
          rewrite: (path) => path.replace(/^\/api/, ""),
        },
      },
    },
  });
