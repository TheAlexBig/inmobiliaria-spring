$(document).ready(function(){
    $('#intro-items').slick({
        centerMode: true,
        centerPadding: '60px',
        slidesToShow: 4,
        arrows: false,
        responsive: [
            {
                breakpoint: 768,
                settings: {
                    arrows: false,
                    centerMode: true,
                    centerPadding: '40px',
                    slidesToShow: 4
                }
            }
            ]
    });
});