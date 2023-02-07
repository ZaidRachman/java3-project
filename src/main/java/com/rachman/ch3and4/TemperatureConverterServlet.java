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
        String unitTemp;
        String resultStr;
        if(request.getParameter("unitTemp") != null){
            unitTemp = request.getParameter("unitTemp");
        }
        else {
            unitTemp = "";

        }
        if(tempToConvert.equals("")){
            tempToConvert = "0";
        }




        Map<String, String> results = new HashMap<>();
        try{
            if(unitTemp.equals("celsius")){
                resultStr = String.format("%.3f",(Double.parseDouble(tempToConvert) - 32)*(5/9.0));
                if(Double.parseDouble(tempToConvert) <= -459.67){
                    results.put("invalidTempError","Number is to low");
                }
                else{
                    results.put("temp", resultStr + " degrees " + unitTemp);
                }

            } else if (unitTemp.equals("fahrenheit")){
                resultStr = String.format("%.3f",(Double.parseDouble(tempToConvert) *9/5.0) + 32);
                if(Double.parseDouble(tempToConvert) <= -273.15){
                    results.put("invalidTempError","Number is to low");
                }
                else{
                    results.put("temp", resultStr + " degrees " + unitTemp);
                }

            }
            else if(unitTemp.equals("")){
                results.put("unitTempError","Please pick a unit to convert to!");
            }
        }
        catch (NumberFormatException e){
            results.put("invalidTempError","Invalid Temperature!");

        }


        results.put("unitTemp", unitTemp);
        results.put("tempInput", tempToConvert);
        request.setAttribute("results", results);
        request.getRequestDispatcher("WEB-INF/temp.jsp").forward(request,response);
    }
}
