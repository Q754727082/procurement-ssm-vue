new Vue({
    el:"#zhaobiao",
    data:{
        zhaobiao:{
            id:"",
            announcementName:"",
            projectName:"",
            address:"",
            time:"",
            buyer:"",
            item:"",
            purchasingUnit:"",
            administrative:"",
            announcementTime:"",
            expert:"",
            amount:"",
            contactPerson:"",
            contactNumber:"",
            xPurchasingUnit:"",
            unitAddress:"",
            unitContact:"",
            nameOfAgent:"",
            agencyAddress:"",
            agentContact:"",
            type:"",
            url:""
        },
        zhaobiaoList:[]
    },
    methods:{
        selectAll:function(){
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/procurement/zhaobiao/selectAll.do')
                .then(function (response) {
                    _this.zhaobiaoList = response.data;//响应数据给userList赋值
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
      /*  findById:function (userid) {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/vuejsdemo/user/findById.do',{params:{id:userid}})
                .then(function (response) {
                    _this.user = response.data;//响应数据给userList赋值
                    $("#myModal").modal("show");
                })
                .catch(function (error) {
                    console.log(error);
                })
        },*!/*/
        /*update:function (user) {//post请求
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.post('/vuejsdemo/user/updateUser.do', _this.user)
                .then(function (response) {
                    _this.findAll();
                })
                .catch(function (error) {
                    console.log(error);
                });
        }*/
    },
    created:function() {//当我们页面加载的时候触发请求，查询所有
        this.selectAll();
    }
});