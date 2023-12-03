package me.ktpark.websvc.base.controller;

import me.ktpark.websvc.base.model.FileModel;
import me.ktpark.websvc.base.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class FileUploadController {

    static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileService fileService;

    @PostMapping("/fileUploadSubmit")
    public String fileUploadSubmit(MultipartHttpServletRequest multipartRequest, @RequestParam Map<String, Object> param) throws Exception {

        System.out.println(multipartRequest.getClass());
        System.out.println(multipartRequest.getCharacterEncoding());

        String uploadFileName = "uploadFile01";

        MultipartFile file = multipartRequest.getFile(uploadFileName);
        List<MultipartFile> fileList = multipartRequest.getFiles(uploadFileName);
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();

        Iterator<String> fileNames = multipartRequest.getFileNames();
        fileNames.forEachRemaining(System.out::println);

        MultiValueMap<String, MultipartFile> multiFileMap = multipartRequest.getMultiFileMap();
        System.out.println(multiFileMap);
        System.out.println(multiFileMap.toSingleValueMap());

        /* 일반적으로 파일 업로드 기능을 사용할 때
          1. 파일 네임 설정해서 받는다.
          2. 업로드 후 해당 파일 정보를 가져온다
          3. 해당 파일을 데이터베이스에 INSERT 한다.
         */

        // 1. 파일 업로드
        List<FileModel> savedFileList = fileService.uploadFilesWithMultipartRequest(multipartRequest);


        // 2. 업로드 한 파일 객체 반환

        // 3. 파일 객체 데이터베이스 Insert

        return "/websvc/common/submitResult";

    }

}
