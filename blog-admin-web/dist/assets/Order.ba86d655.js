var j=Object.defineProperty,M=Object.defineProperties;var L=Object.getOwnPropertyDescriptors;var I=Object.getOwnPropertySymbols;var U=Object.prototype.hasOwnProperty,q=Object.prototype.propertyIsEnumerable;var N=(e,t,i)=>t in e?j(e,t,{enumerable:!0,configurable:!0,writable:!0,value:i}):e[t]=i,P=(e,t)=>{for(var i in t||(t={}))U.call(t,i)&&N(e,i,t[i]);if(I)for(var i of I(t))q.call(t,i)&&N(e,i,t[i]);return e},V=(e,t)=>M(e,L(t));import{_ as E}from"./index.b33bcfe7.js";import{r as F,o as R,b as g,t as $,d as c,a7 as A,e as p,n as u,w as n,_,g as m,j as r,f as h,ab as G,a8 as H,h as f,a9 as J,i as K,k as v,p as Q,l as W}from"./vendor.aa159a5f.js";const X={name:"Order",setup(){const e=F({loading:!1,tableData:[],multipleSelection:[],total:0,currentPage:1,pageSize:10,orderNo:"",orderStatus:"",options:[{value:"",label:"\u5168\u90E8"},{value:0,label:"\u5F85\u652F\u4ED8"},{value:1,label:"\u5DF2\u652F\u4ED8"},{value:2,label:"\u914D\u8D27\u5B8C\u6210"},{value:3,label:"\u51FA\u5E93\u6210\u529F"},{value:4,label:"\u4EA4\u6613\u6210\u529F"},{value:-1,label:"\u624B\u52A8\u5173\u95ED"},{value:-2,label:"\u8D85\u65F6\u5173\u95ED"},{value:-3,label:"\u5546\u5BB6\u5173\u95ED"}]});R(()=>{t()});const t=()=>{e.loading=!0,g.get("/orders",{params:{pageNumber:e.currentPage,pageSize:e.pageSize,orderNo:e.orderNo,orderStatus:e.orderStatus}}).then(l=>{e.tableData=l.list,e.total=l.totalCount,e.currentPage=l.currPage,e.loading=!1})},i=()=>{e.currentPage=1,t()},d=l=>{e.multipleSelection=l},k=l=>{e.currentPage=l,t()},w=l=>{console.log("id",l);let a;if(l)a=[l];else{if(!e.multipleSelection.length){console.log("state.multipleSelection",e.multipleSelection.length),_.error("\u8BF7\u9009\u62E9\u9879");return}a=e.multipleSelection.map(s=>s.orderId)}g.put("/orders/checkDone",{ids:a}).then(()=>{_.success("\u914D\u8D27\u6210\u529F"),t()})},b=l=>{let a;if(l)a=[l];else{if(!e.multipleSelection.length){_.error("\u8BF7\u9009\u62E9\u9879");return}a=e.multipleSelection.map(s=>s.orderId)}g.put("/orders/checkOut",{ids:a}).then(()=>{_.success("\u51FA\u5E93\u6210\u529F"),t()})},S=l=>{let a;if(l)a=[l];else{if(!e.multipleSelection.length){_.error("\u8BF7\u9009\u62E9\u9879");return}a=e.multipleSelection.map(s=>s.orderId)}g.put("/orders/close",{ids:a}).then(()=>{_.success("\u5173\u95ED\u6210\u529F"),t()})};return V(P({},$(e)),{handleSelectionChange:d,getOrderList:t,changePage:k,handleOption:i,handleConfig:w,handleSend:b,handleClose:S})}},C=e=>(Q("data-v-3c1ef684"),e=e(),W(),e),Y={class:"header"},Z=v("\u914D\u8D27\u5B8C\u6210"),ee=v("\u51FA\u5E93"),te=v("\u5173\u95ED\u8BA2\u5355"),oe={key:0},le={key:1},ae={key:2},ne=C(()=>m("a",{style:{cursor:"pointer","margin-right":"10px"}},"\u914D\u8D27\u5B8C\u6210",-1)),re=C(()=>m("a",{style:{cursor:"pointer","margin-right":"10px"}},"\u51FA\u5E93",-1)),ie=C(()=>m("a",{style:{cursor:"pointer","margin-right":"10px"}},"\u5173\u95ED\u8BA2\u5355",-1)),se=v("\u8BA2\u5355\u8BE6\u60C5");function de(e,t,i,d,k,w){const b=c("el-input"),S=c("el-option"),l=c("el-select"),a=c("el-button"),s=c("el-table-column"),y=c("el-popconfirm"),O=c("router-link"),D=c("el-table"),x=c("el-pagination"),T=c("el-card"),B=A("loading");return p(),u(T,{class:"order-container"},{header:n(()=>[m("div",Y,[r(b,{style:{width:"200px","margin-right":"10px"},placeholder:"\u8BF7\u8F93\u5165\u8BA2\u5355\u53F7",modelValue:e.orderNo,"onUpdate:modelValue":t[0]||(t[0]=o=>e.orderNo=o),onChange:d.handleOption,size:"small",clearable:""},null,8,["modelValue","onChange"]),r(l,{onChange:d.handleOption,modelValue:e.orderStatus,"onUpdate:modelValue":t[1]||(t[1]=o=>e.orderStatus=o),size:"small",style:{width:"200px","margin-right":"10px"}},{default:n(()=>[(p(!0),h(H,null,G(e.options,o=>(p(),u(S,{key:o.value,label:o.label,value:o.value},null,8,["label","value"]))),128))]),_:1},8,["onChange","modelValue"]),f(' <el-button type="primary" size="small" icon="el-icon-edit">\u4FEE\u6539\u8BA2\u5355</el-button> '),r(a,{type:"primary",size:"small",icon:"el-icon-s-home",onClick:t[2]||(t[2]=o=>d.handleConfig())},{default:n(()=>[Z]),_:1}),r(a,{type:"primary",size:"small",icon:"el-icon-s-home",onClick:t[3]||(t[3]=o=>d.handleSend())},{default:n(()=>[ee]),_:1}),r(a,{type:"danger",size:"small",icon:"el-icon-delete",onClick:t[4]||(t[4]=o=>d.handleClose())},{default:n(()=>[te]),_:1})])]),default:n(()=>[J((p(),u(D,{data:e.tableData,"tooltip-effect":"dark",style:{width:"100%"},onSelectionChange:d.handleSelectionChange},{default:n(()=>[r(s,{type:"selection",width:"55"}),r(s,{prop:"orderNo",label:"\u8BA2\u5355\u53F7"}),r(s,{prop:"totalPrice",label:"\u8BA2\u5355\u603B\u4EF7"}),r(s,{prop:"orderStatus",label:"\u8BA2\u5355\u72B6\u6001"},{default:n(o=>[m("span",null,K(e.$filters.orderMap(o.row.orderStatus)),1)]),_:1}),r(s,{prop:"payType",label:"\u652F\u4ED8\u65B9\u5F0F"},{default:n(o=>[o.row.payType==1?(p(),h("span",oe,"\u5FAE\u4FE1\u652F\u4ED8")):o.row.payType==2?(p(),h("span",le,"\u652F\u4ED8\u5B9D\u652F\u4ED8")):(p(),h("span",ae,"\u672A\u652F\u4ED8"))]),_:1}),r(s,{prop:"createTime",label:"\u521B\u5EFA\u65F6\u95F4"}),r(s,{label:"\u64CD\u4F5C"},{default:n(o=>[o.row.orderStatus==1?(p(),u(y,{key:0,title:"\u786E\u5B9A\u914D\u8D27\u5B8C\u6210\u5417\uFF1F",onConfirm:z=>d.handleConfig(o.row.orderId)},{reference:n(()=>[ne]),_:2},1032,["onConfirm"])):f("v-if",!0),o.row.orderStatus==2?(p(),u(y,{key:1,title:"\u786E\u5B9A\u51FA\u5E93\u5417\uFF1F",onConfirm:z=>d.handleSend(o.row.orderId)},{reference:n(()=>[re]),_:2},1032,["onConfirm"])):f("v-if",!0),o.row.orderStatus==4||o.row.orderStatus<0?f("v-if",!0):(p(),u(y,{key:2,title:"\u786E\u5B9A\u5173\u95ED\u8BA2\u5355\u5417\uFF1F",onConfirm:z=>d.handleClose(o.row.orderId)},{reference:n(()=>[ie]),_:2},1032,["onConfirm"])),r(O,{to:{path:"/order_detail",query:{id:o.row.orderId}}},{default:n(()=>[se]),_:2},1032,["to"])]),_:1})]),_:1},8,["data","onSelectionChange"])),[[B,e.loading]]),r(x,{background:"",layout:"prev, pager, next",total:e.total,"page-size":e.pageSize,"current-page":e.currentPage,onCurrentChange:d.changePage},null,8,["total","page-size","current-page","onCurrentChange"])]),_:1})}var _e=E(X,[["render",de],["__scopeId","data-v-3c1ef684"]]);export{_e as default};