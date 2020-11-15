new Vue({
    el:"#info",
    data:{
        zhaobiaoList:[],
        search:""
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


        //使用lucene
        selectByLucene: function (keyword) {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/procurement/zhaobiao/selectByLucene.do',{params:{keyword:keyword}})
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
                })
        },

        queryByFix: function (address,annoType,day,keyword) {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/procurement/zhaobiao/queryByFix.do',{params:{address:address,annoType:annoType,day:day,keyword:keyword}})
                .then(function (response) {
                    //获取数据成功
                    if (response.data.code == 0) {
                        $("#msg").hide();
                        $("#table").attr('style','display: block');
                        //显示tbody
                        $(".zhaobiaoInfo").show();
                        //隐藏html那边累加的信息
                        $(".info1").attr('style','display: none');
                        _this.zhaobiaoList = response.data.list;//响应数据给zhaobiaoList赋值
                    }else{
                        $("#msg").text("抱歉，您想要的信息暂时还没有呢。   "+response.data.msg);
                        $("#msg").show();
                        $("#table").attr('style','display: none');
                        _this.zhaobiaoList = response.data.list;//清空原有数据
                    }
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },

        selectByFix: function (address,annoType,day,pageNo,keyword) {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/procurement/zhaobiao/selectByFix.do',{params:{address:address,annoType:annoType,day:day,pageNo:pageNo,keyword:keyword}})
                .then(function (response) {
                    _this.zhaobiaoList =  _this.zhaobiaoList.concat(response.data);//响应数据给userList赋值
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },

        switchCase: function(time){
            var day=null;
            switch (time) {
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
                default: day=null;
            }
            return day;
        },


        btn:function() {
            var _this=this;
            var keyword = this.search;
            var address = $("#address").text();

            var annoType = $("#annoType").text();

            var time = $("#time").text();

            var day = _this.switchCase(time);

            _this.queryByFix(address, annoType, day,keyword);
            var num = 30;
            window.onscroll = function () {
                //变量scrollTop是滚动条滚动时，距离顶部的距离
                var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
                //变量windowHeight是可视区的高度
                var windowHeight = document.documentElement.clientHeight || document.body.clientHeight;
                //变量scrollHeight是滚动条的总高度
                var scrollHeight = document.documentElement.scrollHeight || document.body.scrollHeight;
                //滚动条到底部的条件
                if (scrollTop + windowHeight == scrollHeight) {
                    //写后台加载数据的函数
                    _this.selectByFix(address, annoType, day, num,keyword);
                    num += 10;
                    console.log("距顶部" + scrollTop + "可视区高度" + windowHeight + "滚动条总高度" + scrollHeight);
                }
            }
        },

        btn1:function () {
            var _this=this;
            var keyword = this.search;
            $(function () {

                var times=0;    //保证只执行一次请求

                //使用观察期实现监控span标签体内容改变事件，无论增加还是修改还是删除都可以触发事件
                var config = {
                    attributes: true,
                    childList: true,
                    subtree: true
                };
                var observer = new MutationObserver(spanChanged);
                var span=document.getElementById("message");
                observer.observe(span, config);

                function spanChanged() {
                    times++;
                    if(times!=1){
                        return;
                    }
                    //发生改变后要执行的代码
                    var address = $("#address").text();

                    var annoType = $("#annoType").text();

                    var time = $("#time").text();
                    
                    var day = _this.switchCase(time);

                    _this.queryByFix(address, annoType, day,keyword);
                    var num = 30;
                    window.onscroll = function () {
                        //变量scrollTop是滚动条滚动时，距离顶部的距离
                        var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
                        //变量windowHeight是可视区的高度
                        var windowHeight = document.documentElement.clientHeight || document.body.clientHeight;
                        //变量scrollHeight是滚动条的总高度
                        var scrollHeight = document.documentElement.scrollHeight || document.body.scrollHeight;
                        //滚动条到底部的条件
                        if (scrollTop + windowHeight == scrollHeight) {
                            //写后台加载数据的函数
                            _this.selectByFix(address, annoType, day, num,keyword);
                            num += 10;
                            console.log("距顶部" + scrollTop + "可视区高度" + windowHeight + "滚动条总高度" + scrollHeight);
                        }
                    }
                }

            })
        },

        btn2:function () {
           this.queryByFix(null,null,null,null);
            var num=30;
            var _this = this;
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
                    _this.selectByFix(null,null,null,num,null);
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