$(document).ready(function(){
    //First slicker and carousel items
    var slickerDescription = $('#description-items');
    var carouselDescription = $('#preview-house');
    var targetPrev = $("#button-prev-carousel");
    var targetNext = $("#button-next-carousel");
    var slickerRecommended = $("#recommended");
    var carouselSlideDirection = 0;


    slickerDescription.slick({
        slidesToShow: 6,
        slidesToScroll: 1,
        arrows: false,
        dots: false
    });

    slickerRecommended.slick({
        centerMode: true,
        centerPadding: '60px',
        slidesToShow: 4,
        prevArrow: $('.prev-slick'),
        nextArrow: $('.next-slick')
    });

    targetPrev.on('click', function (ev) {
        carouselSlideDirection = -1;
        carouselDescription.carousel('prev');
    });
    targetNext.on('click', function (ev) {
        carouselSlideDirection = 1;
        carouselDescription.carousel('next');
    });
    carouselDescription.on('slide.bs.carousel', function (ev) {
        var localDirection = carouselSlideDirection;
        switch (localDirection) {
            case -1:
                slickerDescription.slick("slickPrev");
                break;
            case 1:
                slickerDescription.slick("slickNext");
                break;
        }
        carouselSlideDirection = 0;
    });


});