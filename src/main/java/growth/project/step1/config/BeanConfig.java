package growth.project.step1.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import growth.project.step1.domain.Board;

@Configuration
public class BeanConfig {
   @Bean
   public List<Board> getBoardList(){
      List<Board> boardList = new ArrayList<>();

      Board board = new Board();
      board.setId(Long.valueOf("1"));
      board.setTitle("테스트1");
      board.setWriter("강경수");
      board.setRegDate("20200503");
      board.setContent("내용적었어요");

      boardList.add(board);

      return boardList;
   }
}