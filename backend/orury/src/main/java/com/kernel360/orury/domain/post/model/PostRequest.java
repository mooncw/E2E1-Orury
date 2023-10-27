package com.kernel360.orury.domain.post.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostRequest {

	private Long id;
	private Long userId;
	private Long boardId;
	@NotBlank
	private String postTitle;
	@NotBlank
	private String userNickname;
	@NotBlank
	private String postContent;
}
