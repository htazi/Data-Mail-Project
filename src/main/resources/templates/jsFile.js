

function isNumber(that) {

    //that.focus();
    var regex = /[^/0-9]/g;
    that.value = that.value.replace(regex, "");


}