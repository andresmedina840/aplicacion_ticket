package co.com.andresmedina.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import co.com.andresmedina.dto.GitHubUserResponse;
import reactor.core.publisher.Mono;

@Service
public class GitHubService {

    private final WebClient webClient;

    public GitHubService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.github.com").build();
    }

    public Mono<GitHubUserResponse> searchUsers(String name) {
        return webClient.get()
                .uri("/search/users?q=" + name) 
                .retrieve()
                .bodyToMono(GitHubUserResponse.class);
    }
}

