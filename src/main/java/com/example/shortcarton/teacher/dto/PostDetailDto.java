package com.example.shortcarton.teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailDto {
    private Long postId;
    private String title;  // 게시물 제목
    private String username; // 작성자 이름
}