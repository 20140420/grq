/* gdial */
$(function(){
	var hor = $(".gdial-top > div");
	var rig = $(".gdial-right > div");
	var bottom = $(".gdial-bottom > div");
	var left = $(".gdial-left > div");
	
	var timer = null, index = 0;
	
	var allList = [];
	$.each(hor, function(i, item){
		allList.push(item);
	});
	$.each(rig, function(i, item){
		allList.push(item);
	});
	var blen = bottom.length;
	$.each(bottom, function(i, item){
		allList.push(bottom[blen - 1 - i]);
	});
	var llen = left.length;
	$.each(left, function(i, item){
		allList.push(left[llen - 1 - i]);
	});
	
	timer = setInterval(function(){
		$(allList[index++]).removeClass("alpha");
		if (index === allList.length) {
			index = 0;
		}
		$(allList[index]).addClass("alpha");
	}, 80);
});