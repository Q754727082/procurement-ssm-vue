$(function() {

	$("a").click(function() {
		$("a").css("text-decoration", "none");
	});

	$(".li1").click(function() {
		if (this.value !=99)
		{
			$("#cs"+this.value).show();
			$("#cs"+this.value).siblings().hide();
		} else
		{
			$("#cs0").hide();
			$("#cs0").siblings().hide();
		}

		$(this).siblings().removeClass("tli");
		$(this).addClass("tli");

		if (this.value !=99){
			$(".sp").text(this.innerText);
		}else {
			$(".sp").text("");
		}
});

	$(".zb1:eq(0)").click(function() {
		$(this).siblings().removeClass("tli");
		$(this).addClass("tli");
		$(".sp1:eq(0)").text("");
	});
	$(".zb1:eq(1)").click(function() {
		$(this).siblings().removeClass("tli");
		$(this).addClass("tli");
		$(".sp1:eq(0)").text("公开招标公告");
	});
	$(".zb1:eq(2)").click(function() {
		$(this).siblings().removeClass("tli");
		$(this).addClass("tli");
		$(".sp1:eq(0)").text("中标公告");
	});
	$(".date:eq(0)").click(function() {
		$(this).siblings().removeClass("tli");
		$(this).addClass("tli");
		$(".sp1:eq(1)").text("");
	});
	$(".date:eq(1)").click(function() {
		$(this).siblings().removeClass("tli");
		$(this).addClass("tli");
		$(".sp1:eq(1)").text("今日");
	});
	$(".date:eq(2)").click(function() {
		$(this).siblings().removeClass("tli");
		$(this).addClass("tli");
		$(".sp1:eq(1)").text("近一周");
	});
	$(".date:eq(3)").click(function() {
		$(this).siblings().removeClass("tli");
		$(this).addClass("tli");
		$(".sp1:eq(1)").text("近一个月");
	});
	$(".date:eq(4)").click(function() {
		$(this).siblings().removeClass("tli");
		$(this).addClass("tli");
		$(".sp1:eq(1)").text("近三个月");
	});
	$(".date:eq(5)").click(function() {
		$(this).siblings().removeClass("tli");
		$(this).addClass("tli");
		$(".sp1:eq(1)").text("近半年");
	});
	$(".date:eq(6)").click(function() {
		$(this).siblings().removeClass("tli");
		$(this).addClass("tli");
		$(".sp1:eq(1)").text("近一年");

	})
	$(".bu").click(function() {
		$(".sp").text("");
		$(".sp1").text("");
		$(".li1:eq(0)").addClass("tli");
		$(".li1:eq(0)").siblings().removeClass("tli");
		$(".li2").removeClass("tli");
		$("#cs0").siblings().hide();
		$("#cs0").hide();
		$(".zb1:eq(0)").addClass("tli");
		$(".zb1:eq(0)").siblings().removeClass("tli");
		$(".date:eq(0)").addClass("tli");
		$(".date:eq(0)").siblings().removeClass("tli");

	});
	$(".li2").click(function() {
		$(".li2").removeClass("tli");
		$(this).addClass("tli");
		$(".sp").text(this.innerText);
	});

})