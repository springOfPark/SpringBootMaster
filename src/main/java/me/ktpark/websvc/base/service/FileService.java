package me.ktpark.websvc.base.service;

import me.ktpark.websvc.base.model.FileModel;
import me.ktpark.websvc.config.spring.props.FileProperties;
import me.ktpark.websvc.utils.FileUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FileService {

    static final Logger log = LoggerFactory.getLogger(FileService.class);

    @Autowired
    private FileProperties fileProperties;

    @Autowired
    private FileUtility fileUtility;

    public List<FileModel> uploadFilesWithMultipartRequest(MultipartHttpServletRequest request) throws Exception {

        final String UPLOAD_PATH = fileProperties.getUploadPath();
        final String NOW_DATE = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        final String UPLOAD_FOLDER_PATH = String.format("%s/%s", UPLOAD_PATH, NOW_DATE);

        List<FileModel> fileModelList = new ArrayList<>();

        Iterator<String> fileNames = request.getFileNames();
        fileNames.forEachRemaining((inputKey) -> {

            List<MultipartFile> files = request.getFiles(inputKey);

            files.stream().filter((file) -> !file.isEmpty()).forEach((file) -> {

                fileUtility.printFileInfo(file);

                // 업로드 디렉토리가 없으면 디렉토리 생성
                File uploadFolder = new File(UPLOAD_FOLDER_PATH);
                if (!uploadFolder.exists()) {
                    uploadFolder.mkdir();
                }

                // 디렉토리에 해당하는 파일 이름이 이미 있으면 이름 뒤에 (n) 붙임
                String uploadFileName = fileUtility.getFileNameUntilNotExist(UPLOAD_FOLDER_PATH, file.getOriginalFilename());

                // 최종 업로드 풀경로
                String finalUploadFilePath = String.format("%s/%s", UPLOAD_FOLDER_PATH, uploadFileName);
                Path destination = Path.of(finalUploadFilePath);

                try {
                    // 파일 이동
                    file.transferTo(destination);
                } catch (AccessDeniedException e) {
                    throw new RuntimeException("업로드 하는 파일 크기가 0인지 확인해주시고, 디렉토리 권한을 확인해주세요.");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });

        });

        return fileModelList;
    }

}
