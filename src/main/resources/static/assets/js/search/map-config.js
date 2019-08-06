var fatherSearch = document.querySelector("#search-results");
var houseChild = document.querySelectorAll("#search-results > *");
var mapToggle = document.querySelector("#map-toggle");
var mapHolder = document.querySelector("#map-holder");
var curtain = document.querySelector("#map");

mapToggle.addEventListener('change', function(){
    if(mapToggle.checked){
        houseChild.forEach(function (e) {
            e.classList.remove('col-md-4');
            e.classList.add("col-md-6");
        });
        fatherSearch.classList.remove("col-md-12");
        fatherSearch.classList.add("col-md-8");
        curtain.classList.remove("col-md-0");
        curtain.classList.add("col-md-4");
        mapHolder.classList.remove("col-md-0");
        mapHolder.classList.add("col-md-4");
    }
    else{
        houseChild.forEach(function (e) {
            e.classList.remove('col-md-6');
            e.classList.add("col-md-4");
        });
        fatherSearch.classList.remove("col-md-8");
        fatherSearch.classList.add("col-md-12");
        curtain.classList.remove("col-md-4");
        curtain.classList.add("col-md-0");
        mapHolder.classList.remove("col-md-4");
        mapHolder.classList.add("col-md-0");
    }
});