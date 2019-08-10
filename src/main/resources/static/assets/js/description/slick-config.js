$(document).ready(function(){
    var slickerDescription = $('#description-items');

    slickerDescription.slick({
        infinite: true,
        slidesToShow: 6,
        slidesToScroll: 1,
        arrows: false,
        dots: false
    });
    $('#button-next-carousel').on("click", function (ev) {
        slickerDescription.slick("slickNext");
    });
    $('#button-prev-carousel').on("click", function (ev) {
        slickerDescription.slick("slickPrev");
    });
});