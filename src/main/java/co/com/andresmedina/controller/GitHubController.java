package co.com.andresmedina.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.com.andresmedina.dto.GitHubUserResponse;
import co.com.andresmedina.service.GitHubService;
import reactor.core.publisher.Mono;

@RestController
public class GitHubController {

    private final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/github/users")
    public Mono<GitHubUserResponse> getUsersByName(@RequestParam String q) {
        return gitHubService.searchUsers(q);
    }
}


