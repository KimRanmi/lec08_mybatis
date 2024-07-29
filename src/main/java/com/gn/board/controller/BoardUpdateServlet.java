package com.gn.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Board;


@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardUpdateServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("board_no"));
		String boardTitle = request.getParameter("board_title");
		String boardContent = request.getParameter("board_content");
		
		// 1. Board 객체에 no,title, content 정보 담기
		Board b = new Board();
		b.setBoard_no(boardNo);
		b.setBoard_title(boardTitle);
		b.setBoard_content(boardContent);
		// 2. Service -> Dao -> board-mapper.xml 통해 데이터 update
		int result = new BoardService().boardUpdate(b);
		// 3. board_title, board_content를 수정하면 되는데 기준은 board_no
		// 4. update 쿼리는 resultType이 무조건 int이므로 적지 않음.
		
		System.out.println(boardNo+" : "+boardTitle+" : "+boardContent);			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
