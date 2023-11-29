<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Test</title>

    <script src="${pageContext.request.contextPath}/webjars/webjar-jquery/dist/jquery.min.js"></script>

    <script>

        const TRNASACTION_URL = "${pageContext.request.contextPath}/transaction/submitTest";
        const TEST_JSON_URL = "/transaction/test/userTest";

        function CALL_JSON(JSON_URL, JSON_DATA) {

            $.ajax({
                url : JSON_URL
                , data : JSON_DATA
                , type : "POST"
                , async : true
                , timeout : 5500
                , dataType : "JSON"
                , contentType : "application/json; charset=utf-8"
                , success : function(res) {
                    console.log(res);
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

       function fn_submit_json() {

           let reqData = {
               'id' : 'test'
               , 'name' : '12'
               , 'phone' : ['010-4680-8512', '010-8000-4050']
               , 'checks' : ['A1', 'A2']
               , 'listMap' : [
                   { 'map1' : 'val1' }
                   , { 'map2' : 'val2' }
                   , { 'map3' : 'val3' }
               ]
           }

           reqData = JSON.stringify(reqData);
           console.log(reqData);
           CALL_JSON(TEST_JSON_URL, reqData);

           // let JSON_DATA = serializeFormToJsonData();
           // console.log(JSON_DATA);
           // CALL_JSON(TEST_JSON_URL, JSON_DATA);

       }

        function serializeFormToJsonData() {

            let selForm = document.querySelector("#transForm");
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

    </script>

</head>
<body>
    <form id="transForm" name="transForm" method="post">
        <input type="text" name="id" id="id" placeholder="아이디를 입력하세요." value="ReyMysterio" />
        <input type="text" name="name" id="name" placeholder="이름을 입력하세요." value="Mexi" />
        <input type="text" name="phone" placeholder="000-0000-0000" value="010-5000-9050" />
        <input type="text" name="phone" placeholder="000-0000-0000" value="010-4411-2345" />

        <br />

        <input type="checkbox" name="checks" value="A1" id="check1" /><label for="check1">체크하기1</label>
        <input type="checkbox" name="checks" value="A2" id="check2" /><label for="check2">체크하기2</label>
    </form>

    <button type="button" onclick="fn_submit_json()">Submit JSON</button>
</body>
</html>