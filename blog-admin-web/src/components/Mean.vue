<template>
    <el-aside class="aside">
        <div class="head">
            <div>
                <img
                    src="https://s.weituibao.com/1582958061265/mlogo.png"
                    alt="logo"
                />
                <span>blog后台管理</span>
            </div>
        </div>
        <div class="line" />
        <el-menu
            :default-openeds="state.defaultOpen"
            background-color="#222832"
            text-color="#fff"
            :router="true"
            :default-active="state.currentPath"
        >
            <el-submenu index="1">
                <template #title>
                    <span>控制台</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="/dashboard"
                        ><i class="el-icon-odometer" />控制面板</el-menu-item
                    >
                    <el-menu-item index="/mdEdit"
                        ><i class="el-icon-plus" />发布文章</el-menu-item
                    >
                </el-menu-item-group>
            </el-submenu>
            <el-submenu index="2">
                <template #title>
                    <span>首页配置</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="/swiper"
                        ><i class="el-icon-picture" />轮播图配置</el-menu-item
                    >
                    <el-menu-item index="/hot"
                        ><i class="el-icon-star-on" />热销商品配置</el-menu-item
                    >
                    <el-menu-item index="/new"
                        ><i class="el-icon-sell" />新品上线配置</el-menu-item
                    >
                    <el-menu-item index="/recommend"
                        ><i class="el-icon-thumb" />为你推荐配置</el-menu-item
                    >
                </el-menu-item-group>
            </el-submenu>
            <el-submenu index="3">
                <template #title>
                    <span>模块管理</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="/category"
                        ><i class="el-icon-menu" />分类管理</el-menu-item
                    >
                    <el-menu-item index="/posts"
                        ><i class="el-icon-s-goods" />文章管理</el-menu-item
                    >
                    <el-menu-item index="/guest"
                        ><i class="el-icon-user-solid" />会员管理</el-menu-item
                    >
                    <el-menu-item index="/order"
                        ><i class="el-icon-s-order" />订单管理</el-menu-item
                    >
                </el-menu-item-group>
            </el-submenu>
            <el-submenu index="4">
                <template #title>
                    <span>系统管理</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="/account"
                        ><i class="el-icon-lock" />修改密码</el-menu-item
                    >
                </el-menu-item-group>
            </el-submenu>
        </el-menu>
    </el-aside>
</template>


<script>
import { onUnmounted, reactive } from "vue";
import { useRouter } from "vue-router";
import { pathMap, localGet } from "@/utils";
export default {
    name: "Mean",
    setup() {
        const noMenu = ["/login"];
        const router = useRouter();
        const state = reactive({
            defaultOpen: ["1", "2", "3"], // "4"
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
.aside {
    width: 200px !important;
    background-color: #222832;
    overflow: hidden;
    overflow-y: auto;
    -ms-overflow-style: none;
    overflow: -moz-scrollbars-none;
}
.aside::-webkit-scrollbar {
    display: none;
}
.head {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 50px;
}
.head > div {
    display: flex;
    align-items: center;
}

.head img {
    width: 50px;
    height: 50px;
    margin-right: 10px;
}
.head span {
    font-size: 20px;
    color: #ffffff;
}
.line {
    border-top: 1px solid hsla(0, 0%, 100%, 0.05);
    border-bottom: 1px solid rgba(0, 0, 0, 0.2);
}
</style>
