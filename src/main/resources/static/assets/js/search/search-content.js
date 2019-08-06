//Map-config
var fatherSearch = document.querySelector("#search-results");
var houseChild = document.querySelectorAll("#search-results > *");
var mapToggle = document.querySelector("#map-toggle");
var mapHolder = document.querySelector("#map-holder");
var curtain = document.querySelector("#map");


var stepSlider = document.getElementById('price-range-slider');
var minInput = document.getElementById('min-price');
var maxInput = document.getElementById('max-price');
var priceInputs = [minInput, maxInput];

mapToggle.addEventListener('change', function () {
    if (mapToggle.checked) {
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
    } else {
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



stepSlider.noUiSlider.on('update', function (values, handle) {
    priceInputs[handle].value = values[handle]
});

//Configuration of popOver
function setPopoverMenu(idReference, htmlReference) {
    createSlider();
    var popoverElement = document.querySelector("#" + idReference);
    var htmlToEmbed = $("#"+htmlReference).html();
    $(popoverElement).popover({
        placement: 'bottom',
        html: true,
        sanitize: false,
        title: 'Precio',
    }).click(function () {
        var $this = $(this);
        if ($this.toggleClass('active').hasClass('active')) {
            $this.popover('show');
            $('.popover-content')
                .empty()
                .append(htmlToEmbed);
        } else {
            htmlToEmbed.detach();
            $this.popover('hide');
        }
    });
}


//Slider config
function createSlider() {
    $(stepSlider).customSlider({
        start: [0, 1000],
        tooltips: [true, true],
        connect: true,
        range: {
            'min': 0,
            '70%': 20000,
            'max': 2000000
        }
    });

    stepSlider.noUiSlider.on('update', function (values, handle) {
        priceInputs[handle].value = values[handle]
    });

}

function setSliderEvents() {
// Listen to keydown events on the input field.

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

function initMap() {
    var myLatLng = {lat: -25.363, lng: 131.044};
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 4,
        center: myLatLng
    });

    var marker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        title: 'Search results'
    });
}