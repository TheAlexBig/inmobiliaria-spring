// Elements for input
var stepSlider = document.getElementById('price-range-slider');
var minInput = document.getElementById('min-price');
var maxInput = document.getElementById('max-price');
var btn = document.getElementById('price-btn');
var priceInputs = [minInput, maxInput];

$(document).ready(function(){
    $('#intro-items').slick({
        centerMode: true,
        centerPadding: '60px',
        slidesToShow: 3,
        prevArrow: $('.prev-slick'),
        nextArrow: $('.next-slick')
    });

    function setPopoverMenu() {
        var htmlReference = document.getElementById('price-nav-popover');
        var ref = $(btn);
        var popup = $(htmlReference);

        createSlider();
        setSliderEvents();


        popup.on("click", function (e) {
            //e.stopPropagation();
        });

        ref.on("click",function (e) {
            if(popup.is(":hidden")){
                var popper = new Popper(ref,popup,{
                    placement: 'top'
                });
                popup.show("400");
                popup.focus();
            }
            else{
                popup.hide();
            }
            e.stopPropagation();
        });

        window.addEventListener("click", function (ev) {
            if (!htmlReference.contains(ev.target)){
                popup.hide();
            }
        });

    }

    //Slider config
    function createSlider() {
        $(stepSlider).customSlider({
            start: [0, 1000],
            tooltips: [true, true],
            connect: true,
            format: wNumb({
                decimals: 0, // default is 2
                thousand: ',', // thousand delimiter
                prefix: '$ ' // gets appended after the number
            }),
            range: {
                'min': 0,
                '70%': 20000,
                'max': 2000000
            }
        });

        stepSlider.noUiSlider.on('update', function (values, handle) {
            values.forEach(function(v, i){
                values[i] = v.toString().split(" ")[1].replace(/,/g, '');
            });
            priceInputs[handle].value = values[handle];
        });
    }

    function setSliderEvents() {
        minInput.addEventListener('change', function () {
            stepSlider.noUiSlider.set([this.value, null]);
        });

        maxInput.addEventListener('change', function () {
            stepSlider.noUiSlider.set([null, this.value]);
        });

        minInput.addEventListener('keydown', function (e) {
            switch (e) {
                case 13:
                case 38:
                case 40:
                    stepSlider.noUiSlider.set([this.value, null]);
                    break;
            }
        });

        maxInput.addEventListener('keydown', function (e) {
            switch (e) {
                case 13:
                case 38:
                case 40:
                    stepSlider.noUiSlider.set([null, this.value]);
                    break;
            }
        });

    }
    setPopoverMenu();
});