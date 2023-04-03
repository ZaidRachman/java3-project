package com.rachman.fun_stuff;

import se.michaelthelin.spotify.model_objects.specification.Track;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TrackServlet", value = "/tracks")
public class TrackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String albumId = request.getParameter("albumId");
        String albumName = request.getParameter("albumName");


        request.setAttribute("albumId", albumId);
        request.setAttribute("albumName", albumName);

        System.out.println(albumId);
        System.out.println(albumName);

        Track[] tracks = MySpotify.getTracks(albumName);
        request.setAttribute("tracks", tracks);
        request.getRequestDispatcher("WEB-INF/funstuff/track.jsp").forward(request,response);
    }


}
