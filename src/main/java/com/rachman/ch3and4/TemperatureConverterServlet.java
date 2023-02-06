package com.rachman.ch3and4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TemperatureConverterServlet", urlPatterns ={"/temp" ,"/temp-converter"} )
public class TemperatureConverterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/temp.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tempToConvert = request.getParameter("tempInput");
        String UnitTemp = request.getParameter("UnitTemp");



        Map<String, String> results = new HashMap<>();
        try{
            if(UnitTemp.equals("fahrenheit")){

                results.put("temp",Double.toString((Double.parseDouble(tempToConvert) - 32)*(5/9.0)));
            } else{
                results.put("temp",Double.toString((Double.parseDouble(tempToConvert) *9/5.0) + 32));
            }
        }
        catch (NumberFormatException e){

        }

        results.put("UnitTemp", UnitTemp);
        results.put("temp1", tempToConvert);
        request.setAttribute("results", results);
        request.getRequestDispatcher("WEB-INF/temp.jsp").forward(request,response);
    }
}
