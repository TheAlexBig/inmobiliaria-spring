//Map-config
var fatherSearch = document.querySelector("#search-results-container");
var houseChild = document.querySelectorAll("#search-results > *");
var mapToggle = document.querySelector("#map-toggle");
var mapHolder = document.querySelector("#map-holder");
var curtain = document.querySelector("#map");


mapToggle.addEventListener('change', function () {
    changeSearchMapState();
});

function changeSearchMapState(){
    if (mapToggle.checked) {
        houseChild.forEach(function (e) {
            e.classList.remove('col-md-3');
            e.classList.add("col-md-4");
        });
        fatherSearch.classList.remove("col-md-12");
        fatherSearch.classList.add("col-md-8 pr-4 pl-4");
        mapHolder.classList.remove("col-md-0");
        mapHolder.classList.add("col-md-4");
    } else {
        houseChild.forEach(function (e) {
            e.classList.remove('col-md-4');
            e.classList.add("col-md-3");
        });
        fatherSearch.classList.remove("col-md-8 pr-4 pl-4");
        fatherSearch.classList.add("col-md-12");
        mapHolder.classList.remove("col-md-4");
        mapHolder.classList.add("col-md-0");
    }
}

var createdPopup = [];
//Configuration of popOver
function setPopoverMenu(element) {
    var idReference = element.btn;
    var htmlReference = document.getElementById(element.tooltip);
    var sliderReference = document.getElementById(element.slider);
    var ref = $("#" + idReference);
    var popup = $(htmlReference);
    var referenceInputs = [];
    element.inputs.forEach(function (value) {
       referenceInputs.push(document.getElementById(value));
    });

    createSlider(element.sliderOption, referenceInputs, sliderReference);
    setSliderEvents(element.sliderOption, referenceInputs, sliderReference);


    popup.on("click", function (e) {
        //e.stopPropagation();
    });
    createdPopup.push(popup);

    ref.on("click",function (e) {
        if(popup.is(":hidden")){
           var popper = new Popper(ref,popup,{
               placement: 'bottom'
           });
            createdPopup.forEach(function (value) {
                if(popup!=value){
                value.hide();
                }
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
function createSlider(option, sliderInputs, stepSlider) {
    switch (option) {
        case 1:
            $(stepSlider).customSlider({
                start: 1000,
                tooltips: true,
                connect: [true , false],
                format: wNumb({
                    decimals: 0, // default is 2
                    thousand: ',', // thousand delimiter
                    prefix: 'm^2 ' // gets appended after the number
                }),
                range: {
                    'min': 0,
                    '70%': 20000,
                    'max': 120000
                }
            });
            break;
        case 2:
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
                    'max': 9000000
                }
            });

            break;
    }

    stepSlider.noUiSlider.on('update', function (values, handle) {
        values.forEach(function(v, i){
            values[i] = v.toString().split(" ")[1].replace(/,/g, '');
        });
        sliderInputs[handle].value = values[handle];
    });
}

function setSliderEvents(option, sliderInputs, stepSlider) {
    switch (option) {
        case 2:
            var minInput = sliderInputs[0];
            var maxInput = sliderInputs[1];
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
            break;
        case 1:
            var maxSingleInput = sliderInputs[0];
            maxSingleInput.addEventListener('change', function () {
                stepSlider.noUiSlider.set([this.value, null]);
            });
            maxSingleInput.addEventListener('keydown', function (e) {
                switch (e) {
                    case 13:
                    case 38:
                    case 40:
                        stepSlider.noUiSlider.set([this.value, null]);
                        break;
                }
            });
            break;
    }
}

