$(function() {
    var allList = $(".sidebar1 > ul");
    var triggers = $(".sidebar1 > h3")
    var index = 0;
    $.each(allList, function(i, item) {
        $(allList[index++]).addClass("hide");
        if (index === allList.length) {
            index = 0;
        }
    });
    triggers.click(function() {
        $(this).next("ul").toggleClass("hide");
    });
});
