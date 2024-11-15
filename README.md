![image](https://github.com/user-attachments/assets/290d2f69-7e46-4f4b-bec2-419424a89b4f)
# **Keeper**

## **프로젝트 소개**
서비스명 : Keeper

서비스 소개 : 익명성이 보장된 중학교 내 학교 폭력 신고 서비스

>학생 익명 신고 기능(텍스트 첨부 기능, 녹음)


### **주요 기능**
- **사용자 관리**
  - 새로운 사용자 생성.
  - 사용자가 작성한 게시물 목록 조회.

- **게시물 관리**
  - 게시물 생성(음성 파일 업로드 포함).
  - 게시물 상세 조회.
  - 게시물 삭제.

- **Teacher 기능**
  - 모든 게시물 텍스트(제목) 조회.
  - 특정 게시물의 상세 정보(작성자 포함) 조회.

---

## **기술 스택**
- **백엔드**: Spring Boot, Java
- **데이터베이스**: JPA (Hibernate 사용)
- **문서화**: Swagger (OpenAPI)
- **파일 처리**: MultipartFile (Spring 내장 기능 사용)
- **빌드 도구**: Gradle 또는 Maven (설치 시 따라 선택)

---

## **API 문서**

### **사용자 관리**

#### **POST /user**
- **설명**: 새로운 사용자를 생성합니다.
- **요청 예시**:
```json
{
  "username": "홍길동"
}
```
- **응답**: 201 Created

#### **GET /user/{userId}/list**
- **설명**: 특정 사용자가 작성한 게시물 목록을 조회합니다.
- **응답 예시**:
```json
[
  {
    "title": "게시물 제목 1"
  },
  {
    "title": "게시물 제목 2"
  }
]
```

### **게시물 관리**

#### **POST /post/create**
- **설명**: 새로운 게시물을 생성합니다.
- **요청 파라미터**:
  - `title`: 게시물 제목 (필수)
  - `file`: 업로드할 음성 파일 (선택)
- **응답**: 201 Created

#### **GET /post/detail/{postId}**
- **설명**: 게시물 ID를 기준으로 상세 정보를 조회합니다.
- **응답 예시**:
```json
{
  "postId": 1,
  "title": "Post 제목",
  "audioFilePath": "/uploads/audio.mp3"
}
```

#### **DELETE /post/delete/{postId}**
- **설명**: 게시물 ID를 기준으로 게시물을 삭제합니다.
- **응답**: 204 No Content

---

### **Teacher 기능**

#### **GET /teacher/posts**
- **설명**: 모든 게시물의 텍스트(제목)를 조회합니다.
- **응답 예시**:
```json
[
  "Post 제목 1",
  "Post 제목 2",
  "Post 제목 3"
]
```

#### **GET /teacher/posts/{postId}**
- **설명**: 특정 게시물의 상세 정보(작성자 이름 포함)를 조회합니다.
- **응답 예시**:
```json
{
  "postId": 1,
  "title": "Post 제목",
  "username": "사용자 이름"
}
```

---

## **프로젝트 구조**
```plaintext
├── src
│   ├── main
│   │   ├── java/com/example/shortcarton
│   │   │   ├── post
│   │   │   │   ├── controller
│   │   │   │   ├── dto
│   │   │   │   ├── entity
│   │   │   │   ├── repository
│   │   │   │   └── service
│   │   │   ├── user
│   │   │   │   ├── controller
│   │   │   │   ├── dto
│   │   │   │   ├── entity
│   │   │   │   ├── repository
│   │   │   │   └── service
│   │   │   ├── teacher
│   │   │   │   ├── controller
│   │   │   │   ├── entity
│   │   │   │   ├── repository
│   │   │   │   └── service
│   │   │   └── config
│   │   └── resources
│   │       └── application.properties
├── build.gradle
└── README.md
```

---

## **ERD (Entity-Relationship Diagram)**

### **다이어그램**
![shortcarton_erd_without_relationship](https://github.com/user-attachments/assets/03943fe7-af9f-47cf-bada-21cfa44279f0)


#### **User**
- `id` (Primary Key): 사용자 ID
- `username`: 사용자 이름

#### **Post**
- `id` (Primary Key): 게시물 ID
- `title`: 게시물 제목
- `audioFilePath`: 음성 파일 경로
- `user_id` (Foreign Key): 작성자 ID (User 테이블과 연결)

#### **Teacher**
- Teacher는 Post에 저장된 userId를 직접 이용하여 UserRepository를 통해 작성자를 조회하도록 설계.

---






