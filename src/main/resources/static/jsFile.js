

function isNumberRegex(that) {

    //that.focus();
    var regex = /[^/0-9]/g;
    that.value = that.value.replace(regex, "");


}

function isNumber(that)
{

    if(isNaN(that.value ))
    {
        alert("Enter a number");
        $(that).focus();
        that.value='';

    }

}

function autologin(elemID, user, pass) {
    $('#usr').val(user);
    $('#pwd').val(pass);
    $(elemID).focus();
    $(elemID).click();

}