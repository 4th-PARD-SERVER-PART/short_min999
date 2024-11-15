package com.example.shortcarton.teacher.controller;

import com.example.shortcarton.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
@Tag(name = "Teacher 관리", description = "Teacher가 게시물을 조회할 수 있는 API")
public class TeacherController {

    private final PostService postService;

    @Operation(summary = "게시물 텍스트 목록 조회", description = "모든 게시물의 텍스트 목록을 조회합니다.")
    @GetMapping("/posts")
    public ResponseEntity<List<String>> listPostTexts() {
        List<String> postTexts = postService.getAllPostTexts();
        return ResponseEntity.ok(postTexts);
    }

    @Operation(summary = "게시물 상세 정보 조회", description = "선택된 게시물의 상세 정보를 조회합니다.")
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDetailDto> getPostDetail(@PathVariable Long postId) {
        PostDetailDto postDetail = postService.getPostDetail(postId);
        return ResponseEntity.ok(postDetail);
    }
}
