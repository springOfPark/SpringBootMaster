<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>TST0101</title>

    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/webjar-jquery/3.6.0-10/dist/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/front/scripts/request.js"></script>

    <script>

        const SUBMIT_TRNASACTION_URL = "${pageContext.request.contextPath}/submit/TST/TST010001";
        const TRNASACTION_URL = "${pageContext.request.contextPath}/transaction/TST/TST010001";
        const UPLOAD_SUBMIT_URL = "${pageContext.request.contextPath}/fileUploadSubmit";

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

        function fn_submit_multipart() {

            const submitForm = document.querySelector("#transForm");
            submitForm.action = UPLOAD_SUBMIT_URL;
            submitForm.submit();

        }
    </script>

</head>
<body>

    pageContext.request.contextPath : ${pageContext.request.contextPath}
    <br />
    Session : <%=session.getId()%> / <%=session.isNew()%>
    <br />
    Request Param : ${bodyReq}
    <br />
    Result Data : ${bodyRes.resultMap}
    <br />
    Result Data : ${bodyRes.resultString}


    <%--  enctype="multipart/form-data" --%>
    <form id="transForm" name="transForm" method="post" enctype="multipart/form-data">
        <input type="text" name="id" id="id" placeholder="아이디를 입력하세요." value="ReyMysterio" />
        <input type="text" name="name" id="name" placeholder="이름을 입력하세요." value="Mexi" />
        <input type="text" name="phone" placeholder="000-0000-0000" value="010-5000-9050" />
        <input type="text" name="phone" placeholder="000-0000-0000" value="010-4411-2345" />

        <input type="text" name="korTest" value="한글 보기" />

        <input type="text" name="paramValue" value="파라미터 벨류 값 테스트 합니다" />

        <br />

        <input type="checkbox" name="checks" value="A1" id="check1" /><label for="check1">체크하기1</label>
        <input type="checkbox" name="checks" value="A2" id="check2" /><label for="check2">체크하기2</label>

        <br />
        업로드 파일 01 :
        <input type="file" name="uploadFile01" id="uploadFile01_1" />
        <input type="file" name="uploadFile01" id="uploadFile01_2" />
        <input type="file" name="uploadFile01" id="uploadFile01_3" />
        <br />
        업로드 파일 02 :
        <input type="file" name="uploadFile02" id="uploadFile02_1" />

    </form>

    <br />
    <button type="button" onclick="fn_submit_test_json()">Submit TEST TO JSON</button>
    <br />
    <button type="button" onclick="fn_submit_form()">Submit FORM TO JSON</button>
    <br />
    <button type="button" onclick="fn_submit()">SUBMIT</button>
    <br />
    <button type="button" onclick="fn_submit_multipart()">File Upload Submit</button>
</body>
</html>