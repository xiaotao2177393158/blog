import { createRouter, createWebHashHistory } from "vue-router";

const router = createRouter({
  history: createWebHashHistory(), // hash模式：createWebHashHistory，history模式：createWebHistory
  routes: [
    {
      path: "/",
      redirect: "/dashboard",
    },
    {
      path: "/dashboard",
      name: "dashboard",
      component: () =>
        import(/* webpackChunkName: "dashboard" */ "../views/Index.vue"),
    },
    {
      path: "/login",
      name: "login",
      component: () =>
        import(/* webpackChunkName: "login" */ "../views/Login.vue"),
    },
    {
      path: "/register",
      name: "register",
      component: () =>
        import(/* webpackChunkName: "register" */ "../views/Register.vue"),
    },
    {
      path: "/add",
      name: "add",
      component: () => import(/* webpackChunkName: "add" */ "../views/Add.vue"),
    },
    {
      path: "/mdEdit",
      name: "mdEdit",
      component: () =>
        import(/* webpackChunkName: "add" */ "../views/PostArticle.vue"),
    },
    {
      path: "/preview",
      name: "preview",
      component: () =>
        import(/* webpackChunkName: "add" */ "../views/Preview.vue"),
    },
    {
      path: "/swiper",
      name: "swiper",
      component: () =>
        import(/* webpackChunkName: "swiper" */ "../views/Swiper.vue"),
    },
    {
      path: "/hot",
      name: "hot",
      component: () =>
        import(/* webpackChunkName: "hot" */ "../views/IndexConfig.vue"),
    },
    {
      path: "/new",
      name: "new",
      component: () =>
        import(/* webpackChunkName: "new" */ "../views/IndexConfig.vue"),
    },
    {
      path: "/recommend",
      name: "recommend",
      component: () =>
        import(/* webpackChunkName: "recommend" */ "../views/IndexConfig.vue"),
    },
    {
      path: "/category",
      name: "category",
      component: () =>
        import(/* webpackChunkName: "category" */ "../views/Category.vue"),
      children: [
        {
          path: "/category/level2",
          name: "level2",
          component: () =>
            import(/* webpackChunkName: "level2" */ "../views/Category.vue"),
        },
        {
          path: "/category/level3",
          name: "level3",
          component: () =>
            import(/* webpackChunkName: "level3" */ "../views/Category.vue"),
        },
      ],
    },
    {
      path: "/posts",
      name: "posts",
      component: () =>
        import(/* webpackChunkName: "new" */ "../views/Posts.vue"),
    },
    {
      path: "/guest",
      name: "guest",
      component: () =>
        import(/* webpackChunkName: "guest" */ "../views/Guest.vue"),
    },
    {
      path: "/order",
      name: "order",
      component: () =>
        import(/* webpackChunkName: "order" */ "../views/Order.vue"),
    },
    {
      path: "/order_detail",
      name: "order_detail",
      component: () =>
        import(
          /* webpackChunkName: "order_detail" */ "../views/OrderDetail.vue"
        ),
    },
    {
      path: "/account",
      name: "account",
      component: () =>
        import(/* webpackChunkName: "account" */ "../views/Account.vue"),
    },
  ],
});

export default router;
