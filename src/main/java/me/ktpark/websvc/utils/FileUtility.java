package me.ktpark.websvc.utils;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Component
public class FileUtility {

    public String getFileNameUntilNotExist(String uploadPath, String uploadFileName) {
        return getFileNameUntilNotExist(uploadPath, uploadFileName, 0);
    }

    public String getFileNameUntilNotExist(String uploadPath, String uploadFileName, int index) {

        File file = new File(uploadPath + "/" + uploadFileName);

        if (!file.exists()) {
            // 중복된 파일명이 없으면 Return
            return uploadFileName;
        }

        // 중복 파일 이름 뒤에 붙을 번호
        index = index + 1;

        int indexOfLastDot = uploadFileName.lastIndexOf(".");
        String fileNameWithoutExt = uploadFileName.substring(0, indexOfLastDot);
        String fileExt = uploadFileName.substring(indexOfLastDot);

        if (index == 1) {

            // 중복번호 1 설정
            uploadFileName = fileNameWithoutExt + " (" + index + ")" + fileExt;

        } else {

            // 중복번호 + 1 설정 (정규식 REPLACE 처리)
            String replaceUploadFileName = fileNameWithoutExt.replaceAll(" \\(([0-9]+)\\)", " (" + index + ")");
            uploadFileName = replaceUploadFileName + fileExt;

        }

        return getFileNameUntilNotExist(uploadPath, uploadFileName, index);
    }

    public void printFileInfo(MultipartFile file) {

        System.out.println("File Content Type : " + file.getContentType());

        Resource resource = file.getResource();
        System.out.println(resource);

        System.out.println("Original File Name : " + file.getOriginalFilename());
        System.out.println("File Name : " + file.getName()); // VIEW 에서 넘어오는 FILE TYPE NAME
        System.out.println("File Size : " + file.getSize());

        try {
            byte[] bytes = file.getBytes();
            System.out.println("File Byes : " + bytes.length);

            InputStream inputStream = file.getInputStream();
            System.out.println(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
