var stepSlider = document.getElementById('price-range-slider');
var minInput = document.getElementById('min-price');
var maxInput = document.getElementById('max-price');
var priceInputs = [minInput, maxInput];

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



$(document).ready(function () {
// Listen to keydown events on the input field.

    minInput.addEventListener('change', function () {
        stepSlider.noUiSlider.set([this.value, null]);
    });

    maxInput.addEventListener('change', function () {
        stepSlider.noUiSlider.set([null, this.value]);
    });

    minInput.addEventListener('keydown', function (e) {
        switch (e) {
            case 13: case 38: case 40:
                stepSlider.noUiSlider.set([this.value, null]);
                break;
        }
    });

    maxInput.addEventListener('keydown', function (e) {
        switch (e) {
            case 13: case 38: case 40:
                stepSlider.noUiSlider.set([null, this.value]);
                break;
        }
    });
});