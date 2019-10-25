$(function () {
    //展示公司信息
    company();
})
function search() {
    $("#tbody").html("");
    var pageIndex=1;
    $("#pageindex").val(pageIndex);
    company();
}

function company() {
    var name = $("#name").val();
    var pageIndex=$("#pageindex").val();
    $.ajax({
        "type": "get",
        "url": "company/companylist3",
        "data": {name: name,pageIndex:pageIndex},
        "dataType": "json",
        async:false,
        success: function (d) {
            var list = d.list3;
            console.log(list.length);
            for (var i = 0; i < list.length; i++) {
                let html = '<tr role="row" class="odd">'
                    +'<td style="display: none">id</td>'
                    + '<td tabindex="0" class="sorting_1">company_name</td>'
                    + '<td tabindex="1" class="sorting_2">company_address</td>'
                    + '<td tabindex="2" class="sorting_3">type_ownership</td>'
                    + '<td tabindex="3" class="sorting_4">main_business</td>'
                    + '<td tabindex="4" class="sorting_5">strategic_focus</td>'
                    + '<td tabindex="5" class="sorting_6">listed_unlisted</td>'
                    + '<td tabindex="6" class="sorting_7">ten_shareholders</td>'
                    + '<td tabindex="7" class="sorting_8">user_name</td>'
                    + '<td tabindex="8" class="sorting_9">company_ranking</td>'
                    + '<td tabindex="9" class="sorting_10">business_license</td>'
                    + '<td tabindex="10" class="sorting_11">exequatur</td>'
                    +'<td>'


                    +'<div class="btn-group">'
                    +'<button type="button" class="btn btn-danger">点击操作</button>'
                    +'<button type="button" class="btn btn-danger dropdown-toggle" jsona-toggle="dropdown" aria-expanded="false">'
                    +'<span class="caret"></span>'
                    +'<span class="sr-only">Toggle Dropdown</span>'
                    +'</button>'
                    +'<ul class="dropdown-menu" role="menu">'

                    +'<li><a  class="modifyAppInfo" jsona-toggle="tooltip" jsona-placement="top" title="" jsona-original-title="修改公司信息">修改</a></li>'
                    +'<li><a  class="viewApp"   jsona-toggle="tooltip" jsona-placement="top" title="" jsona-original-title="查看公司信息">查看</a></li>'
                    +'<li><a  class="deleteApp"  jsona-toggle="tooltip" jsona-placement="top" title="" jsona-original-title="删除公司信息">删除</a></li>'
                    +'</ul>'
                    +'</div>'
                    +'</td>'
                    + '</tr>'
                html=html.replace('id',list[i].id);
                html = html.replace('company_name', list[i].company_name);
                html = html.replace('company_address', list[i].company_address);
                html = html.replace('type_ownership', list[i].type_ownership);
                html = html.replace('main_business', list[i].main_business);
                html = html.replace('strategic_focus', list[i].strategic_focus);
                html = html.replace('listed_unlisted', list[i].listed_unlisted);
                html = html.replace('ten_shareholders', list[i].ten_shareholders);
                html = html.replace('user_name', list[i].user_name);
                html = html.replace('company_ranking', list[i].company_ranking);
                html = html.replace('business_license', list[i].business_license);
                html = html.replace('exequatur', list[i].exequatur);
                $("#tbody").append(html);
            }
            $("#totalCount").html(d.totalCount);
            $("#currentPageNo").html(d.currentPageNo);
            $("#max").html(d.totalPageCount);
        }
    })
}
$("#lapage").on("click",function () {
    var pageIndex=$("#currentPageNo").val()*1+1;
    $("#pageindex").val(pageIndex);
    company();
})

$("#uppage").on("click",function () {
    var pageIndex=$("#currentPageNo").val()*1-1;
    $("#pageindex").val(pageIndex);
    company();
})

$("#minpage").on("click",function () {
    var pageIndex=1;
    $("#pageindex").val(pageIndex);
    company();
})

$("#maxpage").on("click",function () {
    var pageIndex=$("#max").val();
    $("#pageindex").val(pageIndex);
    company();
})
