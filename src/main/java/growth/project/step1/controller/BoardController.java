package growth.project.step1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import growth.project.step1.domain.Board;
import growth.project.step1.utils.UserHandleException;

@RestController
@RequestMapping("/board")
public class BoardController {
   @Autowired
   private List<Board> boardList;

   @GetMapping("/total")
   public int getListCount() {
      return boardList.size();
   }

   @GetMapping("")
   public List<Board> findAll() {
      return boardList;
   }

   @GetMapping("/{id}")
   public Board findBoardDetail(@PathVariable Long id) throws UserHandleException {
      Integer checkId = this.getBoardListIndexOf(id);
      Board board = null;

      if (null == checkId) {
         throw new UserHandleException("존재하지 않는 번호입니다.");
      }

      board = boardList.get(checkId);
      board.setViewCount(board.getViewCount() + 1);

      return boardList.get(checkId);
   }

   @PostMapping(value = "")
   public Board saveBoard(@RequestBody Board board) {
      boardList.add(board);

      return board;
   }

   @PutMapping(value = "/{id}")
   public Board updateBoard(@PathVariable Long id, @RequestBody Board board) {
      boardList.set(this.getBoardListIndexOf(id), board);
      return board;
   }

   @DeleteMapping(value = "/{id}")
   public void deleteBoard(@PathVariable Long id) throws UserHandleException {
      Integer checkId = this.getBoardListIndexOf(id);

      if (null == checkId) {
         throw new UserHandleException("존재하지 않는 번호입니다.");
      }

      boardList.remove(checkId.intValue());
   }

   private Integer getBoardListIndexOf(Long id) {
      int index = 0;
      for (Board board : boardList) {
         if (board.getId().equals(id)) {
            return Integer.valueOf(index);
         }
         index++;
      }
      return null;
   }
}