<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>TST0101</title>

    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/webjar-jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/request.js"></script>

    <script>

        const SUBMIT_TRNASACTION_URL = "${pageContext.request.contextPath}/submit/TST/TST010001";
        const TRNASACTION_URL = "${pageContext.request.contextPath}/transaction/TST/TST010001";

       function fn_submit_test_json() {

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

           callJsonAjaxByData(TRNASACTION_URL, reqData);

       }

        function fn_submit_form() {
            callJsonFormById(TRNASACTION_URL, "transForm");
        }

        function fn_submit() {
            submitFormById(SUBMIT_TRNASACTION_URL, "transForm");
        }
    </script>

</head>
<body>

    pageContext.request.contextPath : ${pageContext.request.contextPath}

    <%--  enctype="multipart/form-data" --%>
    <form id="transForm" name="transForm" method="post">
        <input type="text" name="id" id="id" placeholder="아이디를 입력하세요." value="ReyMysterio" />
        <input type="text" name="name" id="name" placeholder="이름을 입력하세요." value="Mexi" />
        <input type="text" name="phone" placeholder="000-0000-0000" value="010-5000-9050" />
        <input type="text" name="phone" placeholder="000-0000-0000" value="010-4411-2345" />

        <input type="text" name="korTest" value="한글 보기" />

        <br />

        <input type="checkbox" name="checks" value="A1" id="check1" /><label for="check1">체크하기1</label>
        <input type="checkbox" name="checks" value="A2" id="check2" /><label for="check2">체크하기2</label>

        <input type="file" name="uploadFile" id="uploadFile" />

    </form>

    <br />
    <button type="button" onclick="fn_submit_test_json()">Submit TEST TO JSON</button>
    <br />
    <button type="button" onclick="fn_submit_form()">Submit FORM TO JSON</button>
    <br />
    <button type="button" onclick="fn_submit()">SUBMIT</button>
    <br />
</body>
</html>