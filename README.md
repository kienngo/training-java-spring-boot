1. Cấu trúc dự án   
   back-end<demo>/
   │
   ├── src/
   │   └── main/
   │       ├── java/                           # mã nguồn Java để phát triển code behind
   │       │   ├── com.example.demo/
   │       │   ├── common/                     # Chứa các khối dữ liệu, các hàm sử dụng chung cho dự án
   │       │   ├── config/                     # Cấu hình Spring : exeption, security, swagger, mapping, ...
   │       │   ├── controller/                 # Controller của ứng dụng
   │       │   ├── domain/                     # Định nghĩa các entity và model(request, response)
   │       │   ├── repository/                 # Các repository (nếu sử dụng JPA)
   │       │   └── service/                    # Các dịch vụ (services)
   │       │
   │       └── resources/                      # Tài nguyên
   │           ├── db.migration/               # Chứa các file tài nguyên cơ sở dữ liệu
   │           ├── static/                     # Tài nguyên tĩnh (css, js, hình ảnh)
   │           ├── templates/                  # Templates của View (Thymeleaf, FreeMarker, ...)
   │           └── application.properties      # Cấu hình ứng dụng Spring Boot
   │
   ├── build/                                  # Thư mục chứa output từ build
   ├── build.gradle                            # File cấu hình plugin và dependencies của dự án
   ├── Dockerfile                              # File cấu hình docker image của dự án
   ├── README.md                               # Tài liệu mô tả dự án
   └── settings.gradle                         # File cấu hình dự án của Gradle
2. Quản lý phiên bản dependencies
   - spring-boot-starter-web                     # 3.3.4
   - lombok                                      # 1.18.34
   - spring-boot-starter-data-jpa                # 3.2.4
   - ojdbc8                                      # 19.3.0.0
   - hibernate-validator                         # 6.1.6.Final
   - spring-boot-starter-validation              # 3.3.4
   - hibernate-core                              # 6.4.4.Final
   - modelmapper                                 # 3.0.0
   - flyway-core                                 # 8.5.6
   - springdoc-openapi-starter-webmvc-ui         # 2.2.0
   - spring-boot-starter-test                    # 3.3.4
   - spring-cloud-azure-starter-active-directory # 5.16.0
   - spring-boot-starter-oauth2-client           # 3.3.4
   - spring-security-test                        # 6.3.3
   - spring-boot-starter-security                # 3.3.4