<template>
    <div class="layout">
        <el-container v-if="state.showMenu" class="container">
            <Mean />
            <el-container class="content">
                <Header />
                <div class="main">
                    <router-view />
                </div>
                <Footer />
            </el-container>
        </el-container>
        <el-container v-else class="container">
            <router-view />
        </el-container>
    </div>
</template>

<script>
import { onUnmounted, reactive } from "vue";
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import Mean from "@/components/Mean.vue";
import { useRouter } from "vue-router";
import { pathMap, localGet } from "@/utils";
export default {
    name: "App",
    components: {
        Header,
        Footer,
        Mean,
    },
    setup() {
        console.log("App");
        const noMenu = ["/login", "/register"];
        const router = useRouter();
        const state = reactive({
            defaultOpen: ["1", "2", "3", "4"],
            showMenu: true,
            currentPath: "/dashboard",
            count: {
                number: 1,
            },
        });
        // 监听浏览器原生回退事件
        if (window.history && window.history.pushState) {
            history.pushState(null, null, document.URL);
            window.addEventListener(
                "popstate",
                () => {
                    if (!localGet("token")) {
                        state.showMenu = false;
                    }
                },
                false
            );
        }
        const unwatch = router.beforeEach((to, from, next) => {
            if (to.path == "/login") {
                // 如果路径是 /login 则正常执行
                next();
            } else if (to.path == "/register") {
                // 如果路径是 /login 则正常执行
                next();
            } else {
                // 如果不是 /login，判断是否有 token
                if (!localGet("token")) {
                    // 如果没有，则跳至登录页面
                    next({ path: "/login" });
                } else {
                    // 否则继续执行
                    next();
                }
            }
            state.showMenu = !noMenu.includes(to.path);
            state.currentPath = to.path;
            document.title = pathMap[to.name];
        });

        onUnmounted(() => {
            unwatch();
        });

        return {
            state,
        };
    },
};
</script>

<style scoped>
.layout {
    min-height: 100vh;
    background-color: #ffffff;
}
.container {
    height: 100vh;
}

.content {
    display: flex;
    flex-direction: column;
    max-height: 100vh;
    overflow: hidden;
}
.main {
    height: calc(100vh - 100px);
    overflow: auto;
    padding: 10px;
}
</style>

<style>
body {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}
.el-menu {
    border-right: none !important;
}
.el-submenu {
    border-top: 1px solid hsla(0, 0%, 100%, 0.05);
    border-bottom: 1px solid rgba(0, 0, 0, 0.2);
}
.el-submenu:first-child {
    border-top: none;
}
.el-submenu [class^="el-icon-"] {
    vertical-align: -1px !important;
}
a {
    color: #409eff;
    text-decoration: none;
}
.el-pagination {
    text-align: center;
    margin-top: 20px;
}
.el-popper__arrow {
    display: none;
}
</style>
