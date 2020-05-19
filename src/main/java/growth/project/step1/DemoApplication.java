package growth.project.step1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import growth.project.step1.domain.Board;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	private List<Board> boardList;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping(value = "/")
	public String getMethodName(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping(value = "/test")
	public List<Board> getBoardList() {
		return boardList;
	}

	@GetMapping(value = "/test2")
	public List<Board> addBoardList() {
		Board board = new Board();
		board.setId(Long.valueOf("2"));
		board.setTitle("테스트2");
		board.setWriter("강경수");
		board.setRegDate("20200503");
		board.setContent("내용적었어요");

		boardList.add(board);

		return boardList;
	}
}
