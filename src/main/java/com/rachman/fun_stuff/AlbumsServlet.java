package com.rachman.fun_stuff;

import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AlbumsServlet", value = "/albums")
public class AlbumsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String artistId = request.getParameter("artistId");
        String artistName = request.getParameter("artistName");
        if(artistId == null){
            artistId = "Fail";
        }
        request.setAttribute("artistName", artistName);

        System.out.println(artistName);


        request.setAttribute("artistId", artistId);
        AlbumSimplified[] albums = MySpotify.getAlbum(artistName);

        request.setAttribute("albums", albums);
        request.getRequestDispatcher("WEB-INF/funstuff/album.jsp").forward(request,response);

    }


}
