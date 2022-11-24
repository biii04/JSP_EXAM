package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.board.model.CommentDTO;
import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class CommentListController
 */
@WebServlet("/board/commentlist")
public class CommentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */  
    public CommentListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		SBoardDAO sdao = SBoardDAOImpl.getInstance();
	    ArrayList<CommentDTO> carr = 	sdao.findAllComment(bnum);
	    int count  = sdao.commentCount(bnum);
	    //gson.jar
	    Gson gson = new Gson();
	    Map<String, Object> hm = new HashMap<String, Object>();
	    hm.put("jarr", carr);
	    hm.put("count", count);
	    String jsonStr = gson.toJson(hm);
	    response.setContentType("application/json;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    out.print(jsonStr.toString());
	     
	    
//	    json-simple.jar
//		//mainObj(·çÆ®)
//	    JSONObject mainObj = new JSONObject();
//	    
//	    //countObj(°¹¼ö)
//	    JSONObject countObj = new JSONObject();
//	     countObj.put("count", count);
//	    
//	    //carr -->json
//	    JSONArray jarr = new JSONArray();
//	    for (CommentDTO com : carr) {
//	    	JSONObject obj = new JSONObject();
//	    	obj.put("userid", com.getUserid());
//	    	obj.put("bnum", com.getBnum());
//	    	obj.put("cnum", com.getCnum());
//	    	obj.put("regdate", com.getRegdate());
//	    	obj.put("msg", com.getMsg());
//	    	jarr.add(obj);
//	    }
//	    mainObj.put("countObj", countObj);
//	    mainObj.put("jarrObj", jarr);
//	    
//	    response.setContentType("application/json;charset=utf-8");
//	    PrintWriter out = response.getWriter();
//	    out.println(mainObj.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
