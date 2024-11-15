package com.example.shortcarton.teacher.service;

import com.example.shortcarton.post.entity.Post;
import com.example.shortcarton.post.repository.PostRepository;
import com.example.shortcarton.teacher.dto.PostDetailDto;
import com.example.shortcarton.user.entity.User;
import com.example.shortcarton.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<String> getAllPostTexts() {
        List<Post> posts = postRepository.findAll(); // 모든 Post 가져오기
        List<String> postTexts = new ArrayList<>();

        for (Post post : posts) {
            postTexts.add(post.getTitle()); // 제목을 리스트에 추가
        }

        return postTexts; // 제목 리스트 반환
    }


    public PostDetailDto getPostDetail(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        User user = post.getUser();
        return new PostDetailDto(post.getId(), post.getTitle(), user.getUsername());
    }
}
