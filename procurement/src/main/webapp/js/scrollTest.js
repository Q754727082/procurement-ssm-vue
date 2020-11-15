new Vue({
    el:"#scrollTest",
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
    methods: {

        findTen:function(){
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/procurement/zhaobiao/findTen.do')
                .then(function (response) {
                    _this.zhaobiaoList = response.data;//响应数据给userList赋值
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },

        selectTen: function (pageNo) {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/procurement/zhaobiao/selectTen.do',{params:{pageNo:pageNo}})
                .then(function (response) {
                    _this.zhaobiaoList = _this.zhaobiaoList.concat(response.data);//响应数据给userList赋值
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    },

    created:function(){
        this.findTen();
        var _this = this;
        var num=10;
        window.onscroll = function(){
            //变量scrollTop是滚动条滚动时，距离顶部的距离
            var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
            //变量windowHeight是可视区的高度
            var windowHeight = document.documentElement.clientHeight || document.body.clientHeight;
            //变量scrollHeight是滚动条的总高度
            var scrollHeight = document.documentElement.scrollHeight || document.body.scrollHeight;
            //滚动条到底部的条件
            if(scrollTop+windowHeight==scrollHeight){
                //写后台加载数据的函数
                _this.selectTen(num);
                num+=10;
                console.log("距顶部"+scrollTop+"可视区高度"+windowHeight+"滚动条总高度"+scrollHeight);
            }
        }
    }
});