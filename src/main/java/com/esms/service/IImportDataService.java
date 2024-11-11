package com.esms.service;

import org.springframework.web.multipart.MultipartFile;

public interface IImportDataService {
    String insertMATable(MultipartFile excel) throws Exception;
    String insertReissueTable(MultipartFile excel) throws Exception;
}
