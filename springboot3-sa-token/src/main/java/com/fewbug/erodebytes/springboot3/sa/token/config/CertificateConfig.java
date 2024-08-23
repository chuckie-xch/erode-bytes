package com.fewbug.erodebytes.springboot3.sa.token.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Base64;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/22 18:42
 **/
@Component
public class CertificateConfig {

    @Value("classpath:certificate.cer")
    private Resource cerFile;

    private Certificate certificate;

    public Certificate getCertificate() throws CertificateException, IOException {
        if (certificate == null) {
            certificate = loadCertificate(cerFile);
        }
        return certificate;
    }

    private Certificate loadCertificate(Resource resource) throws CertificateException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            // 移除 BEGIN 和 END 以及换行符
            String certData = sb.toString().replaceAll("-----BEGIN CERTIFICATE-----|-----END CERTIFICATE-----|\\r?\\n", "");

            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            byte[] decoded = Base64.getDecoder().decode(certData);
            return cf.generateCertificate(new java.io.ByteArrayInputStream(decoded));
        }
    }

    public PublicKey getPublicKey() throws NoSuchAlgorithmException, CertificateException, IOException {
        Certificate cert = getCertificate();
        return cert.getPublicKey();
    }
}