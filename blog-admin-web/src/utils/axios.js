import axios from "axios";
import { ElMessage } from "element-plus";
import router from "@/router/index";
import { localGet } from "./index";
import config from "~/config";

axios.defaults.baseURL = config[import.meta.env.MODE].baseUrl;
// 携带 cookie，对目前的项目没有什么作用，因为我们是 token 鉴权
axios.defaults.withCredentials = true;
// 请求头，headers 信息
axios.defaults.headers["X-Requested-With"] = "XMLHttpRequest";
// 默认 post 请求，使用 application/json 形式
axios.defaults.headers.post["Content-Type"] = "application/json";

// 不用添加 token 的请求
let noToken = ["/login", "/wpUsers/register"];

axios.interceptors.request.use((config) => {
  console.log(config);
  const isToken = noToken.indexOf(config.url) == -1 ? true : false;
  console.log("token: " + isToken);
  let token = localGet("token");
  if (token != null && isToken) {
    config.headers["UserToken"] = token;
  }
  return config;
});

// 请求拦截器，内部根据返回值，重新组装，统一管理。
axios.interceptors.response.use((res) => {
  if (typeof res.data !== "object") {
    ElMessage.error("服务端异常！");
    return Promise.reject(res);
  }

  // 登录
  let code = JSON.stringify(res.data.code);
  if (code == 208) {
    ElMessage.success(JSON.stringify(res.data.message));
    return res;
  }

  if (code == 209) {
    ElMessage.success(JSON.stringify(res.data.message));
    return res;
  }

  if (res.data.code != 200) {
    if (res.data.message) ElMessage.error(res.data.message);
    if (res.data.code == 2003) {
      ElMessage.error("密码错误！");
    }
    if (res.data.code == 419) {
      router.push({ path: "/login" });
    }
    return Promise.reject(res.data);
  }

  return res.data;
});

export default axios;
