new Vue({
    el:"#info",
    data:{
        zhaobiao:{
            id:"",
            announcementName:"",
            time:"",
            annotype:"",
            administrative:"",
            url:"",
            gxxText:""

        },
        zhaobiaoList:[],
        search:"",
        msg:""

    },
    filters: {
      ellipsis(value){
          if (!value){
              return "";
          }
          if (value.length>30){
              return value.slice(0,30)+'...';
          }else{
              return value;
          }
      }
    },
    methods: {

        findSimpleMessage:function(){
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/procurement/zhaobiao/findSimpleMessage.do')
                .then(function (response) {
                    _this.zhaobiaoList = response.data;//响应数据给userList赋值
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },

        selectSimpleMessage: function (pageNo) {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/procurement/zhaobiao/selectSimpleMessage.do',{params:{pageNo:pageNo}})
                .then(function (response) {
                    _this.zhaobiaoList = _this.zhaobiaoList.concat(response.data);//响应数据给userList赋值
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        findByKeyword: function (keyword) {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/procurement/zhaobiao/findByKeyword.do',{params:{keyword:keyword}})
                .then(function (response) {
                    _this.zhaobiaoList = response.data;//响应数据给userList赋值
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },

        selectByKeyword: function (keyword,pageNo) {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/procurement/zhaobiao/selectByKeyword.do',{params:{keyword:keyword,pageNo:pageNo}})
                .then(function (response) {
                    _this.zhaobiaoList = _this.zhaobiaoList.concat(response.data);//响应数据给userList赋值
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                    _this.msg="查询失败";
                })
        },

        queryByFix: function (address,annoType,day) {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/procurement/zhaobiao/queryByFix.do',{params:{address:address,annoType:annoType,day:day}})
                .then(function (response) {
                    _this.zhaobiaoList = response.data;//响应数据给userList赋值
                    console.log(response);
                    // console.log(response.msg);
                })
                .catch(function (error) {
                    console.log(error);
                    _this.msg="查询失败";
                })
        },

        selectByFix: function (address,annoType,day,pageNo) {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/procurement/zhaobiao/selectByFix.do',{params:{address:address,annoType:annoType,day:day,pageNo:pageNo}})
                .then(function (response) {
                    _this.zhaobiaoList =  _this.zhaobiaoList.concat(response.data);//响应数据给userList赋值
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },

        switchCase: function(time){
            let day=365;
            switch (time) {
                case "不限": day=null;
                break;
                case "今日": day="1";
                break;
                case "近一周":day="7";
                break;
                case "近一个月":day="30";
                break;
                case "近三个月":day="90";
                break;
                case "近半年": day="180";
                break;
                case "近一年": day="365";
                break;
            }
            return day;
        },


        btn:function() {
            var keyword = this.search;
            this.findByKeyword(keyword);
            var _this = this;
            var num=30;
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
                    _this.selectByKeyword(keyword,num);
                    num+=10;
                    console.log("距顶部"+scrollTop+"可视区高度"+windowHeight+"滚动条总高度"+scrollHeight);
                }
            }
        },

        btn1:function () {
            var _this=this;
            $(function () {


                $("#message").bind('DOMNodeInserted',function(){     //DOM节点插入事件，清空元素内容不会触发
                    var address=$("#address").text();

                    var annoType=$("#annoType").text();

                    let time=$("#time").text();
                    // alert(time);
                    let day = _this.switchCase(time);
                    // alert(day1);
                    _this.queryByFix(address,annoType,day);
                    var num=30;
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
                            _this.selectByFix(address,annoType,day,num);
                            num+=10;
                            console.log("距顶部"+scrollTop+"可视区高度"+windowHeight+"滚动条总高度"+scrollHeight);
                        }
                    }
                })
            })
        },

        btn4:function () {
           this.queryByFix(null,null,null);
            var num=30;
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
                    _this.selectByFix(null,null,null,num);
                    num+=10;
                    console.log("距顶部"+scrollTop+"可视区高度"+windowHeight+"滚动条总高度"+scrollHeight);
                }
            }
        }
    },

    created: function(){
        this.findSimpleMessage();
        var _this = this;
        var num=30;
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
                _this.selectSimpleMessage(num);
                num+=10;
                console.log("距顶部"+scrollTop+"可视区高度"+windowHeight+"滚动条总高度"+scrollHeight);
            }
        }
    }

});