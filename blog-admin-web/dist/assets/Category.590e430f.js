var A=Object.defineProperty,q=Object.defineProperties;var E=Object.getOwnPropertyDescriptors;var V=Object.getOwnPropertySymbols;var j=Object.prototype.hasOwnProperty,B=Object.prototype.propertyIsEnumerable;var N=(e,a,r)=>a in e?A(e,a,{enumerable:!0,configurable:!0,writable:!0,value:r}):e[a]=r,I=(e,a)=>{for(var r in a||(a={}))j.call(a,r)&&N(e,r,a[r]);if(V)for(var r of V(a))B.call(a,r)&&N(e,r,a[r]);return e},S=(e,a)=>q(e,E(a));import{_ as L,h as T}from"./index.b33bcfe7.js";import{a0 as w,a5 as R,r as z,t as P,d as m,e as D,n as $,w as s,g as v,j as l,_ as f,b as y,k as b,u as U,o as G,m as M,a7 as O,f as x,a8 as H,a9 as J,p as K,l as Q}from"./vendor.aa159a5f.js";const W={name:"DialogAddCategory",props:{type:String,reload:Function},setup(e){const a=w(null),r=R(),t=z({visible:!1,categoryLevel:1,parentId:0,ruleForm:{name:"",rank:""},rules:{name:[{required:"true",message:"\u540D\u79F0\u4E0D\u80FD\u4E3A\u7A7A",trigger:["change"]}],rank:[{required:"true",message:"\u6392\u5E8F\u503C\u4E0D\u80FD\u4E3A\u7A7A",trigger:["change"]}]},id:""}),n=d=>{y.get(`/categories/${d}`).then(c=>{t.ruleForm={name:c.categoryName,rank:c.categoryRank},t.parentId=c.parentId,t.categoryLevel=c.categoryLevel})},h=d=>{if(t.visible=!0,d)t.id=d,n(d);else{const{level:c=1,parent_id:u=0}=r.query;t.ruleForm={name:"",rank:""},t.parentId=u,t.categoryLevel=c}},i=()=>{t.visible=!1},g=()=>{a.value.resetFields()},p=()=>{a.value.validate(d=>{if(d){if(T(t.ruleForm.name)){f.error("\u4E0D\u8981\u8F93\u5165\u8868\u60C5\u5305\uFF0C\u518D\u8F93\u5165\u5C31\u6253\u6B7B\u4F60\u4E2A\u9F9F\u5B59\u513F~");return}if(t.ruleForm.name.length>16){f.error("\u540D\u79F0\u4E0D\u80FD\u8D85\u8FC716\u4E2A\u5B57\u7B26");return}if(t.ruleForm.rank>200){f.error("\u6392\u5E8F\u4E0D\u80FD\u8D85\u8FC7200");return}e.type=="add"?y.post("/categories",{categoryLevel:t.categoryLevel,parentId:t.parentId,categoryName:t.ruleForm.name,categoryRank:t.ruleForm.rank}).then(()=>{f.success("\u6DFB\u52A0\u6210\u529F"),t.visible=!1,e.reload&&e.reload()}):y.put("/categories",{categoryId:t.id,categoryLevel:t.categoryLevel,parentId:t.parentId,categoryName:t.ruleForm.name,categoryRank:t.ruleForm.rank}).then(()=>{f.success("\u4FEE\u6539\u6210\u529F"),t.visible=!1,e.reload&&e.reload()})}})};return S(I({},P(t)),{open:h,close:i,formRef:a,submitForm:p,handleClose:g})}},X={class:"dialog-footer"},Y=b("\u53D6 \u6D88"),Z=b("\u786E \u5B9A");function ee(e,a,r,t,n,h){const i=m("el-input"),g=m("el-form-item"),p=m("el-form"),d=m("el-button"),c=m("el-dialog");return D(),$(c,{title:r.type=="add"?"\u6DFB\u52A0\u5206\u7C7B":"\u4FEE\u6539\u5206\u7C7B",modelValue:e.visible,"onUpdate:modelValue":a[3]||(a[3]=u=>e.visible=u),width:"400px",onClose:t.handleClose},{footer:s(()=>[v("span",X,[l(d,{onClick:a[2]||(a[2]=u=>e.visible=!1)},{default:s(()=>[Y]),_:1}),l(d,{type:"primary",onClick:t.submitForm},{default:s(()=>[Z]),_:1},8,["onClick"])])]),default:s(()=>[l(p,{model:e.ruleForm,rules:e.rules,ref:"formRef","label-width":"100px",class:"good-form"},{default:s(()=>[l(g,{label:"\u5206\u7C7B\u540D\u79F0",prop:"name"},{default:s(()=>[l(i,{type:"text",modelValue:e.ruleForm.name,"onUpdate:modelValue":a[0]||(a[0]=u=>e.ruleForm.name=u)},null,8,["modelValue"])]),_:1}),l(g,{label:"\u6392\u5E8F\u503C",prop:"rank"},{default:s(()=>[l(i,{type:"number",max:"200",modelValue:e.ruleForm.rank,"onUpdate:modelValue":a[1]||(a[1]=u=>e.ruleForm.rank=u)},null,8,["modelValue"])]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["title","modelValue","onClose"])}var te=L(W,[["render",ee]]);const ae={name:"Category",components:{DialogAddCategory:te},setup(){const e=w(null),a=w(null),r=U(),t=R(),n=z({loading:!1,tableData:[],multipleSelection:[],total:0,currentPage:1,pageSize:10,type:"add",level:1,parent_id:0});G(()=>{i()}),M(()=>{h()});const h=r.afterEach(o=>{["category","level2","level3"].includes(o.name)&&i()}),i=()=>{const{level:o=1,parent_id:_=0}=t.query;n.loading=!0,y.get("/categories",{params:{pageNumber:n.currentPage,pageSize:n.pageSize,categoryLevel:o,parentId:_}}).then(F=>{n.tableData=F.list,n.total=F.totalCount,n.currentPage=F.currPage,n.loading=!1,n.level=o,n.parentId=_})},g=()=>{n.type="add",a.value.open()},p=o=>{n.type="edit",a.value.open(o)},d=o=>{n.multipleSelection=o},c=()=>{if(!n.multipleSelection.length){f.error("\u8BF7\u9009\u62E9\u9879");return}y.delete("/categories",{data:{ids:n.multipleSelection.map(o=>o.categoryId)}}).then(()=>{f.success("\u5220\u9664\u6210\u529F"),i()})},u=o=>{y.delete("/categories",{data:{ids:[o]}}).then(()=>{f.success("\u5220\u9664\u6210\u529F"),i()})},C=o=>{n.currentPage=o,i()},k=o=>{const _=o.categoryLevel+1;if(_==4){f.error("\u6CA1\u6709\u4E0B\u4E00\u7EA7");return}r.push({name:`level${_}`,query:{level:_,parent_id:o.categoryId}})};return S(I({},P(n)),{multipleTable:e,handleSelectionChange:d,addGood:a,handleAdd:g,handleEdit:p,handleDelete:c,handleDeleteOne:u,getCategory:i,changePage:C,handleNext:k})}},oe=e=>(K("data-v-4d5aa038"),e=e(),Q(),e),ne={class:"header"},le=b("\u589E\u52A0"),re=b("\u6279\u91CF\u5220\u9664"),se=["onClick"],ie=["onClick"],de=oe(()=>v("a",{style:{cursor:"pointer"}},"\u5220\u9664",-1));function ce(e,a,r,t,n,h){const i=m("el-button"),g=m("el-popconfirm"),p=m("el-table-column"),d=m("el-table"),c=m("el-pagination"),u=m("el-card"),C=m("DialogAddCategory"),k=O("loading");return D(),x(H,null,[l(u,{class:"category-container"},{header:s(()=>[v("div",ne,[l(i,{type:"primary",size:"small",icon:"el-icon-plus",onClick:t.handleAdd},{default:s(()=>[le]),_:1},8,["onClick"]),l(g,{title:"\u786E\u5B9A\u5220\u9664\u5417\uFF1F",onConfirm:t.handleDelete},{reference:s(()=>[l(i,{type:"danger",size:"small",icon:"el-icon-delete"},{default:s(()=>[re]),_:1})]),_:1},8,["onConfirm"])])]),default:s(()=>[J((D(),$(d,{ref:"multipleTable",data:e.tableData,"tooltip-effect":"dark",style:{width:"100%"},onSelectionChange:t.handleSelectionChange},{default:s(()=>[l(p,{type:"selection",width:"55"}),l(p,{prop:"categoryName",label:"\u5206\u7C7B\u540D\u79F0"}),l(p,{prop:"categoryRank",label:"\u6392\u5E8F\u503C",width:"120"}),l(p,{prop:"createTime",label:"\u6DFB\u52A0\u65F6\u95F4",width:"200"}),l(p,{label:"\u64CD\u4F5C",width:"220"},{default:s(o=>[v("a",{style:{cursor:"pointer","margin-right":"10px"},onClick:_=>t.handleEdit(o.row.categoryId)},"\u4FEE\u6539",8,se),v("a",{style:{cursor:"pointer","margin-right":"10px"},onClick:_=>t.handleNext(o.row)},"\u4E0B\u7EA7\u5206\u7C7B",8,ie),l(g,{title:"\u786E\u5B9A\u5220\u9664\u5417\uFF1F",onConfirm:_=>t.handleDeleteOne(o.row.categoryId)},{reference:s(()=>[de]),_:2},1032,["onConfirm"])]),_:1})]),_:1},8,["data","onSelectionChange"])),[[k,e.loading]]),l(c,{background:"",layout:"prev, pager, next",total:e.total,"page-size":e.pageSize,"current-page":e.currentPage,onCurrentChange:t.changePage},null,8,["total","page-size","current-page","onCurrentChange"])]),_:1}),l(C,{ref:"addGood",reload:t.getCategory,type:e.type,level:e.level,parent_id:e.parent_id},null,8,["reload","type","level","parent_id"])],64)}var ge=L(ae,[["render",ce],["__scopeId","data-v-4d5aa038"]]);export{ge as default};
