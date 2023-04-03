package com.rachman.fun_stuff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SongServlet", value = "/song")
public class SongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trackId = request.getParameter("trackId");
        String trackName = request.getParameter("trackName");
        String albumName = request.getParameter("AlbumName");

        System.out.println(trackId);
        System.out.println(trackName);

        request.setAttribute("trackId", trackId);
        request.setAttribute("trackName", trackName);

        request.getRequestDispatcher("WEB-INF/funstuff/song.jsp").forward(request,response);


    }


}
