package co.com.andresmedina.dto;

import lombok.Data;
import java.util.List;

@Data
public class GitHubUserResponse {
	
    private int total_count;
    private boolean incomplete_results;
    private List<GitHubUser> items;
    
}

