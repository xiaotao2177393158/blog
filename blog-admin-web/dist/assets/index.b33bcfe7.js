var G=Object.defineProperty,q=Object.defineProperties;var W=Object.getOwnPropertyDescriptors;var $=Object.getOwnPropertySymbols;var z=Object.prototype.hasOwnProperty,J=Object.prototype.propertyIsEnumerable;var A=(e,t,n)=>t in e?G(e,t,{enumerable:!0,configurable:!0,writable:!0,value:n}):e[t]=n,C=(e,t)=>{for(var n in t||(t={}))z.call(t,n)&&A(e,n,t[n]);if($)for(var n of $(t))J.call(t,n)&&A(e,n,t[n]);return e},R=(e,t)=>q(e,W(t));import{c as X,a as K,b as f,_ as L,u as F,r as O,o as Q,t as Y,d as p,e as v,f as g,g as o,h as Z,i as b,j as l,w as r,k as _,p as w,l as E,m as ee,n as T,q as te,s as oe,v as ne,x as ae,y as se,z as re,A as le,B as ie,C as de,D as ce,E as ue,F as _e,G as pe,H as me,I as he,J as fe,K as ve,L as ge,M as be,N as Ie,O as ye,P as we,Q as Ee,R as ke,S as xe,T as Pe,U as $e,V as Ae,W as Ce,X as Re,Y as Le,Z as Fe,$ as Oe}from"./vendor.aa159a5f.js";const Te=function(){const t=document.createElement("link").relList;if(t&&t.supports&&t.supports("modulepreload"))return;for(const a of document.querySelectorAll('link[rel="modulepreload"]'))d(a);new MutationObserver(a=>{for(const i of a)if(i.type==="childList")for(const s of i.addedNodes)s.tagName==="LINK"&&s.rel==="modulepreload"&&d(s)}).observe(document,{childList:!0,subtree:!0});function n(a){const i={};return a.integrity&&(i.integrity=a.integrity),a.referrerpolicy&&(i.referrerPolicy=a.referrerpolicy),a.crossorigin==="use-credentials"?i.credentials="include":a.crossorigin==="anonymous"?i.credentials="omit":i.credentials="same-origin",i}function d(a){if(a.ep)return;a.ep=!0;const i=n(a);fetch(a.href,i)}};Te();const Se="modulepreload",S={},De="./",u=function(t,n){return!n||n.length===0?t():Promise.all(n.map(d=>{if(d=`${De}${d}`,d in S)return;S[d]=!0;const a=d.endsWith(".css"),i=a?'[rel="stylesheet"]':"";if(document.querySelector(`link[href="${d}"]${i}`))return;const s=document.createElement("link");if(s.rel=a?"stylesheet":Se,a||(s.as="script",s.crossOrigin=""),s.href=d,document.head.appendChild(s),a)return new Promise((m,h)=>{s.addEventListener("load",m),s.addEventListener("error",h)})})).then(()=>t())},D=X({history:K(),routes:[{path:"/",redirect:"/introduce"},{path:"/introduce",name:"introduce",component:()=>u(()=>import("./Introduce.e0006843.js"),["assets/Introduce.e0006843.js","assets/Introduce.934b2ec9.css","assets/vendor.aa159a5f.js"])},{path:"/dashboard",name:"dashboard",component:()=>u(()=>import("./Index.9197bcb5.js"),["assets/Index.9197bcb5.js","assets/Index.56967ad0.css","assets/vendor.aa159a5f.js"])},{path:"/login",name:"login",component:()=>u(()=>import("./Login.9a5027ea.js"),["assets/Login.9a5027ea.js","assets/Login.f36ba2f7.css","assets/md5.1e72650a.js","assets/vendor.aa159a5f.js"])},{path:"/add",name:"add",component:()=>u(()=>import("./AddGood.bb1c5a0c.js"),["assets/AddGood.bb1c5a0c.js","assets/AddGood.60b5558b.css","assets/vendor.aa159a5f.js"])},{path:"/swiper",name:"swiper",component:()=>u(()=>import("./Swiper.ddcbb4cb.js"),["assets/Swiper.ddcbb4cb.js","assets/Swiper.39fbf7df.css","assets/vendor.aa159a5f.js"])},{path:"/hot",name:"hot",component:()=>u(()=>import("./IndexConfig.11081b6a.js"),["assets/IndexConfig.11081b6a.js","assets/IndexConfig.d98592e8.css","assets/vendor.aa159a5f.js"])},{path:"/new",name:"new",component:()=>u(()=>import("./IndexConfig.11081b6a.js"),["assets/IndexConfig.11081b6a.js","assets/IndexConfig.d98592e8.css","assets/vendor.aa159a5f.js"])},{path:"/recommend",name:"recommend",component:()=>u(()=>import("./IndexConfig.11081b6a.js"),["assets/IndexConfig.11081b6a.js","assets/IndexConfig.d98592e8.css","assets/vendor.aa159a5f.js"])},{path:"/category",name:"category",component:()=>u(()=>import("./Category.590e430f.js"),["assets/Category.590e430f.js","assets/Category.d67a46bd.css","assets/vendor.aa159a5f.js"]),children:[{path:"/category/level2",name:"level2",component:()=>u(()=>import("./Category.590e430f.js"),["assets/Category.590e430f.js","assets/Category.d67a46bd.css","assets/vendor.aa159a5f.js"])},{path:"/category/level3",name:"level3",component:()=>u(()=>import("./Category.590e430f.js"),["assets/Category.590e430f.js","assets/Category.d67a46bd.css","assets/vendor.aa159a5f.js"])}]},{path:"/good",name:"good",component:()=>u(()=>import("./Good.cf52cadb.js"),["assets/Good.cf52cadb.js","assets/Good.9382dc10.css","assets/vendor.aa159a5f.js"])},{path:"/guest",name:"guest",component:()=>u(()=>import("./Guest.52a887d4.js"),["assets/Guest.52a887d4.js","assets/Guest.7b27e8c3.css","assets/vendor.aa159a5f.js"])},{path:"/order",name:"order",component:()=>u(()=>import("./Order.ba86d655.js"),["assets/Order.ba86d655.js","assets/Order.40c28510.css","assets/vendor.aa159a5f.js"])},{path:"/order_detail",name:"order_detail",component:()=>u(()=>import("./OrderDetail.75650467.js"),["assets/OrderDetail.75650467.js","assets/OrderDetail.24d3df79.css","assets/vendor.aa159a5f.js"])},{path:"/account",name:"account",component:()=>u(()=>import("./Account.f7f72706.js"),["assets/Account.f7f72706.js","assets/Account.8f24bcfb.css","assets/vendor.aa159a5f.js","assets/md5.1e72650a.js"])}]});function k(e){const t=window.localStorage.getItem(e);try{return JSON.parse(window.localStorage.getItem(e))}catch{return t}}function Bt(e,t){window.localStorage.setItem(e,JSON.stringify(t))}function Ve(e){window.localStorage.removeItem(e)}function Ht(e=""){const t=/[^\u0020-\u007E\u00A0-\u00BE\u2E80-\uA4CF\uF900-\uFAFF\uFE30-\uFE4F\uFF00-\uFFEF\u0080-\u009F\u2000-\u201f\u2026\u2022\u20ac\r\n]/g;return e.match(t)&&e.match(t).length}const Gt="http://backend-api-02.newbee.ltd/manage-api/v1/upload/file",qt="http://backend-api-02.newbee.ltd/manage-api/v1/upload/files",V={login:"\u767B\u5F55",introduce:"\u7CFB\u7EDF\u4ECB\u7ECD",dashboard:"\u5927\u76D8\u6570\u636E",add:"\u6DFB\u52A0\u5546\u54C1",swiper:"\u8F6E\u64AD\u56FE\u914D\u7F6E",hot:"\u70ED\u9500\u5546\u54C1\u914D\u7F6E",new:"\u65B0\u54C1\u4E0A\u7EBF\u914D\u7F6E",recommend:"\u4E3A\u4F60\u63A8\u8350\u914D\u7F6E",category:"\u5206\u7C7B\u7BA1\u7406",level2:"\u5206\u7C7B\u4E8C\u7EA7\u7BA1\u7406",level3:"\u5206\u7C7B\u4E09\u7EA7\u7BA1\u7406",good:"\u5546\u54C1\u7BA1\u7406",guest:"\u4F1A\u5458\u7BA1\u7406",order:"\u8BA2\u5355\u7BA1\u7406",order_detail:"\u8BA2\u5355\u8BE6\u60C5",account:"\u4FEE\u6539\u8D26\u6237"};var Me={development:{baseUrl:"/api"},beta:{baseUrl:"//node.xiaotao.cloud"},release:{baseUrl:"//node.xiaotao.cloud"}};f.defaults.baseURL=Me.release.baseUrl;f.defaults.withCredentials=!0;f.defaults.headers["X-Requested-With"]="XMLHttpRequest";f.defaults.headers.token=k("token")||"";f.defaults.headers.post["Content-Type"]="application/json";f.interceptors.response.use(e=>typeof e.data!="object"?(L.error("\u670D\u52A1\u7AEF\u5F02\u5E38\uFF01"),Promise.reject(e)):e.data.resultCode!=200?(e.data.message&&L.error(e.data.message),e.data.resultCode==419&&D.push({path:"/login"}),Promise.reject(e.data)):e.data.data);var x=(e,t)=>{const n=e.__vccOpts||e;for(const[d,a]of t)n[d]=a;return n};const je={name:"Header",setup(){const e=F(),t=O({name:"dashboard",userInfo:null,hasBack:!1});Q(()=>{const i=window.location.hash.split("/")[1]||"";["login"].includes(i)||n()});const n=async()=>{const i=await f.get("/adminUser/profile");t.userInfo=i},d=()=>{f.delete("/logout").then(()=>{Ve("token"),window.location.reload()})},a=()=>{e.back()};return e.afterEach(i=>{console.log("to",i);const{id:s}=i.query;t.name=V[i.name],s&&i.name=="add"&&(t.name="\u7F16\u8F91\u5546\u54C1"),t.hasBack=["level2","level3","order_detail"].includes(i.name)}),R(C({},Y(t)),{logout:d,back:a})}},M=e=>(w("data-v-61dd7a3d"),e=e(),E(),e),Ue={class:"header"},Ne={class:"left"},Be={style:{"font-size":"20px"}},He={class:"right"},Ge={class:"author"},qe=M(()=>o("i",{class:"icon el-icon-s-custom"},null,-1)),We=M(()=>o("i",{class:"el-icon-caret-bottom"},null,-1)),ze={class:"nickname"},Je=_("\u9000\u51FA");function Xe(e,t,n,d,a,i){const s=p("el-tag"),m=p("el-popover");return v(),g("div",Ue,[o("div",Ne,[e.hasBack?(v(),g("i",{key:0,class:"el-icon-back",onClick:t[0]||(t[0]=(...h)=>d.back&&d.back(...h))})):Z("v-if",!0),o("span",Be,b(e.name),1)]),o("div",He,[l(m,{placement:"bottom",width:320,trigger:"click","popper-class":"popper-user-box"},{reference:r(()=>[o("div",Ge,[qe,_(" "+b(e.userInfo&&e.userInfo.nickName||"")+" ",1),We])]),default:r(()=>[o("div",ze,[o("p",null,"\u767B\u5F55\u540D\uFF1A"+b(e.userInfo&&e.userInfo.loginUserName||""),1),o("p",null,"\u6635\u79F0\uFF1A"+b(e.userInfo&&e.userInfo.nickName||""),1),l(s,{size:"small",effect:"dark",class:"logout",onClick:d.logout},{default:r(()=>[Je]),_:1},8,["onClick"])])]),_:1})])])}var Ke=x(je,[["render",Xe],["__scopeId","data-v-61dd7a3d"]]);const Qe={name:"Footer"},j=e=>(w("data-v-40ab164b"),e=e(),E(),e),Ye={class:"footer"},Ze=j(()=>o("div",{class:"left"},"Copyright \xA9 2019-2021 \u5341\u4E09. All rights reserved.",-1)),et=j(()=>o("div",{class:"right"},[o("a",{target:"_blank",href:"https://github.com/newbee-ltd/vue3-admin"},"vue3-admin Version 3.0.0")],-1)),tt=[Ze,et];function ot(e,t,n,d,a,i){return v(),g("div",Ye,tt)}var nt=x(Qe,[["render",ot],["__scopeId","data-v-40ab164b"]]);const at={name:"App",components:{Header:Ke,Footer:nt},setup(){console.log("App");const e=["/login"],t=F(),n=O({defaultOpen:["1","2","3","4"],showMenu:!0,currentPath:"/dashboard",count:{number:1}});window.history&&window.history.pushState&&(history.pushState(null,null,document.URL),window.addEventListener("popstate",()=>{k("token")||(n.showMenu=!1)},!1));const d=t.beforeEach((a,i,s)=>{a.path=="/login"||k("token")?s():s({path:"/login"}),n.showMenu=!e.includes(a.path),n.currentPath=a.path,document.title=V[a.name]});return ee(()=>{d()}),{state:n}}},c=e=>(w("data-v-7ba5bd90"),e=e(),E(),e),st={class:"layout"},rt=c(()=>o("div",{class:"head"},[o("div",null,[o("img",{src:"https://s.weituibao.com/1582958061265/mlogo.png",alt:"logo"}),o("span",null,"vue3 admin")])],-1)),lt=c(()=>o("div",{class:"line"},null,-1)),it=c(()=>o("span",null,"Dashboard",-1)),dt=c(()=>o("i",{class:"el-icon-data-line"},null,-1)),ct=_("\u7CFB\u7EDF\u4ECB\u7ECD"),ut=c(()=>o("i",{class:"el-icon-odometer"},null,-1)),_t=_("Dashboard"),pt=c(()=>o("i",{class:"el-icon-plus"},null,-1)),mt=_("\u6DFB\u52A0\u5546\u54C1"),ht=c(()=>o("span",null,"\u9996\u9875\u914D\u7F6E",-1)),ft=c(()=>o("i",{class:"el-icon-picture"},null,-1)),vt=_("\u8F6E\u64AD\u56FE\u914D\u7F6E"),gt=c(()=>o("i",{class:"el-icon-star-on"},null,-1)),bt=_("\u70ED\u9500\u5546\u54C1\u914D\u7F6E"),It=c(()=>o("i",{class:"el-icon-sell"},null,-1)),yt=_("\u65B0\u54C1\u4E0A\u7EBF\u914D\u7F6E"),wt=c(()=>o("i",{class:"el-icon-thumb"},null,-1)),Et=_("\u4E3A\u4F60\u63A8\u8350\u914D\u7F6E"),kt=c(()=>o("span",null,"\u6A21\u5757\u7BA1\u7406",-1)),xt=c(()=>o("i",{class:"el-icon-menu"},null,-1)),Pt=_("\u5206\u7C7B\u7BA1\u7406"),$t=c(()=>o("i",{class:"el-icon-s-goods"},null,-1)),At=_("\u5546\u54C1\u7BA1\u7406"),Ct=c(()=>o("i",{class:"el-icon-user-solid"},null,-1)),Rt=_("\u4F1A\u5458\u7BA1\u7406"),Lt=c(()=>o("i",{class:"el-icon-s-order"},null,-1)),Ft=_("\u8BA2\u5355\u7BA1\u7406"),Ot=c(()=>o("span",null,"\u7CFB\u7EDF\u7BA1\u7406",-1)),Tt=c(()=>o("i",{class:"el-icon-lock"},null,-1)),St=_("\u4FEE\u6539\u5BC6\u7801"),Dt={class:"main"};function Vt(e,t,n,d,a,i){const s=p("el-menu-item"),m=p("el-menu-item-group"),h=p("el-submenu"),U=p("el-menu"),N=p("el-aside"),B=p("Header"),P=p("router-view"),H=p("Footer"),y=p("el-container");return v(),g("div",st,[d.state.showMenu?(v(),T(y,{key:0,class:"container"},{default:r(()=>[l(N,{class:"aside"},{default:r(()=>[rt,lt,l(U,{"default-openeds":d.state.defaultOpen,"background-color":"#222832","text-color":"#fff",router:!0,"default-active":d.state.currentPath},{default:r(()=>[l(h,{index:"1"},{title:r(()=>[it]),default:r(()=>[l(m,null,{default:r(()=>[l(s,{index:"/introduce"},{default:r(()=>[dt,ct]),_:1}),l(s,{index:"/dashboard"},{default:r(()=>[ut,_t]),_:1}),l(s,{index:"/add"},{default:r(()=>[pt,mt]),_:1})]),_:1})]),_:1}),l(h,{index:"2"},{title:r(()=>[ht]),default:r(()=>[l(m,null,{default:r(()=>[l(s,{index:"/swiper"},{default:r(()=>[ft,vt]),_:1}),l(s,{index:"/hot"},{default:r(()=>[gt,bt]),_:1}),l(s,{index:"/new"},{default:r(()=>[It,yt]),_:1}),l(s,{index:"/recommend"},{default:r(()=>[wt,Et]),_:1})]),_:1})]),_:1}),l(h,{index:"3"},{title:r(()=>[kt]),default:r(()=>[l(m,null,{default:r(()=>[l(s,{index:"/category"},{default:r(()=>[xt,Pt]),_:1}),l(s,{index:"/good"},{default:r(()=>[$t,At]),_:1}),l(s,{index:"/guest"},{default:r(()=>[Ct,Rt]),_:1}),l(s,{index:"/order"},{default:r(()=>[Lt,Ft]),_:1})]),_:1})]),_:1}),l(h,{index:"4"},{title:r(()=>[Ot]),default:r(()=>[l(m,null,{default:r(()=>[l(s,{index:"/account"},{default:r(()=>[Tt,St]),_:1})]),_:1})]),_:1})]),_:1},8,["default-openeds","default-active"])]),_:1}),l(y,{class:"content"},{default:r(()=>[l(B),o("div",Dt,[l(P)]),l(H)]),_:1})]),_:1})):(v(),T(y,{key:1,class:"container"},{default:r(()=>[l(P)]),_:1}))])}var Mt=x(at,[["render",Vt],["__scopeId","data-v-7ba5bd90"]]);const jt={0:"\u5F85\u652F\u4ED8",1:"\u5DF2\u652F\u4ED8",2:"\u914D\u8D27\u5B8C\u6210",3:"\u51FA\u5E93\u6210\u529F",4:"\u4EA4\u6613\u6210\u529F","-1":"\u624B\u52A8\u5173\u95ED","-2":"\u8D85\u65F6\u5173\u95ED","-3":"\u5546\u5BB6\u5173\u95ED"},I=te(Mt);I.config.globalProperties.$filters={orderMap(e){return jt[e]||"\u672A\u77E5\u72B6\u6001"},prefix(e){return e&&e.startsWith("http")||(e=`http://node.xiaotao.cloud${e}`),e},resetImgUrl(e,t,n){n>0?(e.onerror=function(){resetImgUrl(e,t,n-1)},setTimeout(function(){e.src=t},500)):(e.onerror=null,e.src=t)}};I.use(D);I.use(oe).use(ne).use(ae).use(se).use(re).use(le).use(ie).use(de).use(ce).use(ue).use(_e).use(pe).use(me).use(he).use(fe).use(ve).use(ge).use(be).use(Ie).use(ye).use(we).use(Ee).use(ke).use(xe).use(Pe).use($e).use(Ae).use(Ce).use(Re).use(Le);Fe({dsn:"https://f866b695d21d467ba523f1adf14e0a24@o584908.ingest.sentry.io/5737358",integrations:[new Oe],tracesSampleRate:1});I.mount("#app");export{x as _,k as a,qt as b,Ht as h,Bt as l,Gt as u};