function submitFormById(ACTION_URL, FORM_ID) {

    const submitForm = document.querySelector("#" + FORM_ID);
    submitForm.action = ACTION_URL;
    submitForm.submit();

}

function callJsonAjax(JSON_URL, JSON_DATA) {

    $.ajax({
        url : JSON_URL
        , data : JSON_DATA
        , type : "POST"
        , async : false
        , timeout : 5500
        , dataType : "JSON"
        , contentType : "application/json; charset=UTF-8"
        , success : function(res) {
            console.log(res);
            // let result = JSON.parse(res);
            // console.log(result);
        },
        error : function (xhr) {
            console.log(xhr);
        },
        complete : function(completeData, textStatus) {
            console.log(completeData);
            console.log(textStatus);
        }
    })

}

function callJsonAjaxByData(JSON_URL, JSON_DATA) {
    const TO_JSON_DATA = JSON.stringify(JSON_DATA);
    callJsonAjax(JSON_URL, TO_JSON_DATA);
}

function callJsonFormById(JSON_URL, FORM_ID) {
    const JSON_DATA = serializeFormToJsonDataById(FORM_ID);
    callJsonAjax(JSON_URL, JSON_DATA);
}

function serializeFormToJsonDataById(FORM_ID) {

    let selForm = document.querySelector("#" + FORM_ID);
    let rawData = new FormData(selForm);

    let rtnData = {};
    for (let [key, value] of rawData) {
        let sel = document.querySelectorAll("[name=" + key + "]");

        // Array Values
        if (sel.length > 1) {
            if (rtnData[key] === undefined) {
                rtnData[key] = [];
            }
            rtnData[key].push(value);
        }
        // Other
        else {
            rtnData[key] = value;
        }
    }

    return JSON.stringify(rtnData);
}