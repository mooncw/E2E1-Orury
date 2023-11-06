package com.kernel360.orury;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kernel360.orury.domain.board.controller.BoardController;
import com.kernel360.orury.domain.board.db.BoardEntity;
import com.kernel360.orury.domain.board.db.BoardRepository;
import com.kernel360.orury.domain.board.model.BoardDto;
import com.kernel360.orury.domain.board.model.BoardRequest;
import com.kernel360.orury.domain.board.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OruryApplicationTests {

	@Autowired
	BoardService boardService;

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper; // JSON 직렬화 및 역직렬화를 위한 ObjectMapper

	@Transactional
	@Test
	void createBoardTest() throws Exception {
		// 테스트할 데이터를 생성
		BoardRequest boardRequest = new BoardRequest();
		boardRequest.setBoardTitle("롤백됨??");

		// 컨트롤러 엔드포인트에 POST 요청을 보내고 결과를 검증
		MvcResult result = mockMvc.perform(post("/api/board") // 요청 URL을 수정
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(boardRequest)))
			.andExpect(status().isOk())
			.andReturn();

		// 응답 데이터를 가져와서 검증
		String responseContent = result.getResponse().getContentAsString();
		System.out.println(responseContent);
	}

//	@Test
//	void createBoardTest() {
//		BoardRequest boardRequest = new BoardRequest();
//		boardRequest.setBoardTitle("hard_test2");
//
//		BoardDto createBoardDto = boardService.createBoard(boardRequest);
//
//		assertEquals(boardRequest.getBoardTitle(), createBoardDto.getBoardTitle(), "불일치");
//	}

//	@Test
//	void createBoardTest() {
//		BoardRequest boardRequest = new BoardRequest();
//		boardRequest.setBoardTitle("hard_test3");
//
//		var entity = BoardEntity.builder()
//			.boardTitle(boardRequest.getBoardTitle())
//			.createdBy("admin")  // 임의로 "admin" 넣음
//			.createdAt(LocalDateTime.now())
//			.updatedBy("admin") // 임의로 "admin" 넣음
//			.updatedAt(LocalDateTime.now())
//			.build();
//
//		Long expected = entity.getId();
//
//		var saveEntity = boardRepository.save(entity);
//
//		Long actual = saveEntity.getId();
//
//		assertEquals(expected, actual, "불일치");

//	}
}
