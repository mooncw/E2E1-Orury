package com.kernel360.orury.domain.post.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kernel360.orury.domain.comment.model.CommentDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDto {
	private Long id;
	private Long boardId;
	private String postTitle;
	private String postContent;
	private String userNickname;
	private int viewCnt;
	private int likeCnt;
	private boolean isDelete;
	private Long userId;//
	private String createdBy;
	private LocalDateTime createdAt;
	private String updatedBy;
	private LocalDateTime updatedAt;
	private List<CommentDto> commentList = List.of();
}
