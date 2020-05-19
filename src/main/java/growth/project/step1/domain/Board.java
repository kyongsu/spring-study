package growth.project.step1.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Board
 */
@Getter
@Setter
public class Board {
   private Long id;           // 순번
   private String title;      // 제목
   private String writer;     // 작성자
   private String content;    // 내용
   private String regDate;    // 생성일자
   private String modDate;    // 수정일자
   private int viewCount;     // 조회 수
}