import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDao=new UserDAO();

//    public void init() {
//    	userDao = new UserDAO();
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Validation validateObj=new Validation();
        boolean isValid=validateObj.validate(username, password);
        try {
        if(isValid) {
        Encryption encryptedPassword=new Encryption();
        String updPassword=encryptedPassword.encrypt(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(updPassword);
        userDao.registerUser(user);
        } 
        else{
//        	PrintWriter out = response.getWriter(); 
//        	out.println("<html><body><b>Enter Valid Details"+"</b></body></html>"); 
//        	
        }}
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

//        response.sendRedirect("employeedetails.jsp");
    }
}