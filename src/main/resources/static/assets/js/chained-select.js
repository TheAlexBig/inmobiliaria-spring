
var sel1 = document.querySelector('#state');
var sel2 = document.querySelector('#province');
var options2 = sel2.querySelectorAll('option');

function giveSelection(selValue) {
    sel2.innerHTML = '';
    for(var i = 0; i < options2.length; i++) {
        if(options2[i].dataset.option === selValue) {
            sel2.appendChild(options2[i]);
        }
    }
}

giveSelection(sel1.value);
window.onload = function() {
    $('#dateBirth').datepicker({
        maxDate: new Date(),
        calendarWeeks: true,
        autoclose: true,
        todayHighlight: true
    });
};