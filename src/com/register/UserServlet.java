package com.register;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class UserServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private UserDAO userDao=new UserDAO();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
    	final Logger LOGGER = Logger.getLogger(UserServlet.class); 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher match = pattern.matcher(username);
        
        try 
        {
		if(username.equals("") || password.equals(""))
		{
			
			request.setAttribute("Message", "વપરાશકર્તા નામ અને પાસવર્ડ નલ હોઈ શકતા નથી !!");
			request.getRequestDispatcher("userregister.jsp").forward(request, response);
		}	
		
		else if(!match.matches())
		{
			request.setAttribute("Message", "માન્ય ઇમેઇલ સરનામું દાખલ કરો !!");
			request.getRequestDispatcher("userregister.jsp").forward(request, response);
		}
		
		else if(password.length() < 8 )
		{
			request.setAttribute("Message", "પાસવર્ડ 8 કરતા વધારે હોવો જોઈએ !!");
			request.getRequestDispatcher("userregister.jsp").forward(request, response);
		}
		
		else
	
		{
			 	Encryption encryptedPassword=new Encryption();
		        String updPassword=encryptedPassword.encrypt(password);
		        User user = new User();
		        user.setUsername(username);
		        user.setPassword(updPassword);
		        
				int resultSet=userDao.registerUser(user);
				if(resultSet>0) {
				request.setAttribute("successMessage", "નોંધણી થઈ, લoગ ઇન પર ક્લિક કરો !!");
				request.getRequestDispatcher("afterRegister.jsp").forward(request, response);
				LOGGER.debug("Registered succesfully");
				}
				else {
					request.setAttribute("Message", "નોંધણી કરી શકાતી નથી ડેટાબેઝ અથવા કોષ્ટકનું નામ ખોટું છે!!");
					request.getRequestDispatcher("userregister.jsp").forward(request, response);
				}
				} 
		}
        catch (ClassNotFoundException e) {
					e.printStackTrace();
				
        
		}
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String[] planguage = request.getParameter("language").split("_");
		String language = planguage[0];
		String country = planguage[1];
		Locale locale = new Locale(language, country);
		request.setAttribute("country", locale.getDisplayCountry());

		//
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		request.setAttribute("fnumber", numberFormat.format(1234567));

		//
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.conten", locale);
		request.setAttribute("fstring", resourceBundle.getString("message"));
		request.setAttribute("fform", resourceBundle.getString("form"));
		request.setAttribute("fusername", resourceBundle.getString("username"));
		request.setAttribute("fpassword", resourceBundle.getString("password"));
		request.setAttribute("fsave", resourceBundle.getString("save"));
		
				
		request.getRequestDispatcher("userregister.jsp").forward(request, response);
	}

//    <h3>Locale of ${country }</h3>
//	Format number: ${fnumber }
//	<br> Format String: ${fstring}
//	<br> Format String: ${fform}
    
}

